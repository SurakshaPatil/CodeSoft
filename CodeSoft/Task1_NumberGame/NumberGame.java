package Task1_NumberGame;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 7;
        int roundsPlayed = 0;
        int totalAttempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int userGuess;
            int attempts = 0;

            System.out.println("\nRound " + (roundsPlayed + 1));
            System.out.println("Try to guess the number between " + lowerBound + " and " + upperBound);

            do {
                System.out.print("Enter your guess: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    System.out.print("Enter your guess: ");
                    scanner.next(); // consume invalid input
                }
                userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < lowerBound || userGuess > upperBound) {
                    System.out.println("Please enter a number within the specified range.");
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high! Try again.");
                }
            } while (userGuess != randomNumber && attempts < maxAttempts);

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the number " + randomNumber +
                        " in " + attempts + " attempts.");
            } else {
                System.out.println("Sorry! You've reached the maximum number of attempts. The correct number was: " + randomNumber);
            }

            totalAttempts += attempts;
            roundsPlayed++;

            System.out.print("\nDo you want to play again? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));

        System.out.println("\nGame Over. You played " + roundsPlayed + " rounds with a total of " + totalAttempts + " attempts.");
        scanner.close();
    }
}

