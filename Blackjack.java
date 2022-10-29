import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        P1Random rand = new P1Random();

        int userChoice = 0;
        int gameCount = 1;
        int playerWin = 0;
        int dealerWin = 0;
        int tieGame = 0;
        int playerSum = 0;
        int playerCardValue = 0;
        int dealerHand = 0;


        //begin loop
        boolean printMenu = true;
        do {

            // menu list, boolean
            if (printMenu) {
                playerSum=0;
                System.out.println("");
                System.out.println("START GAME #" + gameCount++);
                System.out.println("");
                playerCardValue = rand.nextInt(13) + 1;
                playerSum += cardValue(playerCardValue);
                System.out.println("Your card is a " + cardName(playerCardValue));
                System.out.println("Your hand is: " + playerSum);
                System.out.println("");

            }
            printMenu = true;

            // program menu

            System.out.println("1. Get another card");
            System.out.println("2. Hold hand");
            System.out.println("3. Print statistics");
            System.out.println("4. Exit");
            System.out.println("");

            System.out.print("Choose an option: ");
            userChoice = scanner.nextInt();
            System.out.println("");


            // program actions

            if (userChoice == 1) {
                // get another card
                playerCardValue = rand.nextInt(13) + 1;
                System.out.println("Your card is a " + cardName(playerCardValue));
                playerSum += cardValue(playerCardValue);
                System.out.println("Your hand is: " + playerSum);
                System.out.println("");
                if (playerSum == 21) {
                    System.out.println("BLACKJACK! You win!");
                    playerWin++;
                } else if (playerSum > 21) {
                    System.out.println("You exceeded 21! You lose.");
                    dealerWin++;
                } else if (playerSum < 21) {
                    printMenu = false;
                }
            } else if (userChoice == 2) {
                // hold hand
                dealerHand = rand.nextInt(11) + 16;
                System.out.println("Dealer's hand: " + dealerHand);
                System.out.println("Your hand is: " + playerSum);
                if (dealerHand == 21) {
                    System.out.println("Dealer wins!");
                    dealerWin++;
                } else if (dealerHand > 21) {
                    System.out.println("You win!");
                    playerWin++;
                } else if (playerSum > dealerHand && playerSum < 21) {
                    System.out.println("You win!");
                    playerWin++;
                } else if (dealerHand > playerSum && dealerHand < 21) {
                    System.out.println("Dealer wins!");
                    dealerWin++;
                } else if (playerSum == dealerHand) {
                    System.out.println("It's a tie! No one wins!");
                    tieGame++;
                }
            } else if (userChoice == 3) {
                // print statistics
                System.out.println("Number of Player wins: " + playerWin);
                System.out.println("Number of Dealer wins: " + dealerWin);
                System.out.println("Number of tie games: " + tieGame);
                double playerAvg = ((double)playerWin / (double)(gameCount - 2)) * 100;
                System.out.println("Total # of games played is: " + (gameCount - 2));
                System.out.println("Percentage of Player wins: " + playerAvg + "%");
                System.out.println("");
                printMenu = false;
            } else if (userChoice == 4) {
                // exit game1
            } else {
                System.out.println("Invalid input!");
                System.out.println("Please enter an integer value between 1 and 4.");
                System.out.println("");
                printMenu = false;
            }
        } while (userChoice != 4);
    }


    // assign values of 10 to face card
    public static int cardValue(int newValue) {
        if (newValue > 10) {
            newValue = 10;
        }
        return newValue;
    }

    // assign faceValue to cards
    public static String cardName(int newValue) {
        String cardName = ("");
        if (newValue == 1) {
            cardName = "ACE!";
        } else if (newValue == 2) {
            cardName = "2!";
        }else if (newValue == 3) {
            cardName = "3!";
        }else if (newValue == 4) {
            cardName = "4!";
        }else if (newValue == 5) {
            cardName = "5!";
        }else if (newValue == 6) {
            cardName = "6!";
        }else if (newValue == 7) {
            cardName = "7!";
        }else if (newValue == 8) {
            cardName = "8!";
        }else if (newValue == 9) {
            cardName = "9!";
        }else if (newValue == 10) {
            cardName = "10!";
        } else if (newValue == 11) {
            cardName = "JACK!";
        } else if (newValue == 12) {
            cardName = "QUEEN!";
        } else if (newValue == 13) {
            cardName = "KING!";
        }
        return cardName;
    }
}



