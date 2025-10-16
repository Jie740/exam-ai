//package com.exam.config;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.RequiredArgsConstructor;
//import org.springframework.ai.chat.client.ChatClient;
//import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
//import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
//import org.springframework.ai.chat.memory.ChatMemory;
//import org.springframework.ai.chat.model.ChatModel;
//import org.springframework.ai.ollama.OllamaChatModel;
//import org.springframework.ai.ollama.api.OllamaModel;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.core.StringRedisTemplate;
//
//@RequiredArgsConstructor
//@Configuration
//public class AiConfig {
//    private final StringRedisTemplate stringRedisTemplate;
//    private final ObjectMapper objectMapper;
//    @Bean
//    public ChatClient chatClient(ChatModel model){
//        return ChatClient
//                .builder(model)
//                .defaultAdvisors(
//                        new SimpleLoggerAdvisor(),
//                        new MessageChatMemoryAdvisor(this.chatMemory())
//                )
//                .build();
//    }
//
//    @Bean
//    public ChatMemory chatMemory(){
//        return new RedisMemory(stringRedisTemplate,objectMapper);
//    }
//}
