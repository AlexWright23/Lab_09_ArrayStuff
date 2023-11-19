import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] dataPoints = new int[100];

        Random random = new Random();
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = random.nextInt(100) + 1;
        }

        System.out.print("DataPoints: ");
        for (int i = 0; i < dataPoints.length; i++) {
            System.out.print(dataPoints[i]);
            if (i < dataPoints.length - 1) {
                System.out.print(" | ");
            }
        }
        System.out.println();

        int sum = 0;
        for (int value : dataPoints) {
            sum += value;
        }
        double average = (double) sum / dataPoints.length;

        System.out.printf("The sum of the random array dataPoints is: %d%n", sum);
        System.out.printf("The average of the random array dataPoints is: %.2f%n", average);

        SafeInput.performOperations(dataPoints);
    }


    public static void performOperations(int[] dataPoints) {
        int userValue = SafeInput.getRangedInt("Enter a value between 1 and 100: ", 1, 100);

        int count = 0;
        for (int value : dataPoints) {
            if (value == userValue) {
                count++;
            }
        }
        System.out.println("The user's value was found " + count + " times in the array.");

        int userValueToFind = SafeInput.getRangedInt("Enter a value between 1 and 100 to find in the array: ", 1, 100);

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
