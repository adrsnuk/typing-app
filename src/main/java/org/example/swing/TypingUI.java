package org.example.swing;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;

public class TypingUI {
    private TypingEngine typingEngine;

    private JFrame ui;

    public TypingUI(String title){
        ui = new JFrame(title);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JLabel label = new JLabel("Test label");
        label.setBorder(new LineBorder(Color.BLUE, 2)); //Adding a border for clarity.

        //Most significant two lines of code:
        final JPanel containerPanel = new JPanel(new GridBagLayout());
        containerPanel.add(label);

        ui.setContentPane(containerPanel);
        ui.pack();
        ui.setLocationRelativeTo(null);
        ui.setVisible(true);
        showOnScreen(1,ui);
    }

    public static  void showOnScreen( int screen, JFrame frame )
    {
        GraphicsEnvironment ge = GraphicsEnvironment
                .getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        if( screen > -1 && screen < gs.length )
        {
            gs[screen].setFullScreenWindow( frame );
        }
        else if( gs.length > 0 )
        {
            gs[0].setFullScreenWindow( frame );
        }
        else
        {
            throw new RuntimeException( "No Screens Found" );
        }
    }

}
