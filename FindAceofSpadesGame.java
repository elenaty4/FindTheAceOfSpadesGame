/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findaceofspadesgame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 * This program creates a frame that holds a game called "Find the Ace of Spades"
 * It is a game that I made up. The rules of the game will be shown when you 
 * start the game.
 * 
 * This class is the driver that calls the other classes 
 * 
 * @author Elena Ngo, CS173.A
 * @version 1.0, Dec. 14 2015

 */
public class FindAceofSpadesGame {
    
    /**
     * Puts up a introduction and game rules for the user to read when the game
     * starts
     * 
     * @param frame the frame that the introduction is used for
     */
    public static void introduction(JFrame frame)
    {
        String introduction = "Welcome to the Ace of Spades finder game! \nHere's"
                + " how to play: \n 1. Find the Ace of Spades by clicking on the"
                + " faced down cards. \n     If you found the Ace of Spades card,"
                + " you'll receive a tarot fortune and the game ends. \n \n 2. If"
                + " you found a White Joker, the game resets but the White Joker"
                + " remains faced up on its spot. \n \n"
                + " 3. If you found the Black Joker, you'll get a bad fortune"
                + " and the game ends.";
        
        ImageIcon introIcon = new ImageIcon("iconAS.png");
        Object[] options = {"Play"};
        JOptionPane.showOptionDialog(frame, introduction, "How to Play",
                JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE,
                introIcon, options, options[0]);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFrame frame = new GameFrame();
        introduction(frame);
        frame.setTitle("Find the Ace of Spades");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); //visibility of the frame. True makes it visible
    }
    
}
