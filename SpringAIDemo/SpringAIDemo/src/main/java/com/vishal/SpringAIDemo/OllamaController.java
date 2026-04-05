package com.vishal.SpringAIDemo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.ai.chat.client.ChatClient;

@RestController
@RequestMapping("/api/ollama")
public class OllamaController {

    private ChatClient chatClient;


    //construction injection
    public OllamaController(OllamaChatModel chatModel)
    {this.chatClient=ChatClient.create((ChatModel) chatModel);}

    @GetMapping("/{message}")
    public ResponseEntity<String> getAnswer(@PathVariable String message){
        String response=chatClient.prompt(message).call().content();

        return ResponseEntity.ok(response);
    }


}
