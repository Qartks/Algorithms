package com.algorithms.qartks;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by qartks on 3/20/17.
 */
public class Portfolio {

/*
 * Complete the function below.
 */

    static class BNode {
        BNode left;
        BNode right;
        long data;

        public BNode(long d) {
            left = null;
            right = null;
            data = d;
        }
    }
    static int findMax(int n, String tree) {
        if (tree == null || tree.length() == 0 || n == 0) {
            return 0;
        }

        String[] s = tree.split(" ");
        BNode root = new BNode(Long.parseLong(s[0]));
        Queue<BNode> q = new LinkedList<>();

        q.add(root);
        int i = 0;
        while (!q.isEmpty()) {
            BNode curr = q.poll();

            if (2 * i + 1 >= s.length) {
                break;
            }

            if (s[2*i + 1].equals("#")) {
                curr.left = null;
            } else {
                curr.left = new BNode(Integer.parseInt(s[2*i + 1]));
                q.add(curr.left);
            }

            if (2*i + 2 >= s.length) {
                break;
            }

            if (s[2*i + 2].equals("#")) {
                curr.right = null;
            } else {
                curr.right = new BNode(Integer.parseInt(s[2*i + 2]));
                q.add(curr.right);
            }
            i+=1;
        }

        return (int) getMaxInvestment(root);

    }

    public static long getMaxInvestment(BNode node) {
        if (node == null) {
            return 0;
        }
        Map<BNode, Long> map = new HashMap<>();
        return getMaxInvestmentHelper(node, map);
    }

    public static long getMaxInvestmentHelper(BNode node, Map<BNode, Long> map) {
        if (node == null) {
            return 0;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        }

        long nextLevel = node.data + getSumOfNextLevel(node, map);
        long thisLevel = getMaxInvestmentHelper(node.left, map) + getMaxInvestmentHelper(node.right, map);
        map.put(node, Math.max(thisLevel, nextLevel));

        return map.get(node);
    }

    public static long getSumOfNextLevel(BNode node, Map<BNode, Long> map) {
        long result = 0;

        if (node.left != null) {
            result += getMaxInvestmentHelper(node.left.left, map) + getMaxInvestmentHelper(node.left.right, map);
        }
        if (node.right != null) {
            result += getMaxInvestmentHelper(node.right.left, map) + getMaxInvestmentHelper(node.right.right, map);
        }

        return result;
    }


    public static void main(String[] args) {
//        String s = "3 4 5 1 3 # 1";
        String s = "1 2 3 1 # 4 5";
        System.out.println(findMax(6, s));
    }

}
