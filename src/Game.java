import java.util.Scanner;

public class Game {
    // Rules of the game
    // rock beats scissors
    // paper beats rock
    // scissors beats paper
    static Scanner console = new Scanner(System.in);
    public static void main(String[] args) {
        boolean exit = false;

        //Human VS Computer
        do {
            int userMove = getUserChoice();
            int computerMove = computerChoice();
            String userChoice = generateMove(userMove);
            String computerchoice = generateMove(computerMove);
            determineWinner(userChoice, computerchoice);
            exit = playAgain();
        } while (!exit);

        //Human VS human
//        do{
//            int user1move = getUserChoice();
//            int user2move = getUserChoice();
//            String user1Choice = generateMove(user1move);
//            String user2Choice = generateMove(user2move);
//            determineWinner(user1Choice,user2Choice);
//            exit = playAgain();
//        } while(!exit);

        //Computer VS Computer
            int comp1Move = computerChoice();
            int comp2Move = computerChoice();
            String comp1Choice = generateMove(comp1Move);
            String comp2Choice = generateMove(comp2Move);
            determineWinner(comp1Choice,comp2Choice);


    } // this closes the main

    // REFACTOR

    // Get user Choice
    public static int getUserChoice() {
        boolean validChoice = false;
        int userChoice;
        do {
            System.out.println("Please select your move[rock, paper, scissors]");
            System.out.println("0. Rock");
            System.out.println("1. Paper");
            System.out.println("2. Scissors");

            userChoice = Integer.parseInt(console.nextLine());

            if (userChoice == 0 || userChoice == 1 || userChoice == 2) {
                validChoice = true;
            } else {
                System.out.printf("Error: Invalid Input%n");
            }
        } while (!validChoice);

        return userChoice;
    }

    // Grab the computer choice
    public static int computerChoice() {
        int random = (int) Math.floor(Math.random() * 3); // a random number between 0 and 2
        return random;
    }

    // Generate move
    public static String generateMove(int playerChoice) {
        String move = null;
        switch (playerChoice) {
            case 0:
                move = "rock";
                break;
            case 1:
                move = "paper";
                break;
            case 2:
                move = "scissors";
                break;
            default: // this will never happen
                move = null;
        }
        return move;
    }

    // Determine winner
    public static void determineWinner(String userOneChoice, String userTwoChoice) {
        String graphic = "L O A D I N G ";
        for (int i = 0; i < graphic.length(); i++) {
            System.out.println(graphic.charAt(i));
        }

        // tie
        if (userTwoChoice.equalsIgnoreCase(userOneChoice)) {
            System.out.printf("Your both picked %s, it's a tied%n", userOneChoice);
            // user1 won
        } else if (userTwoChoice.equalsIgnoreCase("rock") && userOneChoice.equalsIgnoreCase("paper")) {
            System.out.printf("Player2 picked %s and you picked %s - You win!%n", userTwoChoice, userOneChoice);
        } else if (userTwoChoice.equalsIgnoreCase("paper") && userOneChoice.equalsIgnoreCase("scissors")) {
            System.out.printf("Player2 picked %s and you picked %s - You win!%n", userTwoChoice, userOneChoice);
        } else if (userTwoChoice.equalsIgnoreCase("scissors") && userOneChoice.equalsIgnoreCase("rock")) {
            System.out.printf("Player2 picked %s and you picked %s - You win!%n", userTwoChoice, userOneChoice);
            // user1 lose
        } else {
            System.out.printf("Player2 picked %s and you picked %s - You lose!%n", userTwoChoice, userOneChoice);
        }
    }

    // Play again?
    public static boolean playAgain() {
        System.out.println("Would you like to play again [y/n]? ");
        String playAgain = console.nextLine();

        if (playAgain.equalsIgnoreCase("n")) {
            System.out.println("Thanks for playing, Goodbye!");
            return true;
        } else {
            return false;
        }
    }
} // this closes class
