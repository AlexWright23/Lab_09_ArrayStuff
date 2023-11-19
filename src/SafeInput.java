//import java.util.Scanner;
//
//public class SafeInput {
//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static int getRangedInt(String prompt, int min, int max) {
//        int userInput;
//
//        do {
//            System.out.print(prompt);
//            while (!scanner.hasNextInt()) {
//                System.out.println("Invalid input. Please enter an integer.");
//                scanner.next(); // Consume the invalid input
//            }
//            userInput = scanner.nextInt();
//
//            if (userInput < min || userInput > max) {
//                System.out.println("Input out of range. Please enter a value between " + min + " and " + max + ".");
//            }
//        } while (userInput < min || userInput > max);
//
//        return userInput;
//    }
//}

import java.util.Scanner;
import java.util.Random;

public class SafeInput {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getRangedInt(String prompt, int min, int max) {
        int userInput;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // consume invalid input
            }
            userInput = scanner.nextInt();
            scanner.nextLine(); // consume the newline character
            if (userInput < min || userInput > max) {
                System.out.println("Value out of range. Please enter a value between " + min + " and " + max + ".");
            }
        } while (userInput < min || userInput > max);
        return userInput;
    }

    public static void performOperations(int[] dataPoints) {
        int userValue = getRangedInt("Enter a value between 1 and 100: ", 1, 100);

        int count = 0;
        for (int value : dataPoints) {
            if (value == userValue) {
                count++;
            }
        }
        System.out.println("The user's value was found " + count + " times in the array.");

        int userValueToFind = getRangedInt("Enter a value between 1 and 100 to find in the array: ", 1, 100);

        int position = -1;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userValueToFind) {
                position = i;
                break;
            }
        }
        if (position != -1) {
            System.out.println("The value " + userValueToFind + " was found at array index " + position + ".");
        } else {
            System.out.println("The value " + userValueToFind + " was not found in the array.");
        }

        int min = dataPoints[0];
        int max = dataPoints[0];

        for (int i = 1; i < dataPoints.length; i++) {
            if (dataPoints[i] < min) {
                min = dataPoints[i];
            }
            if (dataPoints[i] > max) {
                max = dataPoints[i];
            }
        }

        System.out.println("Minimum value in the array: " + min);
        System.out.println("Maximum value in the array: " + max);

        System.out.println("Average of dataPoints is: " + getAverage(dataPoints));
    }

    public static double getAverage(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return (double) sum / values.length;
    }
}
