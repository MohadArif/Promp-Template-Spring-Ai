package com.example.prompttemplate.config;

import com.example.prompttemplate.advisor.TotalTokenAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.advisor.ToolCallingAdvisor;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AiConfig {


    @Bean
    ChatClient openAiChatClient(OpenAiChatModel chatModel) {

        return ChatClient.builder(chatModel)
                .defaultAdvisors(new TotalTokenAdvisor()) // this is the custom advisor to log the total tokens used in the request and response
//                        new SimpleLoggerAdvisor()   // Add the SimpleLoggerAdvisor to log requests and responses
//                        ,new SafeGuardAdvisor(List.of("game"))) // SafeGuardAdvisor to block requests containing the word "game"/sencitive content
                .defaultOptions(
                        ChatOptions.builder()
                        .model("nvidia/nemotron-3-ultra-550b-a55b:free")
                        .temperature(0.7)
                        .maxTokens(1000)
                        )
                .build();
    }
}
