package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Declaring and Initializing objects
        Scanner scanner = new Scanner(System.in);
        StartGame game = new StartGame();

        //Asking the user for the secret code's length and generating one
        System.out.println("Please, enter the secret code's length");
        int secretCodeLength = scanner.nextInt();
        scanner.nextLine();
        String secretCode = game.generateNumber(secretCodeLength);

        //Starting the game
        game.start(secretCode, scanner, secretCodeLength);

    }
}

