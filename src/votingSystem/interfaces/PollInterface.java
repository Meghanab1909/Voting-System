package votingSystem.interfaces;
import java.util.Map;
public interface PollInterface {
	 void collectVote();
	    void displayStatistics();
	    void displayLead();
	    void resetPoll();
	    Map<Integer, String> getOptions();
	    Map<Integer, Integer> getVotes();
}
