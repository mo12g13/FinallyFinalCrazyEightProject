package com.Momo;

/**
 * Created by Momo Johnson on 4/1/2016.
 */
public class HumanPlayer {
    String playerName;
    // constructor for the playerName
    public HumanPlayer(){
        this.playerName = playerName;
    }

    Hand hand = new Hand();//Creating a new hand object to add card to it


//A method that sets the name of the player;
    // method to get player name
    public String getPlayerName() {
        return playerName;
    }

    //  method to set the player name
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    // method to fill the player hand with card
    public void addCardToHand(Card card) {
        this.hand.addCard(card);//Calling a method from the hand class to fill the player hand with cards




    }
}
