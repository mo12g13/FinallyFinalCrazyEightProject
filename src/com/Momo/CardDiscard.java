package com.Momo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Momo Johnson on 4/1/2016.
 */
public class CardDiscard {

    // Creating a ArrayList called "cardOnBoard" to store a cardOnBoard pile data
    ArrayList<Card> cardOnBoard = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);



    //A mehtod that add a card on the board.
    public void addCardonBoard(Card card) {
        if (cardOnBoard.isEmpty()){
            card = checkEightCard(card);
            this.cardOnBoard.add(card);
        }

        //A method that checks to see if the card that faceup on the board is equal to the suit or rank of card being play
        else {
            Card faceUp = cardOnBoard.get(0);
            if (faceUp.suits.equals(card.suits)) {

                card = checkEightCard(card);
                this.cardOnBoard.add(0, card);



            } else if (faceUp.rank.equals(card.rank)) {

                this.cardOnBoard.add(0, card);

            } else {
                System.out.println("Can not cardOnBoard! Has to be either " + faceUp.suits + " or " + faceUp.rank+ "\n");

            }
        }

    }



    //  display first card on the board
    public void firstCardOnBoard(){
        System.out.println(cardOnBoard.get(0));
    }


    //  A method that ask a user to choose a rank if he/she plays an 8
    private Card checkEightCard(Card card){
        if (card.suits == "8") {
            System.out.println("You have played an card 8 and it's crazy eight,\n" +
                    "What suit would you like to play? \n" +
                    "Please enter 'H' for Heart \n" +
                    "Please enter 'D'for  Diamond \n" +
                    "Please enter 'S' for Spade \n" +
                    "Please enter 'C'for Club \n");

            String chooseShape = scanner.next();

            if (chooseShape.equals("H")) {
                card.rank = "Heart";
            }

            else if (chooseShape.equals("D")) {
                card.rank = "Diamond";
            }

            else if (chooseShape.equals("S")) {
                card.rank = "Spade";
            }

            else if (chooseShape.equals("C")) {
                card.rank = "Club";
            }
            else {
                System.out.println("Select a suit to continue!");
            }

        }
        return card;
    }

}
