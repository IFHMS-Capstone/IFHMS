package com.observer;

import java.util.List;
import java.util.Scanner;

public class MessagingSystem {
    private final MessageService messageService;
    private final MessageNotifier notifier;
    private final Scanner scanner;

    public MessagingSystem(MessageService messageService, MessageNotifier notifier, Scanner scanner) {
        this.messageService = messageService;
        this.notifier = notifier;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            System.out.println("Messaging System");
            System.out.println("1. Send a message");
            System.out.println("2. View messages");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    sendMessage();
                    break;
                case "2":
                    viewMessages();
                    break;
                case "3":
                    System.out.println("Exiting messaging system.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void sendMessage() {
        System.out.print("Enter sender's name: ");
        String sender = scanner.nextLine();

        System.out.print("Enter recipient's name: ");
        String recipient = scanner.nextLine();

        System.out.print("Enter message: ");
        String content = scanner.nextLine();

        Message message = messageService.createMessage(sender, recipient, content);
        notifier.notify(message);
    }

    private void viewMessages() {
        System.out.print("Enter your name to view messages: ");
        String recipient = scanner.nextLine();

        List<Message> recipientMessages = messageService.getMessagesForRecipient(recipient);
        System.out.println("Messages for " + recipient + ":");
        for (Message msg : recipientMessages) {
            System.out.println(msg.getSender() + ": " + msg.getContent() + " (at " + msg.getTimestamp() + ")");
        }

        System.out.print("Would you like to reply to a message? (yes/no): ");
        String reply = scanner.nextLine();
        if ("yes".equalsIgnoreCase(reply)) {
            System.out.print("Enter the ID of the message you want to reply to: ");
            long messageId = Long.parseLong(scanner.nextLine());
            // Find the message by ID and set the recipient as the original sender
            for (Message msg : recipientMessages) {
                if (msg.getId() == messageId) {
                    System.out.print("Enter your reply: ");
                    String replyContent = scanner.nextLine();
                    Message replyMessage = messageService.createMessage(recipient, msg.getSender(), replyContent);
                    notifier.notify(replyMessage);
                    break;
                }
            }
        }
    }
}