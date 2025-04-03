package votingSystem.main;
import votingSystem.polls.*;
import votingSystem.utils.*;
import java.util.Scanner;
public class VotingSystemMain {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int numCandidates = OptionValidator.getValidCandidateCount(scanner);
	        Poll poll = new ElectionPoll(numCandidates, scanner);

	        while (true) {
	            Menu.displayMainMenu();
	            int choice = scanner.nextInt();
	            switch (choice) {
	                case 1: poll.collectVote(); break;
	                case 2: poll.displayStatistics(); break;
	                case 3: poll.displayLead(); break;
	                case 4: poll.resetPoll(); break;
	                case 5: GraphGenerator.displayGraph(poll.getOptions(), poll.getVotes()); break;
	                case 6: System.out.println("Exiting..."); scanner.close(); System.exit(0);
	                default: System.out.println("❌ Invalid option. Please enter a number between 1 and 6.");
	            }
	        }
	    }
	}
