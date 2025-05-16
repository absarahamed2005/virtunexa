import java.util.Scanner;

public class ConsoleUI {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a character: ");
        String input = scanner.nextLine();

        if (input.length() != 1) {
            System.out.println("Invalid input! Please enter exactly one character.");
            return;
        }

        char character = input.charAt(0);
        int asciiValue = AsciiFinder.getAsciiValue(character);
        System.out.println("ASCII value of '" + character + "' is: " + asciiValue);
    }
}