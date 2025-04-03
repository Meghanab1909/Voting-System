package votingSystem.utils;
import java.util.Map;
public class LeadDisplay {
	public static void displayLead(Map<Integer, String> options, Map<Integer, Integer> votes) {
        int maxVotes = votes.values().stream().max(Integer::compare).orElse(0);
        votes.forEach((key, value) -> {
            if (value == maxVotes) {
                System.out.println("Leading: " + options.get(key) + " with " + value + " votes.");
            }
        });
    }
}
