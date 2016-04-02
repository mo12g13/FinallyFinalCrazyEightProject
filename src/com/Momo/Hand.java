package com.Momo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Momo Johnson on 4/1/2016.
 */
public class Hand {

    // Creating a ArrayList called "cardsInHand" to store player's hand
    ArrayList<Card> playerHand = new ArrayList<Card>();



    //  method to add the card to the player's hand
    public void addCard(Card card){
        this.playerHand.add(card);
    }


    // method to display the player's hand on console and asking to user to choose a card that user
    // like to play for the game


    //A method that display the cards in the hand of the player and check to make sure only cards in the hand are played
    public int displayHand() {


        while (true) {

            int cardInHand = 0;//Card is zero for the ininital start of the game

            Scanner scanner = new Scanner(System.in);


            //
            for (Card cards : playerHand) {

                System.out.println(String.format("Enter %d %s", cardInHand + 1, cards.toString()));
                cardInHand++;
            }

            System.out.println("Enter the number on the right to play the card.");
            int choice = scanner.nextInt() - 1;

            // A condition that checks to make sure a player doesn't enter a number outside the hand being display
            if (choice < playerHand.size() && choice >= 0) {


                return choice;
            }

            else
            {
                System.out.println("Please enter the right number on the right of card being display!! Example Enter 1 means you should enter the number \"1\"");

            }


        }
    }


    //A method that discard cards rom the player hand after the card is being played
    public Card discardCard (int num){

        Card discadedCard = playerHand.get(num);
        playerHand.remove(num);

        return discadedCard;
    }
}
