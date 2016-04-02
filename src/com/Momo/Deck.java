package com.Momo;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Momo Johnson on 4/1/2016.
 */
public class Deck {
    //The Unicode characters for playing card symbols of Club, Spade, Diamond, and Hearts
    protected static final  String SPADES =String.valueOf((char) 9824);
    protected static final String CLUBS= String.valueOf((char) 9827);
    protected static final String DIAMONDS =  String.valueOf((char) 9829);
    protected static final String HEARTS = String.valueOf((char) 9830);
    protected String ANSI_BLACK = "\u001B[30m";
    protected String ANSI_RED = "\u001B[31m";
    protected String ANSI_RESET = "\u001B[0m";
    protected String ANSI_GREEN = "\u001B[32m";
    protected String ANSI_BLUE = "\u001B[34m";
    //Applying of color to the ANSI value of Club, Spade, Diamond and Hearts
    protected String club = ANSI_GREEN + CLUBS + ANSI_RESET;
    protected String spades = ANSI_BLACK + SPADES + ANSI_RESET;
    protected String diamond = ANSI_BLUE + DIAMONDS + ANSI_RESET;
    protected String heart = ANSI_RED + HEARTS + ANSI_RESET;


    //There are Unicode characters for playing card symbols

    // Creating a String of array to store cards number and shape data
    String[] numberList = {"Ace", "2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
    String[] shapeList = {diamond,heart,club,spades};

    // Creating a ArrayList "cards" to store the information of, which cards was made
    private ArrayList<Card> cards = new ArrayList<Card>();

    // Using a for loop to loop each cards number and shape data,
    // So that cards can be made one at time in "Card" and
    // Add that card in a ArrayList "cards" to store that card data
    public Deck(){

        for(int i = 0; i < shapeList.length; i++) {
            for(int j=0; j<numberList.length;j++){

                this.cards.add(new Card(shapeList[i],numberList[j]));
            }
        }
        // Shuffling the deck of cards
        Collections.shuffle(cards);

    }


    // Method to display the one card drawn
    public Card getOneCard()
    {
        System.out.println(cards.get(0));
        Card c = cards.get(0);
        cards.remove(0);
        return c;
    }



    //  method to draw a card from a deck
    public Card draw()
    {
        if(cards.size() ==0){

        }
            Card c = cards.get(0);
        cards.remove(0);
        return c;

    }

}
