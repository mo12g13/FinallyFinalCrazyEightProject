package com.Momo;

/**
 * Created by Momo Johnson on 4/1/2016.
 */
public class Card {
    // initialize the variable
    String rank = "";
    String suits = "";
    

    // using constructor to make the single card
    public Card(String shape, String number){

        this.rank = shape;
        this.suits = number;
    }

    // method to make String variable card to help display the card on console
    public String toString(){
        return  suits +" of "+rank;
    }
}
