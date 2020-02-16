package edu.wctc;

import java.util.Comparator;

public class WordComparator implements Comparator<Words> {
    @Override
    public int compare(Words w1, Words w2) {
        String s1 = w1.getValue();
        String s2 = w2.getValue();
        return s1.compareTo(s2);
    }

}
