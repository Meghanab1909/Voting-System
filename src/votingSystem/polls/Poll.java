package votingSystem.polls;
import votingSystem.interfaces.PollInterface;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public abstract class Poll implements PollInterface {
    protected Map<Integer, String> options;
    protected Map<Integer, Integer> votes;
    protected Scanner scanner;

    public Poll(int numCandidates, Scanner scanner) {
        this.scanner = scanner;
        this.options = new HashMap<>();
        this.votes = new HashMap<>();
        initializeOptions(numCandidates);
    }

    protected void initializeOptions(int numCandidates) {
    	for (int i = 1; i <= numCandidates; i++) {
            System.out.print("Enter name for Candidate " + i + ": ");
            String name = scanner.next();
            options.put(i, name);
            votes.put(i, 0);
        }
    	options.put(0, "None of the Above (NOTA)");
        votes.put(0, 0);
    }

    public Map<Integer, String> getOptions() {
        return options;
    }

    public Map<Integer, Integer> getVotes() {
        return votes;
    }

    public abstract void collectVote();
    public abstract void displayStatistics();
    public abstract void displayLead();
    public abstract void resetPoll();

}
