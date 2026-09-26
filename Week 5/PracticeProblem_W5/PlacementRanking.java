import java.util.Arrays;

class Candidate implements Comparable<Candidate> {

    private String name;
    private double cgpa;
    private int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    static boolean isEligible(double cgpa) {

        return cgpa >= 7.5;
    }

    static boolean isEligible(double cgpa, int codingScore) {

        return cgpa >= 6.5 && codingScore >= 60;
    }

    public int compareTo(Candidate other) {

        double score1 = cgpa * 10 + codingScore / 2.0;
        double score2 = other.cgpa * 10 + other.codingScore / 2.0;

        if (score1 < score2)
            return 1;

        if (score1 > score2)
            return -1;

        return 0;
    }

    static String shortlistAndRank(Candidate[] candidates) {

        Candidate[] shortlisted = new Candidate[candidates.length];

        int count = 0;

        for (Candidate c : candidates) {

            if (isEligible(c.cgpa) ||
                isEligible(c.cgpa, c.codingScore)) {

                shortlisted[count] = c;
                count++;
            }
        }

        Candidate[] finalList = Arrays.copyOf(shortlisted, count);

        Arrays.sort(finalList);

        String result = "";

        for (int i = 0; i < finalList.length; i++) {

            Candidate c = finalList[i];

            double score = c.cgpa * 10 + c.codingScore / 2.0;

            result = result + (i + 1) + ". "
                    + c.name + " (" + score + ")";

            if (i < finalList.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Candidate[] candidates = {

            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(
            shortlistAndRank(candidates)
        );
    }
}