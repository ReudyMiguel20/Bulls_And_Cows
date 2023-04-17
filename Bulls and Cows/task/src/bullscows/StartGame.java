package bullscows;

import java.util.Scanner;
import java.util.Random;

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

            // Loop for checking bulls and cows

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

    public String generateNumber(int userInput, int possibleCharacters) {
        //Initializing variables and creating a new pseudoNumber
        Random randomizer = new Random();
        long pseudoRandomNumber = (long) (randomizer.nextDouble() * 9000000000L) + 1000000000L;
        StringBuilder sb = new StringBuilder();
        int counterNumber = 1;
        String finalNumber = "";
        int counterLetter = 0;

        //Taking user input and then converting the Long number to a String and splitting
        String randomNumber = String.valueOf(pseudoRandomNumber);
        String[] randomArrayNumber = randomNumber.split("");
        String alphabetLetters = "a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z";
        String[] alphabetLettersArray = alphabetLetters.split(", ");
        int lastNumberOnRandom = Integer.parseInt(randomArrayNumber[randomArrayNumber.length - counterNumber]);


        //If-else statements to determine which numbers are going to be added given the length and the possible symbols
        if (userInput <= 0) {
            System.out.println("Error: can't generate a secret number with a length of zero.");
        } else if (possibleCharacters >= 1 && possibleCharacters <= 10) {
            for (int i = 0; i < userInput; i++) {
                if (sb.toString().contains(randomArrayNumber[randomArrayNumber.length - counterNumber])) {
                    /* If the arranged string have repeated character then create another random number,
                    also don't add the number and check again */
                    pseudoRandomNumber = (long) (randomizer.nextDouble() * 9000000000L) + 1000000000L;
                    randomNumber = String.valueOf(pseudoRandomNumber);
                    randomArrayNumber = randomNumber.split("");
                    --i;
                } else {
                    //Appending the string.
                    sb.append(randomArrayNumber[randomArrayNumber.length - counterNumber]);
                    counterNumber++;
                }
            }
            finalNumber = sb.toString();
            return finalNumber;
        } else if (possibleCharacters >= 11) {
            //Concatenating the random number by the specified amount input by the user.
            for (int i = 0; i < userInput; i++) {
                /* A number that changes from 1 to 2 everytime the loop is completed,
                   if the number is 1: a number will be added to the randomNumber,
                   otherwise a letter will be added to the randomNumber.              */
                int numberOrLetter = randomizer.nextInt(2) + 1;

                if (counterNumber == 11) {
                    numberOrLetter = 2;
                }

                switch (numberOrLetter) {
                    case 1 -> {
                        if (sb.toString().contains(randomArrayNumber[randomArrayNumber.length - 1])) {
                    /* If the arranged string have repeated character then create another random number,
                    also don't add the number and check again */
                            pseudoRandomNumber = (long) (randomizer.nextDouble() * 9000000000L) + 1000000000L;
                            randomNumber = String.valueOf(pseudoRandomNumber);
                            randomArrayNumber = randomNumber.split("");
                            --i;
                        } else {
                            //Appending the string.
                            sb.append(randomArrayNumber[randomArrayNumber.length - 1]);
                            counterNumber++;
                        }
                    }
                    case 2 -> {
                        if (sb.toString().contains(alphabetLettersArray[counterLetter])) {
                    /* If the arranged string have repeated character then create another random number,
                    also don't add the letter and check again */
                            counterLetter++;
                            --i;
                        } else {
                            sb.append(alphabetLettersArray[counterLetter]);
                            counterLetter++;
                        }
                    }
                }
            }
            finalNumber = sb.toString();
        }
        return finalNumber;
    }
}
