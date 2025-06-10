package com.example.websocket_chatapp;

public class Message {
    private String user;
    private String message;

    public Message(){}
        public Message(String user, String message){
        this.user = user;
        this.message = message;
        }

    //helper functions
    public String getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    }

