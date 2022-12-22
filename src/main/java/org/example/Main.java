package org.example;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {

    static String typed = "";
    static char[] toType = "This is the first sentence!".toCharArray();
    static int mistakesCount = 0;

    static String mistakes = "";

    public static void main(String[] args) {
        JFrame myJFrame = new JFrame();

        System.out.println(new String(toType));
        myJFrame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {

                char typedKey = e.getKeyChar();

                if (typed.length() < toType.length) {

                    if (isNotTypo(typedKey)) {
                        registerKey(typedKey);
                    } else {
                        registerTypo(typedKey);
                    }

                    if(typed.length() == toType.length){
                        finishedTyping();
                    }
                }
            }
        });

        myJFrame.setVisible(true);
    }

    private static void registerKey(char typedKey) {
        typed += typedKey;
        System.out.print("\r" + typed);
    }

    private static boolean isNotTypo(char typedKey) {
        return typedKey == toType[typed.length()];
    }

    private static void registerTypo(char typedKey) {
        if (String.valueOf(typedKey).matches("[a-zA-Z]+")) {
            mistakesCount++;

            if (mistakes.isBlank()) {
                mistakes = String.valueOf(typedKey);
            } else {
                mistakes += "," + typedKey;
            }
        }
    }

    private static void finishedTyping() {
        if (typed.length() == toType.length) {
            System.out.println("\rSuccess!");
            System.out.println("No. of mistakes: " + mistakesCount);
            if (!mistakes.isBlank()) {
                System.out.println("Mistakes: " + mistakes);
            }
        }
    }
}