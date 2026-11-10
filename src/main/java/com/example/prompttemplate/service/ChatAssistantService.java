package com.example.prompttemplate.service;

import org.apache.tomcat.util.file.ConfigurationSource;
import org.jspecify.annotations.Nullable;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.metadata.ChatResponseMetadata;
import org.springframework.ai.chat.metadata.Usage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Map;

@Service
public class ChatAssistantService {

    private final ChatClient chatClient;



    public ChatAssistantService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    /***
     *  this is just a simple prompt.
     */


//    public Flux<String> chatWithAi(String question) {
//
//        String prompt = """
//                your are a helpful medical assistant. You will be given a question and you will answer it in a concise manner.
//                 If you don't know the answer, just say "I don't know". Do not try to make up an answer.
//                """;
//        Prompt prompt1 = new Prompt(prompt);
//        return chatClient.prompt(prompt1)
//                .user(question)
//                .stream()
//                .content();
//    }


    /**
     * with the help of chatresponse we can get the metadata of the response
     * which contains the usage of the model and other information.
     */
//    public ChatResponseMetadata chatWithAi(String question) {
//
//        ChatResponseMetadata metadata = chatClient.prompt()
//                .user(question)
//                .call().chatResponse()
//                .getMetadata();
//        //         .getUsage();
//        //        .getModel()
//        //        .getRateLimit()
//        //        .getPromptMetadata()
//        System.out.println(metadata);
//        return metadata;
//    }


    /***
     *   1st way to use prompt template is to create a prompt template in the code itself.
     * @param question
     * @return
     */

    public String chatWithAi(String question) {

        PromptTemplate promptTemplate = new PromptTemplate(
                """
                        your are a helpful medical assistant. You will be given a {question} and you will answer it in a concise manner.
                 If you don't know the answer, just say "I don't know". Do not try to make up an answer.""");


        return chatClient.prompt(promptTemplate.create(Map.of("question", question)))
                .call()
                .content();
    }







    /***
     * 2nd way to use prompt template is to create a prompt template in a separate file and load it using @Value annotationP.
     * this is a more advanced prompt using the prompt template.
     * The prompt template is a way to create a prompt with variables.
     * The variables are replaced with the values provided in the map.
     * By Create separate prompt template file we can create more complex prompts and reuse them (recommendation).
     */

//    @Value("classpath:/prompts/medical-assistant.st")
//    private Resource medicalAssistant;
//
//    public String chatWithAi(String question) {
//
//        PromptTemplate promptTemplate = new PromptTemplate(
//               medicalAssistant);
//
//
//        return chatClient.prompt(promptTemplate.create(Map.of("question", question)))
//                .call()
//                .content();
//    }
}
