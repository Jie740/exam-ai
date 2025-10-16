//package com.exam.controller;
//
//
//import com.exam.domain.vo.MessageVo;
//import com.exam.service.impl.ChatService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//import reactor.core.publisher.Flux;
//
//import java.util.List;
//
//
//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/ai")
//public class AiController {
//
//    private final ChatService chatService;
//
//    @GetMapping("/getAllConversationId")
//    public List<String> getAllConversationId() {
//        return chatService.getAllConversationId();
//    }
//    @PostMapping(value = "/chat",produces = "text/html;charset=utf-8")
//    public Flux<String> chat(
//            @RequestParam("prompt") String prompt
//            ,@RequestParam("conversationId") String conversationId) {
//        return chatService.chat(prompt,conversationId);
//    }
//
//    @GetMapping("/getConversation/{conversationId}")
//    public List<MessageVo> getConversation(@PathVariable("conversationId") String conversationId) {
//        return chatService.getConversationContent(conversationId);
//    }
//
//    @DeleteMapping("/deleteConversation/{conversationId}")
//    public void deleteConversation(@PathVariable("conversationId") String conversationId) {
//        chatService.delete(conversationId);
//    }
//}
