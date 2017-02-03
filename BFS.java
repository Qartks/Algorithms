package com.algorithms.qartks;

import java.util.*;

/**
 * Created by qartks on 2/2/17.
 */
public class BFS {

    static class Graph {
        int V;
        List<List<Integer>> adjList;

        Graph(int size) {
            this.V = size;
            adjList = new ArrayList<>();
            while (size-- > 0) {
                adjList.add(new ArrayList<>());
            }
        }

        void addEdge(int startId, int endId) {
            adjList.get(startId).add(endId);
            adjList.get(endId).add(startId);
        }

        int[] shortDistances(int startId) {
            int[] distances = new int[V];
            boolean visited[] = new boolean[V];

            Arrays.fill(distances, -1);
            distances[startId] = 0;

            Queue<Integer> q = new LinkedList<>();
            q.offer(startId);

            while (!q.isEmpty()) {
                Integer v = q.poll();
                visited[v] = true;

                List<Integer> neighbours = adjList.get(v);
                Iterator<Integer> it = neighbours.iterator();
                while (it.hasNext()) {
                    Integer u = it.next();
                    if (!visited[u]) {
                        q.offer(u);
                        visited[u] = true;
                        distances[u] = distances[v] + 6;
                    }
                }
            }
            return distances;
        }

    }

    public static void main(String[] args) {
        Graph g = new Graph(8);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 4);
        g.addEdge(3, 5);
        g.addEdge(2, 6);

        int startId = 0;
        int[] distances = g.shortDistances(startId);

        for (int i = 0; i < distances.length; i++) {
            if (i != startId) {
                System.out.print(distances[i]);
                System.out.print(" ");
            }
        }
        System.out.println();


    }
}
