package com.example.prompttemplate.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {


    @Bean
    ChatClient openAiChatClient(OpenAiChatModel chatModel) {

        return ChatClient.builder(chatModel)
                .defaultAdvisors(new SimpleLoggerAdvisor())  // Add the SimpleLoggerAdvisor to log requests and responses
                .defaultOptions(
                        ChatOptions.builder()
                        .model("nvidia/nemotron-3-ultra-550b-a55b:free")
                        .temperature(0.7)
                        .maxTokens(1000)
                        )
                .build();
    }
}
