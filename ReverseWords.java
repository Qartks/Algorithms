package com.algorithms.qartks;

/**
 * Created by qartks on 2/16/17.
 */
public class ReverseWords {

    static public String reverseWords(String s) {
        if (s.length() == 0 || s == null) {
            return s;
        }

        String[] words = s.trim().split("\\s");
        StringBuilder sb = new StringBuilder();
//        for (int i = words.length - 1; i >=0 ; i--) {
//            if (words[i].equals("")) {
//                continue;
//            }
//            sb.append(words[i].trim());
//            sb.append(" ");
//        }

        for (String w : words) {
            if (w.equals("")) {
                continue;
            }
            sb.append(w.trim());
            sb.append(" ");
        }

        return sb.reverse().toString().trim();
    }

    public static void main(String[] args) {
        String s = " the sky is blue ";
        System.out.println(reverseWords(s));
    }
}
