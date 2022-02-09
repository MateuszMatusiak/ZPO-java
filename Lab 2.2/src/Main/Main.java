package Main;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        MisryGriesAlgoritm a = new MisryGriesAlgoritm();
        String[] dic = a.readFile("dickens.simple");
        int n = dic.length;
        int k = 100;
        HashMap<String, Integer> map = a.MGA(dic, k);

        TreeMap<Integer, String> sorted = new TreeMap<>(Collections.reverseOrder());

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / k)
                sorted.put(entry.getValue(), entry.getKey());
        }

        for (Map.Entry<Integer,String> entry : sorted.entrySet()) {
            System.out.println(entry.getValue() + ": " + entry.getKey());
        }


    }

}
