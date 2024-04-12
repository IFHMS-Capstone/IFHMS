
package com.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class MessageService {
    private final List<Message> messages = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public Message createMessage(String sender, String recipient, String content) {
        long messageId = idGenerator.incrementAndGet();
        Message message = new Message(messageId, sender, recipient, content, System.currentTimeMillis());
        messages.add(message);
        return message;
    }

    public List<Message> getAllMessages() {
        return new ArrayList<>(messages); // Return a copy to prevent external modification
    }

    public List<Message> getMessagesForRecipient(String recipient) {
        List<Message> recipientMessages = new ArrayList<>();
        for (Message message : messages) {
            if (message.getRecipient().equals(recipient)) {
                recipientMessages.add(message);
            }
        }
        return recipientMessages;
    }

    // Additional methods to handle message updates, deletions, etc.
}