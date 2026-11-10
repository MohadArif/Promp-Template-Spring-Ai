package com.example.prompttemplate.controller;

import com.example.prompttemplate.service.ChatAssistantService;
import org.springframework.ai.chat.metadata.ChatResponseMetadata;
import org.springframework.ai.chat.metadata.Usage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/chat")
public class ChatAssistantController {

    private final ChatAssistantService chatAssistantService;

    public ChatAssistantController(ChatAssistantService chatAssistantService) {
        this.chatAssistantService = chatAssistantService;
    }


//    @GetMapping("/ask/{question}")
//    public Flux<String> chatWithAi(@PathVariable String question){
//        return chatAssistantService.chatWithAi(question);
//    }


//    @GetMapping("/ask/{question}")
//    public ChatResponseMetadata chatWithAi(@PathVariable String question){
//        return chatAssistantService.chatWithAi(question);
//    }


        @GetMapping("/ask/{question}")
    public String chatWithAi(@PathVariable String question){
        return chatAssistantService.chatWithAi(question);
    }
}
