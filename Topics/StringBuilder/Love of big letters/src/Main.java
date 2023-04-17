import java.util.Scanner;

class EvenUpperCase {

    public static String upperEvenLetters(String message) {
        // write your code here
        char[] arrayMessage = message.toCharArray();

        for (int i = 0; i < message.length(); i += 2) {
            arrayMessage[i] = Character.toUpperCase(arrayMessage[i]);
        }

        message = String.valueOf(arrayMessage);
        return message;
    }

    // Don't change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.next();

        System.out.println(upperEvenLetters(message));
    }
}
