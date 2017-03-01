package com.algorithms.qartks;

/**
 * Created by qartks on 2/28/17.
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            if ( curr.children[idx] == null )
                curr.children[idx] = new TrieNode(c);
            curr = curr.children[idx];
        }
        curr.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            if ( curr.children[idx] != null ) {
                curr = curr.children[idx];
            } else {
                return false;
            }
        }
        return curr.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int idx = c - 'a';
            if (curr.children[idx] == null) return false;
            curr = curr.children[idx];
        }
        return true;
    }

    public String longestCommonPrefix(String word) {
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            if (curr.containsChar(c) && curr.getSize() == 1 && !curr.isWord) {
                sb.append(c);
                curr = curr.children[idx];
            } else {
                return sb.toString();
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Trie t = new Trie();

        t.insert("hello");
        t.insert("world");

        System.out.println(t.search("hello"));
        System.out.println(t.search("hell"));
        System.out.println(t.startsWith("hell"));

        Trie t2 = new Trie();
        String[] strs = {"prefix", "prefox", "prefbox", "prefsox", "prefp"};

        for (String s: strs) {
            t2.insert(s);
        }

        System.out.println();
        System.out.println(t2.longestCommonPrefix(strs[0]));
    }
}
