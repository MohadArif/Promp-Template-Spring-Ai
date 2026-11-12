package com.example.prompttemplate.advisor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClientRequest;
import org.springframework.ai.chat.client.ChatClientResponse;
import org.springframework.ai.chat.client.advisor.api.CallAdvisor;
import org.springframework.ai.chat.client.advisor.api.CallAdvisorChain;

public class TotalTokenAdvisor implements CallAdvisor {

    private final Logger logger=LoggerFactory.getLogger(TotalTokenAdvisor.class);

    @Override
    public ChatClientResponse adviseCall(ChatClientRequest chatClientRequest, CallAdvisorChain callAdvisorChain) {
        logger.info("TotalTokenAdvisor: adviseCall called with request: {}", chatClientRequest.prompt().getContents());

        ChatClientResponse chatClientResponse = callAdvisorChain.nextCall(chatClientRequest);

        logger.info("TotalTokenAdvisor: advise response called with response: {}", chatClientResponse
                .chatResponse()
                .getMetadata()
                .getUsage()
                .getTotalTokens());

        return chatClientResponse;
    }

    @Override
    public String getName() {
        return "TotalTokenAdvisor";
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
