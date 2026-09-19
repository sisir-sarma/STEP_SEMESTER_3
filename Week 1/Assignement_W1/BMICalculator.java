import java.util.Scanner;

public class BMICalculator {

    static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("\nWellness Report");
        System.out.println("-----------------------------------------------------");
        System.out.println("Person | Height | Weight | BMI   | Status");
        System.out.println("-----------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);

            System.out.printf("%-6d | %.2f m | %.2f kg | %.2f | %s%n",
                    i + 1, heights[i], weights[i], bmi, status);
        }

        System.out.println("-----------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of people: ");
        int numberOfPeople = scanner.nextInt();

        double[] heights = new double[numberOfPeople];
        double[] weights = new double[numberOfPeople];

        for (int i = 0; i < numberOfPeople; i++) {
            System.out.println("\nPerson " + (i + 1));

            System.out.print("Enter height in meters: ");
            heights[i] = scanner.nextDouble();

            System.out.print("Enter weight in kg: ");
            weights[i] = scanner.nextDouble();
        }

        printWellnessReport(heights, weights);

        scanner.close();
    }
}