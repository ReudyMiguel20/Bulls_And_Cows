package bullscows;

import java.util.Scanner;

public class StartGame {

    public StartGame() {

    }

    public void start(String secretNumber, Scanner scanner, int secretCodeLength) {
        //Declaring and initializing variables
        int cows = 0;
        int bulls = 0;
        int counterWordCheck = 0;
        int tryCounter = 1;
        String userInput = "";

        //Declaring and splitting up the secret number into an Array
        String[] secretArray = secretNumber.split("");

        System.out.println("Okay, let's start a game!");

        //Declaring and splitting up the input number into an Array
        while (true) {

            System.out.println("Turn " + tryCounter + ":");
            userInput = scanner.nextLine();
            String[] userArray = userInput.split("");

            /* Loop for checking bulls and cows */

                for (String word : secretArray) {

                    //Checking for cows
                    if (userInput.contains(word) && (!(userArray[counterWordCheck].equals(word)))) {
                        cows++;
                    }

                    //Checking for bulls
                    if (userArray[counterWordCheck].equals(word)) {
                        bulls++;
                        counterWordCheck++;

                        //If bulls are equal to 4 then reset the counter of cows.
                        if (bulls == 4) {
                            cows = 0;
                        }

                    } else {
                        counterWordCheck++;
                    }

                }

            //Printing the result depending on the bulls and cows found
            if (bulls == secretCodeLength) {
                System.out.println("Grade: " + bulls + " bulls");
                System.out.println("Congratulations! You guessed the secret code.");
                break;
            } else if (bulls >= 1 && cows >= 1) {
                System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s).");
            } else if (bulls >= 1) {
                System.out.println("Grade: " + bulls + " bull(s).");
            } else if (cows >= 1) {
                System.out.println("Grade: " + cows + " cow(s).");
            } else {
                System.out.println("Grade: None.");
            }

            //Resetting values for the next turn.
            cows = 0;
            bulls = 0;
            counterWordCheck = 0;
            tryCounter++;
        }
    }

    public String generateNumber(int userInput) {
        //Initializing variables and creating a new pseudoNumber
        Scanner scanner = new Scanner(System.in);
        long pseudoRandomNumber = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        String finalNumber = "";

        //Taking user input and then converting the Long number to a String and splitting
        String randomNumber = String.valueOf(pseudoRandomNumber);
        String[] randomArray = randomNumber.split("");

        /* Checking if the number contains a zero at the end,
         if it does then is going to create a new random number. */
        while (true) {
            if (randomArray[randomArray.length - 1].equals("0")) {
                pseudoRandomNumber = System.nanoTime();
                randomNumber = String.valueOf(pseudoRandomNumber);
                randomArray = randomNumber.split("");
            } else {
                break;
            }
        }

        //Checking if the input number is greater than zero and less than 11
        if (userInput <= 0 || userInput >= 11) {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
        } else {
            //Concatenating the random number by the specified amount input by the user.
            for (int i = 0; i < userInput; i++) {
                if (sb.toString().contains(randomArray[randomArray.length - counter])) {
                    /*If the arranged string have repeated character then create another random number,
                    also don't add the number and check again */
                    pseudoRandomNumber = System.nanoTime();
                    randomNumber = String.valueOf(pseudoRandomNumber);
                    randomArray = randomNumber.split("");
                    --i;
                } else {
                    //Appending the string.
                    sb.append(randomArray[randomArray.length - counter]);
                    counter++;
                }
            }
            finalNumber = sb.toString();
        }
        return finalNumber;
    }
}
