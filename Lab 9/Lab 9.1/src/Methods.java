import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class Methods extends UnicastRemoteObject implements Connector {

    public Methods() throws RemoteException {
        super();
    }

    @Override
    public String refactorText(String text) {
        String temp;
        temp = text.replace('\n', ' ');
        temp = temp.toLowerCase();
        StringBuilder res = new StringBuilder();
        char[] arr = temp.toCharArray();
        String bannedChars = "’.,;-—()?!:\"'”“[]{}<>/\\1234567890_";
        for (int i = 0; i < temp.length(); ++i) {
            if (!bannedChars.contains(String.valueOf(arr[i]))) {
                res.append(arr[i]);
            }
        }
        return res.toString();
    }

    @Override
    public HashMap<String, Integer> makeHistogram(String text) {
        HashMap<String, Integer> temp = new HashMap<>();
        text = refactorText(text);
        String[] arr = text.split(" ");
        for (String word : arr) {
            if (!temp.containsKey(word)) {
                temp.put(word, 1);
            } else {
                int n = temp.get(word);
                temp.replace(word, n, n + 1);
            }
        }

        Set<Map.Entry<String, Integer>> set = temp.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(set);
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        HashMap<String, Integer> histogram = new HashMap<>();

        int n = 0;
        for (Map.Entry<String, Integer> entry : list) {
            if (entry.getKey().isBlank())
                continue;
            histogram.put(entry.getKey(), entry.getValue());
            if (n == 4)
                break;
            n++;
        }

        return histogram;
    }



}
