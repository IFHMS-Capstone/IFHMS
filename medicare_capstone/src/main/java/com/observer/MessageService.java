
package com.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.Authentication.User;

public class MessageService {
    private List<User> authenticatedUsers;
    private final List<Message> messages = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public MessageService (List<User> authenticatedUsers) {
        this.authenticatedUsers = authenticatedUsers;
    }

    public Message createMessage(User sender, User recipient, String content) throws Exception{
        if (!authenticatedUsers.contains(sender)) {
            throw new Exception("Sender not found");
        }
        if (!authenticatedUsers.contains(recipient)) {
            throw new Exception("Recipient not found");
        }

        long messageId = idGenerator.incrementAndGet();
        Message message = new Message(messageId, sender, recipient, content, System.currentTimeMillis());
        messages.add(message);
        return message;
    }


    public List<Message> getAllMessages() {
        return new ArrayList<>(messages); 
    }

    public List<Message> getMessagesForRecipient(User recipient) {
        List<Message> recipientMessages = new ArrayList<>();
        for (Message message : messages) {
            if (message.getRecipient().equals(recipient)) {
                recipientMessages.add(message);
            }
        }
        return recipientMessages;
    }
   
}