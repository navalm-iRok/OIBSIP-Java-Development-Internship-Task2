import java.util.*;

// class game
class Game {
    int systemInput;
    int userInput;
    int numGuess = 0;

    // generating random number in Constructor
    Game() {
        Random random = new Random();
        this.systemInput = random.nextInt(100) + 1;
    }

    // method to take user guesses
    public boolean takeUserInput() {
        if (numGuess < 10) {
            System.out.print("Guess the number : ");
            this.userInput = NumberGuessing.takeIntInput(100);
            numGuess++;
            return false;
        } else {
            System.out.println("Number of attempts finished...Better luck next time\n");
            return true;
        }
    }

    // method to check user guess status
    public boolean isCorrectGuess() {

        if (systemInput == userInput) {
            System.out.println("Congratulations, you guess the number " + systemInput +
                    " in " + numGuess + " guesses");
            switch (numGuess) {
                case 1:
                    System.out.println("Your score is 100");
                    break;
                case 2:
                    System.out.println("Your score is 90");
                    break;
                case 3:
                    System.out.println("Your score is 80");
                    break;
                case 4:
                    System.out.println("Your score is 70");
                    break;
                case 5:
                    System.out.println("Your score is 60");
                    break;
                case 6:
                    System.out.println("Your score is 50");
                    break;
                case 7:
                    System.out.println("Your score is 40");
                    break;
                case 8:
                    System.out.println("Your score is 30");
                    break;
                case 9:
                    System.out.println("Your score is 20");
                    break;
                case 10:
                    System.out.println("Your score is 10");
                    break;
            }
            System.out.println();
            return true;
        } else if (numGuess < 10 && userInput > systemInput) {
            if (userInput - systemInput > 10) {
                System.out.println("Too High");
            } else {
                System.out.println("Little High");
            }
        } else if (numGuess < 10 && userInput < systemInput) {
            if (systemInput - userInput > 10) {
                System.out.println("Too low");
            } else {
                System.out.println("Little low");
            }
        }
        return false;
    }
}

public class NumberGuessing {
    // static method to take integer input without any limit and exception error
    // exception handling and input limit handling
    public static int takeIntInput(int limit) {
        int input = 0;
        boolean flag = false;

        while (!flag) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;

                if (flag && input > limit || input < 1) {
                    System.out.println("Choose the number between 1 to " + limit);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("Enter only integer value");
                flag = false;
            }
        }
        ;
        return input;
    }

    // main method
    public static void main(String[] args) {

        // input for start the game
        System.out.println("1. Start the Game \n2. Exit");
        System.out.print("Enter your choice : ");
        int choice = takeIntInput(2);
        int nextRound = 1;
        int noOfRound = 0;

        if (choice == 1) {

            // to check next round is there or not
            while (nextRound == 1) {
                // creating object of Game class
                Game game = new Game();
                boolean isMatched = false;
                boolean isLimitCross = false;
                System.out.println("\nRound " + ++noOfRound + " starts...");

                // to check correct guess and limit cross
                while (!isMatched && !isLimitCross) {
                    isLimitCross = game.takeUserInput();
                    isMatched = game.isCorrectGuess();
                }
                // input for next round
                System.out.println("1. Next Round \n2. Exit");
                System.out.println("Enter your choice : ");
                nextRound = takeIntInput(2);
                if (nextRound != 1) {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}
