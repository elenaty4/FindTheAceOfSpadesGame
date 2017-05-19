/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findaceofspadesgame;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

/**
 * This class forms a frame and puts the game components in it
 * 
 * @author Elena Ngo, CS173.A
 * @version 1.8, Dec. 14 2015
 * 
 */
public class GameFrame extends JFrame {
    
    private final int FRAME_WIDTH = 900;
    private final int FRAME_HEIGHT = 730;
    private int _attempts = 0;
    
    private GridLayout _buttonMatrix;
    private ImageIcon _image;
    private ImageIcon _faceDownImage;
    private JButton[] _button;
    private ActionListener _listener;
    private JPanel _gridPanel;
    
    
    private JOptionPane _introduction; //this pops up BEFORE the gamem starts
    private JOptionPane _endGameResult; //this ONLY pops up when the game ENDS
    
    //using the Cards class
    private Cards _cards;
    private String[] _pokerDeck;
    
    private JButton _whiteJoker;
    
    final int GRID_ROWS = 6;
    final int GRID_COLUMNS = 9;
    
    private String _badFortune = "Oh no, you clicked on the Black Joker! \nThis "
                               + "means that bad luck and misfortunes will come "
                               + "to you. \nBut don't worry, they won't happen to "
                               + "you for the rest of your life. \nHowever, it is "
                               + "not certain when the bad luck will stop."
                               + "\n \n Thank you for playing this game!";
    

    /**
     * The constructor that creates the frame with a default size
     */
    public GameFrame()
    { 
        frameComponents();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }
    
    /**
     * Puts the game components in the frame
     */
    private void frameComponents()
    {
        _cards = new Cards(); //invokes Cards class
        String[] faceDown = _cards.getFaceDown();
        _pokerDeck = _cards.getPokerDeck();
        
        
        //makes a matrix of JButtons
        _button = new JButton[_pokerDeck.length];
        _gridPanel = new JPanel(_buttonMatrix = new GridLayout(GRID_ROWS, GRID_COLUMNS));
        
        
        _listener = new ClickListener();
        
        //places FACE DOWN cards in the 6x9 grid first
        for (int i = 0; i<faceDown.length; i++)
        {
            _faceDownImage = new ImageIcon(faceDown[i]);
           
            _gridPanel.add(_button[i] = new JButton(_faceDownImage)); //adds to grid
           
            _button[i].addActionListener(_listener);
        }
        add(_gridPanel);
        
        //shuffle poker cards on the grid
        _cards.shuffleDeck(_pokerDeck);
    }
    

/**
 * This class listens to the user's clicks in the game
 */    
public class ClickListener implements ActionListener{

    
    @Override
    /**
     * Listens to the user's clicks in the game frame and makes things happen
     * when the user clicks on something.
     * 
     */
    public void actionPerformed(ActionEvent event)
    {
      
        for (int i=0; i<_button.length; i++)
        {
            if (event.getSource() == _button[i])
            {
                _image = new ImageIcon(_pokerDeck[i]);
              
                _button[i].setIcon(_image);
              
                _attempts++;
              
                int cardFaceUpSpot = i;
              
                if (_pokerDeck[i] == "WJ.png") //if White Joker is clicked
                {
                    //Everything resets
                    System.out.println("White Joker found");
                  
                    //saves off WJ spot so that the WJ doesn't move
                    int whiteJokerSpotNum = i; 
                
                    _gridPanel.removeAll();
                
                    _cards.whiteJokerShuffle(_pokerDeck, whiteJokerSpotNum);
                    String[] faceDown = _cards.whiteJokerReset(whiteJokerSpotNum);
                
                    for (int j = 0; j<faceDown.length; j++)
                    {
                        _faceDownImage = new ImageIcon(faceDown[j]);
                    
                        //adds to grid
                        _gridPanel.add(_button[j] = new JButton(_faceDownImage)); 
                  
                        //white joker should be in _faceDownImage array now
                        if (j == whiteJokerSpotNum)
                        {
                            //White Joker no longer gets a listener. Therefore,
                            //if you click on the White Joker again, it doesn't
                            //reset the cards again
                        }
                        else 
                        {
                            _button[j].addActionListener(_listener);
                        }
                    }
                    _gridPanel.revalidate();
                    _gridPanel.repaint();
                }
              
                if (_pokerDeck[i] == "BJ.png") //if Black Joker
                {
                    System.out.println("Black Joker found");
                    Object[] options = {"Close"};
                    //change OptionPane later
                    //create Tarot result method
                    JOptionPane.showOptionDialog(null, _badFortune, "You found the Black Joker", 
                            JOptionPane.PLAIN_MESSAGE, JOptionPane.WARNING_MESSAGE,
                            null, options, options[0]);
                    System.exit(0);   
                }
                if (_pokerDeck[i] == "AS.png") //if Ace of Spades
                {
                    System.out.println("Ace of Spades found");
                    String fortune = _cards.tarotResult(_attempts);
                    //tarot card image for JOptionPane
                    ImageIcon tarotCard = _cards.tarotImage();
                    Object[] options = {"Close"};
                    JOptionPane.showOptionDialog(null, fortune, "YOU FOUND THE ACE OF SPADES!", 
                            JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE,
                            tarotCard, options, options[0]);
                    System.exit(0);   
                }
              
            }//if get source
          
        
        }

    }
}

}
