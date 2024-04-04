package com.observer;

public class ConsoleMessageNotifier implements MessageNotifier{
    @Override
    public void notify(Message message) {
        System.out.println("New message from " + message.getSender() + ": " + message.getContent());
    }
}
