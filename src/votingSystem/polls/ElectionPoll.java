package votingSystem.polls;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class ElectionPoll extends Poll{
    public ElectionPoll(int numCandidates, Scanner scanner) {
        super(numCandidates, scanner);
    }

    @Override
    public void collectVote() {
        boolean voteEntered = false; // Track if at least one vote is entered
        while (true) {
            System.out.print("Enter your vote (Candidate number, or 0 for NOTA, or -1 to stop): ");
            int vote = scanner.nextInt();
            if (vote == -1) { // Stop voting
                break;
            }
            if (options.containsKey(vote)) {
                votes.put(vote, votes.getOrDefault(vote, 0) + 1);
                voteEntered = true;
            } else {
                System.out.println("Invalid vote. Please choose a valid candidate or enter 0 for NOTA.");
            }
        }
        if (!voteEntered) {
            System.out.println("⚠ No vote was entered!"); // Message if no vote was cast
        }
    }

    @Override
    public void displayStatistics() {
        System.out.println("Election Results:");
        for (Map.Entry<Integer, Integer> entry : votes.entrySet()) {
            System.out.println(options.get(entry.getKey()) + " - " + entry.getValue() + " votes");
        }
    }

    @Override
    public void displayLead() {
        int maxVotes = votes.values().stream().max(Integer::compare).orElse(0);
        List<Integer> leadingCandidates = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : votes.entrySet()) {
            if (entry.getValue() == maxVotes) {
                leadingCandidates.add(entry.getKey());
            }
        }

        if (leadingCandidates.size() == 1) {
            System.out.println("Leading: " + options.get(leadingCandidates.get(0)) + " with " + maxVotes + " votes.");
        } else {
            System.out.println("⚠ There's a tie between the following candidates:");
            for (int candidate : leadingCandidates) {
                System.out.println(options.get(candidate));
            }

            System.out.println("\n⚠ Conducting a tie-breaker voting round...");
            resetPoll(); // Reset votes for the tie-breaker
            collectVote(); // Start new voting round for tied candidates
        }
    }

    @Override
    public void resetPoll() {
        votes.replaceAll((k, v) -> 0);
        System.out.println("Poll has been reset.");
    }
}

