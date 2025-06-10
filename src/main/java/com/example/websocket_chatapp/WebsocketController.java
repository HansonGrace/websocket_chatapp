package com.example.websocket_chatapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


//controller adaption to mark this class as the spring controller
//class handles web requests
@Controller
public class WebsocketController {
    private final SimpMessagingTemplate messagingTemplate;

    //inject required dependencies when making an instance with spring
    @Autowired
    public WebSocketController(SimpMessagingTemplate messagingTemplate){
        this.messagingTemplate = messagingTemplate;
    }

    //bind this method to /app/messages route
    //handles incoming messages
    @MessageMapping("/message")
    public void handleMessgae(Message message){
        // for debugging:
        System.out.println("Receieved message from user: " + message.getUser() + ": " + message.getMessage());
        messagingTemplate.convertAndSend("/topic/messages", message);
        System.out.println("Sent message to /topic/messages: " + message.getUser() +  ": " + message.getMessage());

    }

}
