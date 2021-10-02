package com.example.serverwithembeddedclient.model;

public class GenericMessage {

    private String content;

    public GenericMessage() {
    }

    public GenericMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
