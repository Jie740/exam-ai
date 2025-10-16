//package com.exam.config;
//
//import com.exam.domain.dto.MessageDto;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.ai.chat.memory.ChatMemory;
//import org.springframework.ai.chat.messages.*;
//import org.springframework.data.redis.core.StringRedisTemplate;
//
//import java.io.IOException;
//import java.util.Collections;
//import java.util.List;
//
//import static com.exam.constants.RedisConstant.CONVERSATION_ID_PREFIX;
//
//
//@RequiredArgsConstructor
//public class RedisMemory implements ChatMemory {
//    private final StringRedisTemplate stringRedisTemplate;
//    private final ObjectMapper objectMapper;
//    @Override
//    public void add(String conversationId, List<Message> messages) {
//        if (conversationId == null || conversationId.trim().isEmpty()) {
//            throw new RuntimeException("会话ID为空");
//        }
//        if (messages == null || messages.isEmpty()) {
//            throw new RuntimeException("消息为空");
//        }
////        序列化
//        List<String> messagesList = messages.stream()
//                .map(message -> {
//                    try {
//                        MessageType messageType = message.getMessageType();
//                        String text = message.getText();
//                        return objectMapper.writeValueAsString(new MessageDto(messageType.getValue(),text));
//                    } catch (JsonProcessingException e) {
//                        throw new RuntimeException("消息序列化失败" + e);
//                    }
//                })
//                .toList();
//        stringRedisTemplate.opsForList().
//                rightPushAll(CONVERSATION_ID_PREFIX+conversationId, messagesList);
//    }
//
//    @Override
//    public List<Message> get(String conversationId, int lastN) {
//        if (conversationId == null || conversationId.trim().isEmpty()) {
//            throw new RuntimeException("会话ID为空");
//        }
//        Long size = stringRedisTemplate.opsForList().size(CONVERSATION_ID_PREFIX + conversationId);
//        if(size==null||size==0){
//            return Collections.emptyList();
//        }
//        long start=Math.max(0,size-lastN);
//        List<String> messages = stringRedisTemplate.opsForList().range(CONVERSATION_ID_PREFIX + conversationId, start, size - 1);
//        return messages!=null?messages.stream()
//                .<Message>map(json -> {  //指定类型为Message
//                     try {
//                        MessageDto messageDto = objectMapper.readValue(json, MessageDto.class);
//                        return switch (messageDto.getMessageType()) {
//                            case "user" -> new UserMessage(messageDto.getText());
//                            case "assistant" -> new AssistantMessage(messageDto.getText());
//                            case "system" -> new SystemMessage(messageDto.getText());
////                            case "tool"-> new ToolMessage(messageDto.getText());
//                            default -> throw new RuntimeException("未知的消息类型: " + messageDto.getMessageType());
//                        };
//                    } catch (JsonProcessingException e) {
//                        throw new RuntimeException("消息反序列化失败" + e);
//                    } catch (IOException e) {
//                         throw new RuntimeException(e);
//                     }
//                })
//                .toList():Collections.emptyList();
//    }
//
//    @Override
//    public void clear(String conversationId) {
//        if (conversationId == null || conversationId.trim().isEmpty()) {
//            throw new RuntimeException("会话ID为空");
//        }
//        stringRedisTemplate.delete(CONVERSATION_ID_PREFIX+conversationId);
//    }
//}
