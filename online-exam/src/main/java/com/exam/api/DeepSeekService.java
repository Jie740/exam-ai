package com.exam.api;

import com.google.gson.*;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Slf4j
@Service
public class DeepSeekService {

    private final OkHttpClient client;
    private final Gson gson = new Gson();
    private final DeepSeekProperties props;

    public DeepSeekService(DeepSeekProperties props) {
        this.props = props;
        this.client = new OkHttpClient.Builder()
                .connectTimeout(30, java.util.concurrent.TimeUnit.SECONDS) // 连接超时
                .readTimeout(60, java.util.concurrent.TimeUnit.SECONDS)    // 读超时（等待服务器响应）
                .writeTimeout(60, java.util.concurrent.TimeUnit.SECONDS)   // 写超时（发送请求体）
                .build(); // 单例即可，Spring自动管理
    }

    /**
     * 与 DeepSeek 对话（上下文通过参数传入）
     */
    public String chat(List<Message> context, String userMessage) throws IOException {
        context.add(new Message("user", userMessage));

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "deepseek-chat");
        requestBody.put("messages", context);
        requestBody.put("temperature", 0.7);

        Request request = new Request.Builder()
                .url(props.getBaseUrl())
                .addHeader("Authorization", "Bearer " + props.getApiKey())
                .addHeader("Content-Type", "application/json")
                .post(RequestBody.create(
                        gson.toJson(requestBody),
                        MediaType.parse("application/json")
                ))
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                log.error("DeepSeek API Error: {}", response);
                throw new IOException("DeepSeek API error: " + response.code());
            }

            String responseBody = response.body().string();
            JsonObject jsonResponse = JsonParser.parseString(responseBody).getAsJsonObject();

            String reply = jsonResponse
                    .getAsJsonArray("choices")
                    .get(0)
                    .getAsJsonObject()
                    .getAsJsonObject("message")
                    .get("content")
                    .getAsString();

            context.add(new Message("assistant", reply));
            return reply;
        }
    }
}
