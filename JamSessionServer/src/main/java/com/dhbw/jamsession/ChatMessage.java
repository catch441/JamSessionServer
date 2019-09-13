package com.dhbw.jamsession;

import com.dhbw.jamsession.music.EnumMessageType;

public class ChatMessage {
    private EnumMessageType type;
    private String content;
    private String sender;

    public EnumMessageType getType() {
        return type;
    }

    public void setType(EnumMessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
