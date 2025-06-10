package com.example.websocket_chatapp;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        //sets up a broker where the /topic is a route the websocket server will broadcast messages to
        config.enableSimpleBroker("/topic");
        //sets the prefix for messages going to the control
        config.setApplicationDestinationPrefixes("/app");
    }

    //registers stomp endpoints
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //endpoint for websocket connection
        //http://localhost:8080/ws
        registry.addEndpoint("/ws").withSockJS();
    }
}
