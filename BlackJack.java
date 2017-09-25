import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class BlackJack {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Random randGen = new Random();

        int numCard;
        int valueHand  = 0;
        int choice     = 0;
        int numGame    = 0;
        int valueDealerHand;
        int playerWins = 0;
        int dealerWins = 0;
        int numTies    = 0;
        double percentageWins;

        System.out.println("START GAME #" + (numGame + 1));
        System.out.println();

        while (choice != 4) {

            if (valueHand == 0)
            {
                numCard = randGen.nextInt(13) + 1;
                valueHand = assignCard(numCard, valueHand);
                System.out.println();
            }

            menu();

            System.out.print("Choose an option: ");

            try {
                choice = scnr.nextInt();
            }
            catch (InputMismatchException error)
            {
                System.out.println();
                System.out.println("Invalid input!");
                System.out.println("Please enter an integer between 1 and 4.");
                System.out.println();
                scnr.nextLine();
                continue;
            }

            System.out.println();

            switch (choice) {
                case 1:
                    numCard = randGen.nextInt(13) + 1;

                    valueHand = assignCard(numCard, valueHand);

                    if (valueHand == 21) {
                        System.out.println();
                        System.out.println("BLACKJACK! You win!");
                        System.out.println();
                        valueHand = 0;
                        playerWins += 1;
                        numGame += 1;
                        System.out.println("START GAME #" + (numGame + 1));
                    }

                    if (valueHand > 21) {
                        System.out.println();
                        System.out.println("You exceeded 21! You lose :(");
                        System.out.println();
                        valueHand = 0;
                        dealerWins += 1;
                        numGame += 1;
                        System.out.println("START GAME # " + (numGame + 1));
                    }

                    System.out.println();
                    break;

                case 2:
                    valueDealerHand = randGen.nextInt(11) + 16;

                    System.out.println("Dealer's hand is: " + valueDealerHand);
                    System.out.println("Your hand: " + valueHand);
                    System.out.println();

                    if (valueDealerHand <= 21) {
                        if (valueDealerHand > valueHand) {
                            System.out.println("Dealer wins!");
                            valueHand = 0;
                            dealerWins += 1;
                            numGame += 1;
                        }
                        if (valueDealerHand == valueHand) {
                            System.out.println("It's a tie! No one wins!");
                            valueHand = 0;
                            numTies += 1;
                            numGame += 1;
                        }
                        if (valueHand > valueDealerHand) {
                            System.out.println("You win!");
                            valueHand = 0;
                            playerWins += 1;
                            numGame += 1;
                        }
                    } else {
                        System.out.println("You win!");
                        valueHand = 0;
                        playerWins += 1;
                        numGame += 1;
                    }

                    System.out.println();
                    System.out.println("START GAME #" + (numGame + 1));
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Number of Player wins: " + playerWins);
                    System.out.println("Number of Dealer wins: " + dealerWins);
                    System.out.println("Number of tie games: " + numTies);
                    System.out.println("Total # of games played is: " + numGame);

                    percentageWins = ((double) playerWins / numGame) * 100;

                    System.out.println("Percentage of player wins: " + percentageWins);
                    System.out.println();
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Invalid input!");
                    System.out.println("Please enter an integer between 1 and 4.");
                    System.out.println();
            }
        }
    }

    public static void menu() {
        System.out.println("1. Get another card");
        System.out.println("2. Hold hand");
        System.out.println("3. Print statistics");
        System.out.println("4. Exit");
        System.out.println();
    }

    public static int assignCard (int numCard, int valueHand)
    {
        int valueCard;

        if (numCard == 1) {
            System.out.println("Your card is an ACE!");
            valueCard = 1;
            valueHand += valueCard;
            System.out.println("Your hand is: " + valueHand);
        }

        if (numCard >= 2 && numCard <= 10) {
            System.out.println("Your card is a " + numCard + "!");
            valueCard = numCard;
            valueHand += valueCard;
            System.out.println("Your hand is: " + valueHand);
        }

        if (numCard == 11) {
            System.out.println("Your card is a JACK!");
            valueCard = 10;
            valueHand += valueCard;
            System.out.println("Your hand is: " + valueHand);
        }

        if (numCard == 12) {
            System.out.println("Your card is a QUEEN!");
            valueCard = 10;
            valueHand += valueCard;
            System.out.println("Your hand is: " + valueHand);
        }

        if (numCard == 13) {
            System.out.println("Your card is a KING!");
            valueCard = 10;
            valueHand += valueCard;
            System.out.println("Your hand is: " + valueHand);
        }
        return valueHand;
    }
}

