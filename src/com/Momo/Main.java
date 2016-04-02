package com.Momo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);

        // creating a instances for other classes
        Deck totalCards = new Deck();
        HumanPlayer humanPlayer = new HumanPlayer();
        HumanPlayer computerPlayer = new HumanPlayer();
        CardDiscard totalDisCard = new CardDiscard();



        System.out.println("What is the human Player name: ");
        String humanplayerName = scanner.nextLine();
        humanPlayer.setPlayerName(humanplayerName);//Setting the name of the human player


        System.out.println("What is the name of the computer player");
        String compName = scanner.nextLine();
        computerPlayer.setPlayerName(compName);//Setting the name of the computer player


        System.out.println("Welcome to crazy eight "+ humanPlayer.getPlayerName() + " !!!... . You are going to play aganst the computer\n" +
                "Human Player Name: "+ humanPlayer.getPlayerName() + "\n"+ "Computer Player Name: "+ computerPlayer.getPlayerName());

        //Scanner scanner = new Scanner(System.in);

        // filling the two players hand with 7 cards to start the game
        for(int i = 0; i < 7; i++) {
            humanPlayer.addCardToHand(totalCards.draw());
            computerPlayer.addCardToHand(totalCards.draw());
        }

        // drawing a first card from a deck for a cardOnBoard to play the game
        totalDisCard.addCardonBoard(totalCards.draw());
        // Calling a method name "play"
        play(humanPlayer, computerPlayer, totalDisCard, totalCards);    }

    // play method with 4 parameters
    public static void play(HumanPlayer humanPlayer, HumanPlayer computerPlayer, CardDiscard totalDisCard, Deck totalCards){
        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println(humanPlayer.getPlayerName() + " This is your hand: ");

            System.out.print(humanPlayer.hand.playerHand);
            System.out.println("\nCard on Board: ");
            totalDisCard.firstCardOnBoard();
            System.out.println("\nWhat you want to do?");


            // Given a user a choice to Play, Draw and Pass for the hand
            // With validation for the user entry
            int choicePlayer;
            do {
                System.out.println("1 - Play\n2 - Draw\n3 - Pass?");
                while (!scanner.hasNextInt()) {
                    System.out.println("That's not a number!");
                    scanner.next();
                }
                choicePlayer = scanner.nextInt();
            } while (choicePlayer <= 0 || choicePlayer > 3);


            // If user choose to play, it will display hand for the users card,
            //  Use will have a choice to pick a card to cardOnBoard from the hand
            //  And add the user cardOnBoard card to the cardOnBoard pile

            if (choicePlayer == 1) {

                int indexHand = humanPlayer.hand.displayHand();
                Card toDiscard = humanPlayer.hand.playerHand.get(indexHand);
                totalDisCard.addCardonBoard(toDiscard);
                if(totalDisCard.cardOnBoard.get(0) != toDiscard){
                    play(humanPlayer, computerPlayer, totalDisCard, totalCards);
                }
                humanPlayer.hand.playerHand.remove(toDiscard);


                // If the user only have one card for hand, it will let computer know that user only have one card left
                if(humanPlayer.hand.playerHand.size() == 1){
                    System.out.println("Hey " + humanPlayer.getPlayerName() + "... just to let you know, " + computerPlayer.getPlayerName() + "only have one card in my hand!");
                }

                // If user has no card in hand, it wins the game
                if(humanPlayer.hand.playerHand.isEmpty()){
                    System.out.println(humanPlayer.getPlayerName() + " Won the game!!!");
                    break;
                }


                //  If the user choose to draw
                // it will draw a card from the deck and add that card to the user hand
            } else if (choicePlayer == 2) {
                humanPlayer.addCardToHand(totalCards.draw());
            } else {

            }

            // making a variable for how many cards of hand the computer have at the moment
            int oldSize = computerPlayer.hand.playerHand.size();


            // telling a computer to cardOnBoard the hand, if the computer have a hands that
            // match a cardOnBoard card's number or suit
            // If the computer has a hand to cardOnBoard, it will add that card to the cardOnBoard pile
            //  and remove that card from a computer hand
            System.out.println("Computer is Playing");
            for(Card k :computerPlayer.hand.playerHand ) {
                if (k.suits.equals(totalDisCard.cardOnBoard.get(0).suits)) {
                    totalDisCard.addCardonBoard(k);
                    computerPlayer.hand.playerHand.remove(k);
                    break;

                } else if (k.rank.equals(totalDisCard.cardOnBoard.get(0).rank)) {
                    totalDisCard.addCardonBoard(k);
                    computerPlayer.hand.playerHand.remove(k);
                    break;
                }

            }

            // If the computer didn't cardOnBoard the hand, computer will draw a card from the deck and add that
            //  card to computer's hand
            if(computerPlayer.hand.playerHand.size()== oldSize){
                computerPlayer.addCardToHand(totalCards.draw());

            }

            //  If computer only has one card left in hand. It will display the message that computer has only
            //  one card left
            if(computerPlayer.hand.playerHand.size()== 1){
                System.out.println(humanPlayer.getPlayerName() + " Computer Card left is " + computerPlayer.hand.playerHand.size());
            }

            //  If computer's hand is empty...  computer win the game
            if(computerPlayer.hand.playerHand.isEmpty()){
                System.out.println("Computer win the game!");
                break;

            }


        }

        System.out.println("GAME OVER!!! \n");
    }
}
