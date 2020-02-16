package edu.wctc;

import java.util.*;

public class Main {

    private final static FileInput indata = new FileInput("the_book.csv");
    private final static Map<String, Integer> map = new HashMap<>();


    public Main() {
        String line;
        String[] words;

        while ((line = indata.fileReadLine()) != null) {
            // Remove anything that's not a letter or space
            line = line.replaceAll("[^a-zA-Z ]", "")
                    .toLowerCase().trim();

            // Don't process lines with no characters
            if (line.isEmpty()) {
                continue;
            }

            // Split string over one or more spaces
            words = line.split(" +");

            // Look for each word in the map
            for (String word : words) {
                // This word isn't yet a key, init count to 1
                if (!map.containsKey(word)) {
                    map.put(word, 1);
                } else {
                    // Increment count using word as key
                    map.put(word, map.get(word) + 1);
                }

            }
        }

        // Loop over entries in the map, getting each key/value pair

        //Changed and added by Kristopher
        SortedSet<Words> wordSet = new TreeSet<>(new WordComparator()); //Use to List Top 10 words
        ArrayList<String> wordsUsedOnce = new ArrayList<>(); //Use to List words used once

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            wordSet.add(new Words(entry.getKey(), entry.getValue()));
            if (entry.getValue() == 1) wordsUsedOnce.add(entry.getKey());
            //System.out.println(entry.getKey() + " " + entry.getValue());
        }

        //Display top 10 words
        System.out.println("Top Ten Words:");
        Object[] w = wordSet.toArray();
        for(int i=w.length-1; i>=w.length-10; i--) {
            System.out.println(w[i]);
        }

        System.out.println();

        //Display words used only once.
        System.out.println("Words used once:");
        int i=-1;
        for (String s : wordsUsedOnce) {
            if (i == -1) {
                i=0;
            } else {
                System.out.print(", ");
                if (i==16) {
                    System.out.println();
                    i=0;
                }
            }
            i++;
            System.out.print(s);
        }
        System.out.println("\n" + wordsUsedOnce.size() + " words used once.");

    }

    public static void main(String[] args) {
        new Main();
    }

}