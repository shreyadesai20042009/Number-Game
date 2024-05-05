import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int score = 0;
        
        System.out.println("Welcome to the Guess the Number game!");
        
        boolean playAgain = true;
        while (playAgain) {
            int numberToGuess = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.println("A random number between " + minRange + " and " + maxRange + " has been generated.");
            
            int attempts = 0;
            boolean guessed = false;
            while (!guessed && attempts < maxAttempts) {
                System.out.print("Guess the number: ");
                int guess = scanner.nextInt();
                attempts++;
                
                if (guess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    guessed = true;
                    score += maxAttempts - attempts + 1; // Calculate score
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            
            if (!guessed) {
                System.out.println("Sorry, you didn't guess the number. The correct number was: " + numberToGuess);
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            if (!playAgainInput.equals("yes")) {
                playAgain = false;
                System.out.println("Thanks for playing! Your total score is: " + score);
            }
        }
        
        scanner.close();
    }
}