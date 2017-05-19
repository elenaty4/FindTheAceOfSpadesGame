/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findaceofspadesgame;

import java.util.Random;
import javax.swing.ImageIcon;

/**
 * This class provides the poker cards and tarot cards and function them
 * 
 * @author Elena Ngo, CS173.A
 * @version 1.7, Dec. 14 2015
 * 
 */
public class Cards {
    
    private String[] _pokerCards = {"AS.png", "2S.png", "3S.png", "4S.png", 
                                    "5S.png", "6S.png", "7S.png", "8S.png", 
                                    "9S.png", "10S.png","JS.png", "QS.png", 
                                    "KS.png", "AH.png", "2H.png", "3H.png", 
                                    "4H.png", "5H.png", "6H.png", "7H.png",
                                    "8H.png", "9H.png", "10H.png", "JH.png", 
                                    "QH.png", "KH.png", "AC.png", "2C.png", 
                                    "3C.png", "4C.png", "5C.png", "6C.png", 
                                    "7C.png", "8C.png", "9C.png", "10C.png", 
                                    "JC.png", "QC.png", "KC.png", "AD.png",
                                    "2D.png", "3D.png", "4D.png", "5D.png", 
                                    "6D.png", "7D.png", "8D.png", "9D.png", 
                                    "10D.png", "JD.png","QD.png", "KD.png", 
                                    "WJ.png", "BJ.png"};
    private String[] _faceDownCards;
    private String[] _tarotCards = {"1.png", "2.png", "3.png", "4.png", "5.png",
                                    "6.png", "7.png", "8.png", "9.png", "10.png",
                                    "11.png", "12.png", "13.png", "14.png","15.png", 
                                    "16.png", "17.png", "18.png", "19.png", "21.png",
                                    "21.png"};
    
    ImageIcon _tarotIcon;
    
    final int POKER_DECK_SIZE = 54;
    final int TAROT_DECK_SIZE = 21;
    
    int attempts = 0;
    String _tarotResult;
    final int FIRST_CARD = 0;
    
    //Tarot result description
    private String _theFool = "Your tarot card is 'The Fool' \n"
                    + " This means that new beginnings will happen in your life,"
                    + " because everyday is going to be an adventure for you. \n"
                    + " When you start on a new journey, you can't predict what's"
                    + " going to happen next but you'll know what your goal is. \n"
                    + " Each new journey comes a new goal. You'll experience a lot"
                    + " of things in your life. \n Have faith in yourself and strive"
                    + " for success!" 
                    + " \n \n Thank you for playing this game!";
    private String _theMagician = "Your tarot card is 'The Magician' \n"
                    + " This means that you will gain success in life because you"
                    + " use creative ways to reach your goals.\n As long as you're"
                    + " keeping that up you'll keep gaining success. Focus on one"
                    + " goal at a time when\n you have multiple goals to accomplish."
                    + " /n This is a good omen so stay optimistic and don't give up!"
                    + " \n \n Thank you for playing this game!";
    private String _theHighPriestess = "Your tarot card is 'The High Priestess' \n"
                    + " This means that the dreams you'll have in your life will be"
                    + " a sign of something as well as your intuition.\n Pay attention"
                    + " to your subconsciousness because this card is also a sign"
                    + " that your life is changing. \n Furthermore, this card tells"
                    + " you that in order to grow, you must accept your feminine "
                    + "side. This applies \n to males too. Each gender both have a"
                    + " female and male side."
                    + " \n \n Thank you for playing this game!";
    private String _theEmpress = "Your tarot card is 'The Empress' \n"
                    + " This indicates a lot of beauty and feminity in your life "
                    + " whether you are female or male because \n every gender have a"
                    + " male and female side. This means that a lot of people will"
                    + " be attacted \n to you whether it's love, family love, or "
                    + " friends. \n If you're female, this card is a sign that"
                    + " you'll be pregnant someday."
                    + " \n \n Thank you for playing this game!";
    private String _theEmperor = " Your tarot card is 'The Emperor' \n"
                    + " This means that you will follow your mind more than your"
                    + " rather than your heart.\n That's because you will be strategic"
                    + " and that uses up your mind. You will also be fastidious "
                    + " because you care about law and \n order that you think is right."
                    + " This makes you have leadership qualities in your life. This"
                    + " card can also mean that the laws control\n your life "
                    + "so you can't accomplish your goals unless the laws"
                    + " allow it."
                    + " \n \n Thank you for playing this game!";
    private String _theHierophant = "Your tarot card is 'The Hierophant' \n"
                    + " This means that you have religious beliefs in your life. "
                    + "Therefore, you're mostly likely going to be a religious "
                    + "person.\n You only follow the rules of your religion and nothing"
                    + " else.\n You'll worship and pray often. Not only will you respect"
                    + " your religion but you'll also respect your culture."
                    + " \n \n Thank you for playing this game!";
    private String _theLovers = "Your tarot card is 'The Lovers' \n"
                    + " This means that instead of having a religious belief, you"
                    + " have your own beliefs that you follow. \n You'll be cautious"
                    + " when you have to make decisions. This card also means that"
                    + " you'll find \n someone to love in your life or you'll fall in"
                    + " love, but you need to learn to love yourself first."
                    + "\n \n Thank you for playing this game!";
    private String _theChariot = "Your tarot card is 'The Chariot' \n"
                    + " This means that if you stay confident in yourself in life,"
                    + " you'll accomplish your goals. However you'll focus too hard \n"
                    + " on your goals and you'll be aggressive about it where you'll"
                    + " push anyone out of your way for it. This means that you'll \n"
                    + " also be very competitive and hate to lose. You'll also travel"
                    + " to a lot of places whether they are far away or nearby. "
                    + " \n \n Thank you for playing this game!";
    private String _strength = "Your tarot card is 'Strength' \n"
                    + " This means that you are about to endure difficulties in"
                    + " life and don't give up as you try to reach your goal. \n You"
                    + " have not physical strength, but inner strength, but if you"
                    + " already have physical strength then you also have inner \n"
                    + " strength. You are able to take responsibilities and take "
                    + " control in your life but only if you cooperate and work "
                    + " with others. \n Teamwork or companionship is needed in your "
                    + "life so try making some friends. 2 is better than 1. "
                    + " \n \n Thank you for playing this game!";
    private String _theHermit = "Your tarot card is 'The Hermit' \n"
                    + " This means that you'll want to know the meaning of your "
                    + "life and your purpose of living. \n Therefore, you'll be more "
                    + "of a loner where you turn your back on society and think "
                    + "about your own life. \n Being in a good relationship will not "
                    + "be easy but if you already are in a good relationship, it "
                    + "will not last longer. \n However, this card shows that you'll"
                    + "be able to understand yourself more."
                    + " \n \n Thank you for playinig this game!";
    private String _wheelOfFortune = "Your card is the 'Wheel of Fortune' \n"
                    + " This means that there will be ups and downs, good and bad"
                    + " things in your life. \n When misfortunes happen to you, try to"
                    + " improve your situation.\n If things happen in your life whether"
                    + " it's good or bad, they happen naturally \n which means it "
                    + "happens by chance.This card is the Wheel of Fortune after all."
                    + " \n \n Thank you for playing this game!";
    private String _justice = "Your card is 'Justice' \n"
                    + " This means that you'll have to make lot of life decisions."
                    + " \n You need to look for the truth and know the facts in order"
                    + " to make such decisions or else you'll be going down the wrong"
                    + " path.\n Life is full of choices but from this card, the"
                    + " choices you'll make could change your life."
                    + " \n \n Thank you for playing this game!";
    private String _theHangedMan = "Your card is 'The Hanged Man' \n"
                    + " This means that in you life, you are being restricted by"
                    + " something. \n Once you know what's restricting you, you need"
                    + " to break free from those bonds. \n Therefore, you'll be willing "
                    + " to make sacrifices in order to break free or accomplish \n your"
                    + " goals. In some cases, it could even cost your life. \n"
                    + " You're going to be brave."
                    + " \n \n Thank you for playing this game!";
    private String _death = "Your card is 'Death' \n"
                    + " This does not mean that you're going to die!\n This means"
                    + " that a phase in your life will come in an end and a new phase "
                    + " will begin.\n In order words, your life is going to transition."
                    + " This also means that you have to let\n go of old attachments"
                    + " when transitioning. "
                    + "\n \n Thank you for playing this game!";
    private String _temperance = "Your card is 'Temperance' \n"
                    + " This means that there is a lot of peace and tranquility in"
                    + " your life.\n Nothing very drastic will ever happen to you."
                    + " Even when bad things happened to you,\n there will always be"
                    + " a good and peaceful aftermath. Patience is essential.\n When"
                    + " you learn to be patient, you'll have better responsibility"
                    + " of your situations and goals."
                    + "\n \n Thank you for playing this game!";
    private String _theDevil = "Your tarot card is 'The Devil'\n"
                    + " This means that you are feeling despair, and restrained by your"
                    + " own faults.\n Your faults may include an addiction or obsession"
                    + " of something such as drugs, or unhealthy relationships.\n"
                    + " This will make you feel very pessimistic because such"
                    + " obsessions are preventing you from\n feeling optimistic. They"
                    + " are controlling your life. You need to find a way to break"
                    + " free\n of this restriction. This card is a warning be careful"
                    + " and do not obsess over something."
                    + "\n \n Thank you for playing this game!";
    private String _theTower = "Your card is 'The Tower' \n"
                    + " This means that you are feeling anxiety and insecure most"
                    + " of the time.\n This will cause you to have sleeping problems"
                    + " and nightmares, causing you to be tired a lot.\n You will also"
                    + " get in a depression when facing a struggle that causes you"
                    + " to be insecure.\n You have inner thoughts that you don't want"
                    + " to express. However, once you get over your\n insecurity,"
                    + " you'll feel more free."
                    + "\n \n Thank you for playing this game!";
    private String _theStar = "You tarot card is 'The Star' \n"
                    + " This means that you have survived through a difficult time"
                    + " in your life and now you're going\n to be able to relax and"
                    + " feel relief. This also means that you'll change the way"
                    + " you think and\n the way you feel, and have more trust in"
                    + " yourself. This will change your life too."
                    + "\n \n Thank you for playing this game!";
    private String _theMoon = "Your tarot card is 'The Moon' \n"
                    + " This means that you're going to meet your shadow, and become"
                    + " your shadow.\n Your fears will appear before you. You'll face"
                    + " the negative parts of your personality.\n You'll be quick to"
                    + " believe in false things, chase after them,"
                    + " and will lost and confused.\n This card will take you away"
                    + " from reality and you need to find an escape route."
                    + " \n \n Thank you for playing this game!";
    private String _theSun = "Your tarot card is 'The Sun' \n"
                    + " This means that your life is going smoothly. \n"
                    + " You are free from any restrictions, you are content, and"
                    + " you are confident.\n You are going to acheive your goals this"
                    + " way. This is sign that your life is going\n to get a lot better"
                    + " so prepare for the best!"
                    + " \n \n Thank you for playing this game!";
    private String _judgement = "Your tarot card is 'Judgement' \n"
                    + " This means that you're starting to realize the meaning of"
                    + " your life.\n The pieces are coming together. This also means"
                    + " that any misunderstangs or wounds that you\n received from "
                    + " your hardships will be healed. You'll be healed and refreshed"
                    + " to new start.\n This is the same as being forgiven from your"
                    + " sins."
                    + " \n \n Thank you for playing this game!";
    private String _theWorld = "Your tarot cards is 'The World' \n"
                    + " This means that you'll realize the meaning of your life, "
                    + " you'll know your purpose,\n and you'll complete a big"
                    + " accomplishment. It's as if your life is complete and\n you're"
                    + " just living through the good outcome."
                    + " \n \n Thank you for playing this game!";
    
    /**
     * Returns the array of poker cards
     * 
     * @return the poker card deck
     */
    public String[] getPokerDeck()
    {
        return _pokerCards;
    }
    
    /**
     * Returns the array of face down cards
     * 
     * @return the array of face down cards
     */
    public String[] getFaceDown()
    {
        _faceDownCards = new String[POKER_DECK_SIZE];
        
        for (int i = 0; i<POKER_DECK_SIZE; i++)
        {
            _faceDownCards[i] = "facedown.png";
        }
        
        return _faceDownCards;
    }
    
    /**
     * Shuffles any card deck by using the Fisher Yates shuffle.
     * 
     * @param deck the card deck that is being shuffled. 
     * @return the shuffled deck
     */
    public String[] shuffleDeck(String[] deck)
    {
        Random rand = new Random();
        int randomCard;
        String randomValue;
        
        
        for (int i = 0; i<deck.length; i++)
        {
            randomCard = rand.nextInt(deck.length);
            
            //the Fisher Yates shuffle
            randomValue = deck[randomCard]; 
            deck[randomCard] = deck[i];
            deck[i] = randomValue;
        }
        
        return deck;
    }
    
    /**
     * When the White Joker is clicked, the grid resets but the white joker 
     * remains faced up on its spot. 
     * Therefore, this method places the white joker on the spot it was clicked 
     * on in the _faceDownCards array, so that the white joker stays on its spot.
     * 
     * @param whiteJokerSpot the spot that the white joker was clicked on. The 
     * white joker will stay on that spot.
     * @return an array of faced down cards that has one.
     */
    public String[] whiteJokerReset(int whiteJokerSpot)
    {
        _faceDownCards = new String[POKER_DECK_SIZE];
        
        for (int i = 0; i<POKER_DECK_SIZE; i++)
        {
            //if i = whiteJokerNum, _faceDownCards[i] = "WJ.png"
            if (i == whiteJokerSpot)
            {
                _faceDownCards[i] = "WJ.png";   
            }
            else
            {
                _faceDownCards[i] = "facedown.png";
            }
        }
        
        return _faceDownCards;
    }
    
    /**
     * When the White Joker is clicked, the poker deck will shuffle as the grid 
     * resets, BUT this method makes the White Joker stay in its place in the 
     * poker deck. 
     * 
     * @param deck the card deck that is going to be shuffled
     * @param whiteJokerSpot the spot that the white joker was clicked on. It is
     * also the White Joker's spot in the poker deck. 
     * @return the shuffled deck with the White Joker in the same spot.
     */
    public String[] whiteJokerShuffle(String[] deck, int whiteJokerSpot)
    {
        //use the Fisher Yates shuffle
        Random rand = new Random();
        int randomCard;
        String randomValue;
        
        for (int i = 0; i<deck.length; i++)
        {
            
            if (i == whiteJokerSpot) //if index reaches the WhiteJoker Spot
            {
                //white joker stays
            }
            else
            {
                randomCard = rand.nextInt(deck.length);
              
                if (randomCard == whiteJokerSpot)//if randomCard is the white joker
                {
                    //it shouldn't be shuffled
                }
                else
                {
                    randomValue = deck[randomCard]; 
                    deck[randomCard] = deck[i];
                    deck[i] = randomValue;
                }
            }
        }
        
        return deck;
    }
    
    /**
     * Uses the number of attempts the user makes in the game and provides
     * one of the tarot card results depending on the number of attempts. 
     * If the tarot cards have to shuffle, the first tarot card from the 
     * shuffled deck will be the result
     * 
     * @param attempts the number of attempts the user makes in the game
     * @return the tarot card result
     * 
     */
    public String tarotResult(int attempts)
    { 
        if (attempts == 1)
        {
            _tarotResult = _theFool;
            _tarotIcon = new ImageIcon("0.png");
        }
        else if (attempts == 2)
        {
            _tarotResult = _theMagician;
            _tarotIcon = new ImageIcon("1.png");
        }
        else if (attempts == 3)
        {
            _tarotResult = _theHighPriestess; 
            _tarotIcon = new ImageIcon("2.png");
        }
        else if (attempts == 4)
        {
            _tarotResult = _theEmpress; 
            _tarotIcon = new ImageIcon("3.png");
        }
        else if (attempts == 5)
        {
            _tarotResult = _theEmperor;
            _tarotIcon = new ImageIcon("4.png");
        }
        else if (attempts == 6)
        {
            _tarotResult = _theHierophant;
            _tarotIcon = new ImageIcon("5.png");
        }
        else if (attempts == 7)
        {
            _tarotResult = _theLovers;
            _tarotIcon = new ImageIcon("6.png");
        }
        else if (attempts == 8)
        {
            _tarotResult = _theChariot; 
            _tarotIcon = new ImageIcon("7.png");
        }
        else if (attempts == 9)
        {
            _tarotResult = _strength;
            _tarotIcon = new ImageIcon("8.png");
        }
        else if (attempts == 10)
        {
            _tarotResult = _theHermit;
            _tarotIcon = new ImageIcon("9.png");
        }
        else if (attempts == 11)
        {
            _tarotResult = _wheelOfFortune;
            _tarotIcon = new ImageIcon("10.png");
        }
        else if (attempts == 12)
        {
            _tarotResult = _justice;
            _tarotIcon = new ImageIcon("11.png");
        }
        else if (attempts == 13)
        {
            _tarotResult = _theHangedMan;
            _tarotIcon = new ImageIcon("12.png");
        }
        else if (attempts == 14)
        {
            _tarotResult = _death;
            _tarotIcon = new ImageIcon("13.png");
        }
        else if (attempts == 15)
        {
            _tarotResult = _temperance;
            _tarotIcon = new ImageIcon("14.png");
        }
        else if (attempts == 16)
        {
            _tarotResult = _theDevil;
            _tarotIcon = new ImageIcon("15.png");
        }
        else if (attempts == 17)
        {
            _tarotResult = _theTower;
            _tarotIcon = new ImageIcon("16.png");
        }
        else if (attempts == 18)
        {
            _tarotResult = _theStar;
            _tarotIcon = new ImageIcon("17.png");
        }
        else if (attempts == 19)
        {
            _tarotResult = _theMoon;
            _tarotIcon = new ImageIcon("18.png");
        }
        else if (attempts == 20)
        {
            _tarotResult = _theSun;
            _tarotIcon = new ImageIcon("19.png");
        }
        else if (attempts == 21)
        {
            _tarotResult = _judgement;
            _tarotIcon = new ImageIcon("20.png");
        }
        else if (attempts == 22)
        {
            _tarotResult = _theWorld;
            _tarotIcon = new ImageIcon("21.png");
        }
        else if (attempts > 22)
        {
            //the tarot cards shuffle 
            shuffleDeck(_tarotCards);
            _tarotIcon = new ImageIcon(_tarotCards[FIRST_CARD]);
            _tarotResult = tarotDescription();
        }
        return _tarotResult;
    }
    
    /**
     * Returns the image of the tarot card that corresponds to the tarot card
     * result
     * 
     * @return the tarot card image 
     */
    public ImageIcon tarotImage()
    {
        return _tarotIcon;
    }
    
    /**
     * If the number of attempts is over 22, the tarot cards are shuffled and
     * this method is used to show the first random tarot in the array. 
     * 
     * @return the tarot result depending on what the 1st element of the 
     * shuffled tarot cards is. 
     */
    private String tarotDescription()
    {
        if (_tarotCards[FIRST_CARD] == "0.png")
        {
            _tarotResult = _theFool;
        }
        else if (_tarotCards[FIRST_CARD] == "1.png")
        {
            _tarotResult = _theMagician;
        }
        else if (_tarotCards[FIRST_CARD] == "2.png")
        {
            _tarotResult = _theHighPriestess; 
        }
        else if (_tarotCards[FIRST_CARD] == "3.png")
        {
            _tarotResult = _theEmpress; 
        }
        else if (_tarotCards[FIRST_CARD] == "4.png")
        {
            _tarotResult = _theEmperor;
        }
        else if (_tarotCards[FIRST_CARD] == "5.png")
        {
            _tarotResult = _theHierophant;
        }
        else if (_tarotCards[FIRST_CARD] == "6.png")
        {
            _tarotResult = _theLovers;
        }
        else if (_tarotCards[FIRST_CARD] == "7.png")
        {
            _tarotResult = _theChariot; 
        }
        else if (_tarotCards[FIRST_CARD] == "8.png")
        {
            _tarotResult = _strength;
        }
        else if (_tarotCards[FIRST_CARD] == "9.png")
        {
            _tarotResult = _theHermit;
        }
        else if (_tarotCards[FIRST_CARD] == "10.png")
        {
            _tarotResult = _wheelOfFortune;
        }
        else if (_tarotCards[FIRST_CARD] == "11.png")
        {
            _tarotResult = _justice;
        }
        else if (_tarotCards[FIRST_CARD] == "12.png")
        {
            _tarotResult = _theHangedMan;
        }
        else if (_tarotCards[FIRST_CARD] == "13.png")
        {
            _tarotResult = _death;
        }
        else if (_tarotCards[FIRST_CARD] == "14.png")
        {
            _tarotResult = _temperance;
        }
        else if (_tarotCards[FIRST_CARD] == "15.png")
        {
            _tarotResult = _theDevil;
        }
        else if (_tarotCards[FIRST_CARD] == "16.png")
        {
            _tarotResult = _theTower;
        }
        else if (_tarotCards[FIRST_CARD] == "17.png")
        { 
            _tarotResult = _theStar;
        }
        else if (_tarotCards[FIRST_CARD] == "18.png")
        {
            _tarotResult = _theMoon;
        }
        else if (_tarotCards[FIRST_CARD] == "19.png")
        {
            _tarotResult = _theSun;
        }
        else if (_tarotCards[FIRST_CARD] == "20.png")
        {
            _tarotResult = _judgement;
        }
        else if (_tarotCards[FIRST_CARD] == "21.png")
        {
            _tarotResult = _theWorld;
        }
        
        return _tarotResult;
    }
}
