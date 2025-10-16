package com.exam.api;

import cn.hutool.json.JSONUtil;
import com.exam.service.AnswerService;
import com.exam.util.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final AnswerService answerService;
    private final DeepSeekService deepSeekService;
    private final SystemPromptProvider systemPromptProvider;
    private final DeepSeekAsyncService deepSeekAsyncService;

    // 用 Map 保存每个用户的上下文（可换 Redis）
//    private final Map<String, List<Message>> userContext = new HashMap<>();
    //    @PostMapping("/{userId}")
//    public String chat(@PathVariable String userId, @RequestBody Map<String, String> body) throws IOException {
//        String input = body.get("message");
//        List<Message> context = userContext.computeIfAbsent(userId, k -> new ArrayList<>(
//                List.of(new Message("system", "你叫小智"))
//        ));
//
//        return deepSeekService.chat(context, input);
//    }
    private final List<Message> messages=new ArrayList<>();

    @PostMapping("/chat")
    public Result chat(@RequestBody GenerateForm generateForm) throws IOException {
        ArrayList<Message> messages = new ArrayList<>();
        messages.add(new Message("system", systemPromptProvider.getPrompt()));
        String userInput = JSONUtil.toJsonStr(generateForm);
        String response = deepSeekService.chat(messages, userInput);
//        return response;
        //写库操作
        return answerService.generateQuestions(generateForm,response);
    }
//@PostMapping("/chat")
//public Result chat(@RequestBody GenerateForm generateForm) {
//    // 提交任务到线程池异步执行
//    deepSeekAsyncService.generateQuestionsAsync(generateForm);
//    return Result.ok("题目生成中，请稍后刷新");
//}
}
