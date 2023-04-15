import java.util.Scanner;

class EmployeeManagement {

    public static String createEmail(String name, String surname) {
        // write your code here
        StringBuilder sb = new StringBuilder(name + surname + "@work.net");
        return sb.toString();
    }

    // Don't change the code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        String surname = scanner.next();

        String completeEmail = createEmail(name, surname);

        System.out.println(completeEmail);
    }
}
