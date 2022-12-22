package org.example.swing;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TypingEngine extends KeyAdapter {

    String typed = "";
    char[] toType = "This is the first sentence!".toCharArray();
    int mistakesCount = 0;
    String mistakes = "";

    public TypingEngine() {
        System.out.println(new String(toType));

    }

    public void keyPressed(KeyEvent e) {
        typing(e.getKeyChar());
    }

    private void finishedTyping() {
        if (typed.length() == toType.length) {
            System.out.println("\rSuccess!");
            System.out.println("No. of mistakes: " + mistakesCount);
            if (!mistakes.isBlank()) {
                System.out.println("Mistakes: " + mistakes);
            }
        }
    }

    private void typing(char typedKey) {
        if (typed.length() < toType.length) {

            if (isNotTypo(typedKey)) {
                registerKey(typedKey);
            } else {
                registerTypo(typedKey);
            }

            if (typed.length() == toType.length) {
                finishedTyping();
            }
        }
    }

    private void registerKey(char typedKey) {
        typed += typedKey;
        System.out.print("\r" + typed);
    }

    private boolean isNotTypo(char typedKey) {
        return typedKey == toType[typed.length()];
    }

    private void registerTypo(char typedKey) {
        if (String.valueOf(typedKey).matches("[a-zA-Z]+")) {
            mistakesCount++;

            if (mistakes.isBlank()) {
                mistakes = String.valueOf(typedKey);
            } else {
                mistakes += "," + typedKey;
            }
        }
    }

    public String getCurrentSentence() {
        return new String(toType);
    }
}
