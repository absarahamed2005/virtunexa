package com.flashcards.ui;

import com.flashcards.model.Flashcard;
import com.flashcards.service.FlashcardService;

import java.util.List;
import java.util.Scanner;

public class FlashcardUI {
    private final FlashcardService service = new FlashcardService();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n--- Flashcard App ---");
            System.out.println("1. Add Flashcard");
            System.out.println("2. Review Flashcards");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addFlashcard();
                case 2 -> reviewFlashcards();
                case 3 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void addFlashcard() {
        System.out.print("Enter question: ");
        String question = scanner.nextLine();
        System.out.print("Enter answer: ");
        String answer = scanner.nextLine();
        service.addFlashcard(new Flashcard(0, question, answer));
        System.out.println("Flashcard added!");
    }

    private void reviewFlashcards() {
        List<Flashcard> cards = service.getAllFlashcards();
        for (Flashcard card : cards) {
            System.out.println("Q: " + card.getQuestion());
            System.out.print("Press Enter to see the answer...");
            scanner.nextLine();
            System.out.println("A: " + card.getAnswer() + "\n");
        }
    }
}