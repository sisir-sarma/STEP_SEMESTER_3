import java.util.Arrays;

class Player implements Comparable<Player> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed,
                  double battingAverage, boolean injured) {

        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    static boolean isDraftable(int matchesPlayed,
                               boolean injured) {

        return matchesPlayed >= 10 && !injured;
    }

    static boolean isDraftable(int matchesPlayed,
                               double battingAverage,
                               boolean injured) {

        return matchesPlayed >= 5 &&
               battingAverage >= 45 &&
               !injured;
    }

    public int compareTo(Player other) {

        double score1 =
                this.matchesPlayed * 5 +
                this.battingAverage;

        double score2 =
                other.matchesPlayed * 5 +
                other.battingAverage;

        if (score1 < score2)
            return 1;

        if (score1 > score2)
            return -1;

        return 0;
    }

    static String draftAndRank(Player[] players) {

        Player[] draftable = new Player[players.length];

        int count = 0;

        for (Player p : players) {

            if (isDraftable(p.matchesPlayed, p.injured) ||
                isDraftable(p.matchesPlayed,
                            p.battingAverage,
                            p.injured)) {

                draftable[count] = p;
                count++;
            }
        }

        Player[] finalList =
                Arrays.copyOf(draftable, count);

        Arrays.sort(finalList);

        String result = "";

        for (int i = 0; i < finalList.length; i++) {

            result = result +
                     (i + 1) + ". " +
                     finalList[i].name;

            if (i < finalList.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Player[] players = {

            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 2, 60.0, true)
        };

        System.out.println(
            draftAndRank(players)
        );
    }
}