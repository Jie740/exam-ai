//package com.exam.service.impl;
//
//
//import cn.hutool.json.JSONUtil;
//import com.exam.domain.dto.MessageDto;
//import com.exam.domain.vo.MessageVo;
//import lombok.RequiredArgsConstructor;
//import org.springframework.ai.chat.client.ChatClient;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Service;
//import reactor.core.publisher.Flux;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Set;
//
//import static org.springframework.ai.chat.client.advisor.AbstractChatMemoryAdvisor.CHAT_MEMORY_CONVERSATION_ID_KEY;
//
//@Service
//@RequiredArgsConstructor
//public class ChatService {
//    private final ChatClient chatClient;
//    private final StringRedisTemplate stringRedisTemplate;
//
//    /**
//     *
//     * @param prompt 提示词
//     * @param conversationId 会话ID
//     * @return 流式输出
//     */
//
//    //对话
//    public Flux<String> chat(String prompt,String conversationId){
//        return chatClient.prompt()
//                .user(prompt)
//                .advisors(a->a.param(CHAT_MEMORY_CONVERSATION_ID_KEY, conversationId))
//                .stream()
//                .content();
//    }
//
//    /**
//     *
//     * @param conversationId 会话ID
//     * @return 会话内容集合
//     */
//
//    //获取某个会话的内容
//    public List<MessageVo> getConversationContent(String conversationId) {
//        List<String> messages = stringRedisTemplate.opsForList().range(CONVERSATION_ID_PREFIX+conversationId, 0, -1);
//        return messages.stream()
//                .map(json -> {
//                    MessageDto messageDto = JSONUtil.toBean(json, MessageDto.class);
//                    return new MessageVo(messageDto.getMessageType(), messageDto.getText());
//                })
//                .toList();
//    }
//
//
//    //删除会话
//    public void delete(String conversationId) {
//        stringRedisTemplate.delete(conversationId);
//    }
//
//    //获取会话列表
//    public List<String> getAllConversationId() {
//        Set<String> keys = stringRedisTemplate.keys(CONVERSATION_ID_PREFIX + "*");
//        if (keys != null) {
//            List<String> ids = keys.stream()
//                    .map(k -> k.replace(CONVERSATION_ID_PREFIX, ""))
//                    .toList();
//            return ids;
//        }
//        return Collections.emptyList();
//    }
//}
