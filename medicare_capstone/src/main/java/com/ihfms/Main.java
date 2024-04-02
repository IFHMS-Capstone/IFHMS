package com.ihfms;

import java.util.Scanner;

import com.observer.ConsoleMessageNotifier;
import com.observer.MessageNotifier;
import com.observer.MessageService;
import com.observer.MessagingSystem;

public class Main {
    public static void main(String[] args) {
        MessageService messageService = new MessageService();
        MessageNotifier notifier = new ConsoleMessageNotifier();
        Scanner scanner = new Scanner(System.in);

        MessagingSystem messagingSystem = new MessagingSystem(messageService, notifier, scanner);
        messagingSystem.start();

        scanner.close();
    }
}