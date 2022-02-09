package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Levenshtein l = new Levenshtein();
        Scanner sc = new Scanner(System.in);
        System.out.println("Give first word: ");
        String word1 = sc.nextLine();
        System.out.println("Give second word: ");
        String word2 = sc.nextLine();

        double dis = l.LevQWERTY(word1, word2);
        if (dis == -1)
            System.out.println("Incorrect input");
        else
            System.out.println("Distance is: " + dis);

    }
}
