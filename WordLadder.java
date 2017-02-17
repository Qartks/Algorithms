package com.algorithms.qartks;

import java.util.*;

/**
 * Created by qartks on 2/17/17.
 */
public class WordLadder {

    static class QItem
    {
        String word;
        int len;

        public QItem(String s, int len) {
            this.word = s;
            this.len = len;
        }
    }

    public static boolean isAdjacent(String a, String b) {
        int count = 0;  // to store count of differences
        int n = a.length();

        // Iterate through all characters and return false
        // if there are more than one mismatching characters
        for (int i = 0; i < n; i++)
        {
            if (a.charAt(i) != b.charAt(i)) count++;
            if (count > 1) return false;
        }
        return count == 1 ? true : false;
    }

    public static int wordLabber(String s, String r, List<String> wordSet) {
        Queue<QItem> q = new LinkedList<>();
        QItem item = new QItem(s, 0);
        q.add(item);

        while (!q.isEmpty()) {

            QItem i = q.poll();

            Iterator<String> it = wordSet.iterator();
            while (it.hasNext()) {
                String temp = it.next();
                if (isAdjacent(i.word, temp)) {
                    item.word = temp;
                    item.len = i.len + 1;
                    q.add(item);
                    it.remove();
                    if (temp == r)
                        return item.len;
                }
            }

        }
        return 0;
    }
    public static void main(String[] args) {

        String s = "hit";
        String t = "cog";

        String[] arr = {"hot","dot","dog","lot","log","cog"};

        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("lot");
        list.add("log");
        list.add("cog");

        System.out.println(wordLabber(s, t, list));
    }
}
