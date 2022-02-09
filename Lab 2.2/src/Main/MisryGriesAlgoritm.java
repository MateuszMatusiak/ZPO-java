package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MisryGriesAlgoritm {

    String[] readFile(String filename) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String buffer = text.toString();
        return buffer.split(" ");
    }

    HashMap<String, Integer> MGA(String[] dictionary, int k) {
        HashMap<String, Integer> D1 = new HashMap<String, Integer>();
        HashMap<String, Integer> D2 = new HashMap<String, Integer>();
        int size = 0;
        for (String word : dictionary) {
            if (D1.containsKey(word)) {
                D1.replace(word, D1.get(word) + 1);
                continue;
            }
            if (size + 1 == k) {
                //usuwanie powtórzen
                Set<Map.Entry<String, Integer>> entrySet = D1.entrySet();
                Iterator<Map.Entry<String, Integer>> itr = entrySet.iterator();
                while (itr.hasNext()) {
                    Map.Entry<String, Integer> entry = itr.next();
                    String key = entry.getKey();
                    D1.replace(key, D1.get(key) - 1);
                    if (D1.get(key) == 0) {
                        itr.remove();
                        size--;
                    }
                }
                continue;
            }
            D1.put(word, 1);
            size++;
        }


        for (String word : dictionary) {
            if (D1.containsKey(word)) {
                if (D2.containsKey(word)) {
                    D2.replace(word, D2.get(word) + 1);
                } else {
                    D2.put(word, 1);
                }
            }
        }

        return D2;
    }

}

