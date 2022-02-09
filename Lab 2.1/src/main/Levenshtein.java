package main;

public class Levenshtein {

    public static double calculateCost(char a, char b) {

        if ((!Character.isLetter(a)) || (!Character.isLetter(b)))
            return -1;

        if (a == b)
            return 0;
        char[] line1 = new char[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
        char[] line2 = new char[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
        char[] line3 = new char[]{'z', 'x', 'c', 'v', 'b', 'n', 'm'};

        if (checkNeighbor(a, b, line1)) return 0.5;
        if (checkNeighbor(a, b, line2)) return 0.5;
        if (checkNeighbor(a, b, line3)) return 0.5;

        return 1;
    }

    private static boolean checkNeighbor(char a, char b, char[] line) {
        for (int i = 0; i < line.length; ++i) {
            if (a == line[i]) {
                if (i > 0)
                    if (b == line[i - 1]) {
                        return true;
                    }
                if (i < line.length - 1) {
                    if (b == line[i + 1]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public double LevQWERTY(String s1, String s2) {
        double distance = 0;

        double cost = 0;

        int l1 = s1.length() + 1;
        int l2 = s2.length() + 1;

        double dis[][] = new double[l1][l2];

        for (int i = 0; i < l1; ++i)
            dis[i][0] = i;
        for (int i = 1; i < l2; ++i)
            dis[0][i] = i;

        for (int i = 1; i < l1; ++i) {
            for (int k = 1; k < l2; ++k) {
                cost = calculateCost(s1.charAt(i - 1), s2.charAt(k - 1));
                if (cost == -1)
                    return -1;
                dis[i][k] = Math.min(dis[i - 1][k] + 1,
                        Math.min(dis[i][k - 1] + 1,
                                dis[i - 1][k - 1] + cost));
            }
        }
        distance = dis[l1 - 1][l2 - 1];
        return distance;
    }


}


