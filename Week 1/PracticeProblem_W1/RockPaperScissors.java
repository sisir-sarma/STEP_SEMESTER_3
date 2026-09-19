import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    static String getComputerMove() {
        Random random = new Random();
        int choice = random.nextInt(3);

        if (choice == 0) {
            return "Rock";
        } else if (choice == 1) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }

    static String getPlayerMove(Scanner scanner) {
        while (true) {
            System.out.print("Enter Rock, Paper or Scissors: ");
            String move = scanner.nextLine();

            if (move.equalsIgnoreCase("Rock")) {
                return "Rock";
            } else if (move.equalsIgnoreCase("Paper")) {
                return "Paper";
            } else if (move.equalsIgnoreCase("Scissors")) {
                return "Scissors";
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    static void displaySummary(String[] playerMoves, String[] computerMoves,
                               String[] results, int rounds,
                               int wins, int losses, int draws) {

        System.out.println("\nFinal Summary");
        System.out.println("-----------------------------------------------");
        System.out.println("Round | Player Move | Computer Move | Result");
        System.out.println("-----------------------------------------------");

        for (int i = 0; i < rounds; i++) {
            System.out.println((i + 1) + "     | " + playerMoves[i]
                    + "        | " + computerMoves[i]
                    + "         | " + results[i]);
        }

        double winPercentage = (wins * 100.0) / rounds;

        System.out.println("-----------------------------------------------");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Player Win Percentage: %.1f%%\n", winPercentage);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rounds = 5;
        int wins = 0;
        int losses = 0;
        int draws = 0;

        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        for (int i = 0; i < rounds; i++) {
            System.out.println("\nRound " + (i + 1));

            String playerMove = getPlayerMove(scanner);
            String computerMove = getComputerMove();
            String result = playRound(playerMove, computerMove);

            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;

            System.out.println("Player: " + playerMove);
            System.out.println("Computer: " + computerMove);
            System.out.println("Result: " + result);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        displaySummary(playerMoves, computerMoves, results,
                rounds, wins, losses, draws);

        scanner.close();
    }
}