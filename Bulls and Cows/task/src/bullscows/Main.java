package bullscows;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Declaring and Initializing objects
        Scanner scanner = new Scanner(System.in);
        StartGame game = new StartGame();
        int secretCodeLength = 0;
        int possibleCharacters = 0;


        try {
            //Asking the user for the secret code's length and generating one
            System.out.println("Input the length of the secret code:");
            secretCodeLength = scanner.nextInt();
            scanner.nextLine();

            //Asking the user for the possible symbols in the code, if more than 10, then generate letters.
            System.out.println("Input the number of possible symbols in the code:");
            possibleCharacters = scanner.nextInt();
            scanner.nextLine();

            //If-else statement for handling incorrect inputs
            if (secretCodeLength > possibleCharacters) {
                System.out.println("Error: it's not possible to generate a code with a length of " + secretCodeLength + " with " + possibleCharacters + " unique symbols.");
            } else if (secretCodeLength == 0 || possibleCharacters == 0) {
                System.out.println("Error: the length of the secret code or possible characters was zero.");
            } else {
                String secretCode = game.generateNumber(secretCodeLength, possibleCharacters);
                String secretCodeInAsterisk = "*".repeat(secretCodeLength);
                String possibleCharacterString = "0123456789abcdefghijklmnopqrstuvwxyz";
                System.out.println("The secret is prepared: " + secretCodeInAsterisk + " (0-" + possibleCharacterString.charAt(possibleCharacters - 1) + ").");

                //Starting the game
                game.start(secretCode, scanner, secretCodeLength);
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: " + secretCodeLength + " isn't a valid number.");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
        }

    }
}

