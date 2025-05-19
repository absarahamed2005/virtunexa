package com.flashcards.service;

import com.flashcards.db.DatabaseManager;
import com.flashcards.model.Flashcard;

import java.util.List;

public class FlashcardService {
    private final DatabaseManager db = new DatabaseManager();

    public void addFlashcard(Flashcard card) {
        db.insertFlashcard(card);
    }

    public List<Flashcard> getAllFlashcards() {
        return db.getAllFlashcards();
    }
}