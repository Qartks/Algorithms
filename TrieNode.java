package com.algorithms.qartks;

/**
 * Created by qartks on 2/28/17.
 */
public class TrieNode {

    TrieNode[] children;
    boolean isWord;
    char val;

    public TrieNode () {
        children = new TrieNode[26];
        isWord = false;
        val = ' ';
    }

    public TrieNode (char c) {
        children = new TrieNode[26];
        isWord = false;
        val = c;
    }

    public int getSize() {
        int count = 0;
        for (int i = 0; i < children.length; i++) {
            count += (children[i] == null ? 0 : 1);
        }
        return count;
    }

    public boolean containsChar (char c) {
        int idx = c - 'a';
        return children[idx] != null;
    }
}
