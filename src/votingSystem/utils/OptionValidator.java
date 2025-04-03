package votingSystem.utils;
import java.util.Scanner;
public class OptionValidator {
	public static int getValidCandidateCount(Scanner scanner) {
        int numCandidates = 0;
        while (true) {
            try {
                System.out.print("Enter the number of candidates (min 2, max 100): ");
                numCandidates = scanner.nextInt();
                if (numCandidates >= 2 && numCandidates <= 100) {
                    break;
                } else {
                    System.out.println("❌ Invalid input: Please enter a number between 2 and 100.");
                }
            } catch (Exception e) {
                System.out.println("❌ Invalid input: Please enter a valid number.");
                scanner.next();
            }
        }
        return numCandidates;
    }
}
