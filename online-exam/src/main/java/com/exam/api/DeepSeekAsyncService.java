package com.exam.api;

import cn.hutool.json.JSONUtil;
import com.exam.service.AnswerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DeepSeekAsyncService {
    private final DeepSeekService deepSeekService;
    private final AnswerService answerService;
    private final SystemPromptProvider systemPromptProvider;

    private final ExecutorService executor = Executors.newFixedThreadPool(4);

    public void generateQuestionsAsync(GenerateForm form) {
        executor.submit(() -> {
            try {
                ArrayList<Message> messages = new ArrayList<>();
                messages.add(new Message("system", systemPromptProvider.getPrompt()));
                String userInput = JSONUtil.toJsonStr(form);
                String response = deepSeekService.chat(messages, userInput);
                answerService.generateQuestions(form, response);
            } catch (Exception e) {
                log.error("异步生成题目失败", e);
            }
        });
    }
}
