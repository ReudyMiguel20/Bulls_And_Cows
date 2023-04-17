package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Declaring and Initializing objects
        Scanner scanner = new Scanner(System.in);
        StartGame game = new StartGame();

        //Asking the user for the secret code's length and generating one
        System.out.println("Input the length of the secret code:");
        int secretCodeLength = scanner.nextInt();
        scanner.nextLine();

        //Asking the user for the possible symbols in the code, if more than 10, then generate letters.
        System.out.println("Input the number of possible symbols in the code:");
        int possibleCharacters = scanner.nextInt();
        scanner.nextLine();


        String secretCode = game.generateNumber(secretCodeLength, possibleCharacters);
        String secretCodeInAsterisk = "*".repeat(secretCodeLength);
        String possibleCharacterString = "0123456789abcdefghijklmnopqrstuvwxyz";
        System.out.println("The secret is prepared: " + secretCodeInAsterisk + " (0-" + possibleCharacterString.charAt(possibleCharacters - 1) + ").");

        //Starting the game
        game.start(secretCode, scanner, secretCodeLength);

    }
}

