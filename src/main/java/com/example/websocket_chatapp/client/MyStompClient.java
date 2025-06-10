package com.example.websocket_chatapp.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

public class MyStompClient {

    private StompSession session;
    private String username;

    public MyStompClient(String username){
        this.username = username;

        List<Transport> transports = new ArrayList<>();
        transports.add(new WebSocketTransport(new StandardWebSocketClient()));

        SockJsClient sockJsClient = new SockJsClient(transports);

        //takes jsclient and allows it to use stomp protocol
        WebSocketStompClient stompClient = new WebSocketStompClient(sockJsClient);
        //alows stomp client to auto convert java objects to json data
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());

    }
}
