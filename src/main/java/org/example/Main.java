package org.example;
import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\Tringapps-user19\\Downloads\\sample.txt";
        HashMap<String, Integer> newkey = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                    if (newkey.containsKey(word)) {
                        newkey.put(word, newkey.get(word) + 1);
                    } else {
                        newkey.put(word, 1);
                    }
                }
            }
        }
        Map<String, Integer> sortedWordCounts = sortByValue(newkey);
       for (Map.Entry<String, Integer> entry : sortedWordCounts.entrySet()) {
           Logger l = Logger.getLogger("com.api.jar");
           l.info(entry.getKey() + ": " + entry.getValue());
        }
    }
    private static Map<String, Integer> sortByValue(Map<String, Integer> newkey) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(newkey.entrySet());
        list.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));
        Map<String, Integer> words = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            words.put(entry.getKey(), entry.getValue());
        }
        return words;
    }
}
