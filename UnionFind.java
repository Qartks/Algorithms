package com.algorithms.qartks;

import java.util.Arrays;

/**
 * Created by qartks on 2/9/17.
 */
public class UnionFind {

    class Edge {
        int src;
        int dst;

        Edge() {}

        Edge(int s, int d) {
            this.src = s;
            this.dst = d;
        }
    }

    private int V;
    private int parent[];
    private Edge[] edges;

    private UnionFind(int v, int e) {
        this.V = v;
        parent = new int[V];
        Arrays.fill(parent, -1);

        edges = new Edge[e];
        for (int i = 0; i < e; i++) {
            edges[i] = new Edge();
        }
    }

    private int find(int i) {
        if (parent[i] == -1) {
            return i;
        } else {
            return find(parent[i]);
        }
    }

    private void union(int i, int j) {
        parent[find(i)] = find(j);
    }

    private boolean Union_Find() {

        for (int i = 0; i < edges.length; i++) {
            int x = find(edges[i].src);
            int y = find(edges[i].dst);

            if (x != y) {
                union(x, y);
            } else {
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        UnionFind graph = new UnionFind(5, 6);

        graph.edges[0].src = 0;
        graph.edges[0].dst = 1;

        // add edge 1-2
        graph.edges[1].src = 1;
        graph.edges[1].dst = 2;

        // add edge 0-2
        graph.edges[2].src = 0;
        graph.edges[2].dst = 2;

        System.out.println(graph.Union_Find());
    }

}
