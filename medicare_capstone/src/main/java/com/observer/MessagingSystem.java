package com.observer;

import java.util.List;
import java.util.Scanner;
import com.Authentication.User;

public class MessagingSystem {
    private final MessageService messageService;
    private final MessageNotifier notifier;
    private final Scanner scanner;
    private final List<User> users;

    public MessagingSystem(MessageService messageService, MessageNotifier notifier, Scanner scanner, List<User> users) {
        this.messageService = messageService;
        this.notifier = notifier;
        this.scanner = scanner;
        this.users = users;
    }

    public void start() throws Exception {
        while (true) {
            System.out.println("\n\n.....IHFMS MESSAGING SYSTEM.....");
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
                    System.out.println("Exiting messaging system. Goodbye! \n");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void sendMessage() throws Exception {
        System.out.print("Enter sender's username: ");
        String senderName = scanner.nextLine();
        System.out.print("Enter recipient's username: ");
        String recipientName = scanner.nextLine();

        User sender = findUserByName(senderName);
        User recipient = findUserByName(recipientName);

        if (sender == null) {
            System.out.println("Sender '" + senderName + "' not found.");
            return;
        }
        if (recipient == null) {
            System.out.println("Recipient '" + recipientName + "' not found.");
            return;
        }

        System.out.print("Enter message: ");
        String content = scanner.nextLine();

        Message message = messageService.createMessage(sender, recipient, content);
        notifier.notify(message);
        System.out.println("Message sent successfully.");
    }

    private void viewMessages() throws Exception {
        System.out.print("Enter your username to view messages: ");
        String recipientName = scanner.nextLine();

        User recipient = findUserByName(recipientName);
        if (recipient == null) {
            System.out.println("Recipient '" + recipientName + "' not found.");
            return;
        }

        List<Message> recipientMessages = messageService.getMessagesForRecipient(recipient);
        if (recipientMessages.isEmpty()) {
            System.out.println("No messages found for " + recipient.getUsername());
        } else {
            System.out.println("Messages for " + recipient.getUsername() + ":");
            for (Message msg : recipientMessages) {
                System.out.println(msg.getSender().getUsername() + ": " + msg.getContent() + " (at " + msg.getTimestamp() + ")");
            }
        }
    }

    private User findUserByName(String name) {
        return users.stream()
                    .filter(user -> user.getUsername().equals(name))
                    .findFirst()
                    .orElse(null);
    }
}