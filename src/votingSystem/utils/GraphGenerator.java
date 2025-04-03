package votingSystem.utils;
import java.util.*;

public class GraphGenerator {
	public static void displayGraph(Map<Integer, String> options, Map<Integer, Integer> votes) {
        if (votes.isEmpty()) {
            System.out.println("No votes have been cast yet.");
            return;
        }

        int maxVotes = Collections.max(votes.values());
        List<String> winners = new ArrayList<>();
        
        System.out.println("\nPoll Results:");

        // Determine winners (handling ties)
        for (Map.Entry<Integer, Integer> entry : votes.entrySet()) {
            if (entry.getValue() == maxVotes) {
                winners.add(options.getOrDefault(entry.getKey(), "Unknown"));
            }
        }

        // Print Y-axis and bars
        System.out.println("\nVotes");
        for (int i = maxVotes; i > 0; i--) {
            System.out.printf("%2d | ", i); // Y-axis label
            for (int j = 1; j <= options.size(); j++) {
                int voteCount = votes.getOrDefault(j, 0);
                if (voteCount >= i) {
                    System.out.print(" *  ");
                } else {
                    System.out.print("    ");
                }
            }
            System.out.println();
        }

        // Print X-axis
        System.out.println("   +" + "----".repeat(options.size()));
        
        // Print candidate numbers aligned with bars
        System.out.print("     ");
        for (int j = 1; j <= options.size(); j++) {
            System.out.printf("%-4d", j);
        }
        
        System.out.println("\n     " + "-".repeat(4 * options.size()));
        
        // Print candidate names for reference
        for (int j = 1; j <= options.size(); j++) {
            System.out.println(j + ". " + options.getOrDefault(j, "Unknown"));
        }

        // Print winners (handles ties)
        System.out.println("\nWinner(s): " + String.join(", ", winners) + " with " + maxVotes + " votes!");
    }
}
