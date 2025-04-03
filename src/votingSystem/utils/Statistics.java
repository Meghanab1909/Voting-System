package votingSystem.utils;
import java.util.Map;
public class Statistics {
	 public static void displayStatistics(Map<Integer, String> options, Map<Integer, Integer> votes) {
	        System.out.println("Poll Statistics:");
	        votes.forEach((key, value) -> System.out.println(options.get(key) + ": " + value + " votes"));
	    }
}
