package com.observer;

import com.Authentication.User;

public class Message {
    private final long id;
    private final User sender;
    private final User recipient;
    private final String content;
    private final long timestamp;

    public Message(long id, User sender, User recipient, String content, long timestamp) {
        this.id = id;
        this.sender = sender;
        this.recipient = recipient;
        this.content = content;
        this.timestamp = timestamp;
    }

    // Getters for the fields
    public long getId() {
        return id;
    }

    public User getSender() {
        return sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public String getContent() {
        return content;
    }

    public long getTimestamp() {
        return timestamp;
    }
}