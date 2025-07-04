package org.example;

import org.example.incubyte.StringCalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== String Calculator ===");
        System.out.print("Enter the numbers string: ");


        String input = scanner.nextLine().trim();


        if (input.startsWith("\"") && input.endsWith("\"") && input.length() > 1) {
            input = input.substring(1, input.length() - 1);
        }

        // Replace typed "\\n" with actual newline character
        input = input.replace("\\n", "\n");

        try {
            int result = calculator.add(input);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            // Catch both custom and parsing errors
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
