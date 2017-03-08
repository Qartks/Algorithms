package com.algorithms.qartks;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
	
	private int V;
	private LinkedList<Integer> adj[];
	
	Graph(int v) {
		this.V = v;
		adj = new LinkedList[v];
		for(int i = 0; i <V; i++) {
			adj[i] = new LinkedList();
		}
	}
	
	void addEdge(int s, int d)
    {
		adj[s].add(d);
	}

	void BFS(int s)
    {
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            int n = queue.poll();
            System.out.print(n + " ");

            Iterator<Integer> it = adj[n].listIterator();
            while (it.hasNext()) {
                int curr = it.next();
                if (!visited[curr]) {
                    queue.add(curr);
                    visited[curr] = true;
                }
            }
        }
    }


    void DFS(int s) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        visited[s] = true;
        stack.push(s);

        while (!stack.isEmpty()) {
            s = stack.pop();
            System.out.print(s + " ");
            visited[s] = true;
            Iterator<Integer> it = adj[s].listIterator();
            while (it.hasNext()) {
                int curr = it.next();
                if (!visited[curr]) {
                    stack.push(curr);
                }
            }
        }

    }

    int minDistance(int dist[], boolean sptSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index=-1;

        for (int v = 0; v < V; v++)
            if (!sptSet[v] && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    void printSolution(int dist[], int[] prev)
    {
        System.out.println("Vertex   Distance from Source   Prev Node");
        for (int i = 0; i < V; i++)
            System.out.println(i+" \t\t "+dist[i] + "\t\t\t\t\t\t" + prev[i]);
    }

    void Dijkstra(int[][] graph, int src)
    {
        int[] weight = new int[V];
        boolean[] spt = new boolean[V];
        int[] prev = new int[V];

        Arrays.fill(weight, Integer.MAX_VALUE);

        weight[src] = 0;

        for (int i = 0; i < V - 1; i++) {
            int u = minDistance(weight, spt);
            spt[u] = true;

            for (int j = 0; j < V; j++) {
                if (!spt[j] && graph[u][j]!=0 && weight[u] != Integer.MAX_VALUE && weight[u] + graph[u][j] < weight[j]) {
                    prev[j] = u;
                    weight[j] = weight[u] + graph[u][j];
                }
            }
        }

        printSolution(weight, prev);

    }

    void floydWarshall(int[][] graph)
    {
        int[][] dist = new int[V][V];
        int k,i, j;

        for (i = 0; i <dist.length ; i++) {
            dist[i] = graph[i];
        }

        for (k = 0; k < V; k++)
        {
            // Pick all vertices as source one by one
            for (i = 0; i < V; i++)
            {
                // Pick all vertices as destination for the
                // above picked source
                for (j = 0; j < V; j++)
                {
                    // If vertex k is on the shortest path from
                    // i to j, then update the value of dist[i][j]
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        for (i = 0; i <dist.length ; i++) {
            System.out.println(Arrays.toString(dist[i]));
        }

    }
	
	void topologicalSort() {
		Stack<Integer> s = new Stack<Integer>();
		boolean[] visited = new boolean[V];
		Arrays.fill(visited, false);
		
		for(int i = 0; i<V; i++) {
			if (!visited[i]) {
				topologicalSortUtil(i, visited, s);
			}
		}
		
		while(!s.empty()) {
            System.out.println(s.pop() + " ");
        }
	}

	private void topologicalSortUtil(int i, boolean[] visited, Stack<Integer> s) {
		visited[i] = true;
		Integer v;
		
		Iterator<Integer> it = adj[i].iterator(); 
		while(it.hasNext()) {
			v = it.next();
			if (!visited[v]) {
				topologicalSortUtil(v, visited, s);
			}
		}

		s.push(i);
	}


	private boolean hasCycle() {
	    boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (hasCycleUtil(i, visited, recStack))
                return true;
        }

        return false;
    }

    private boolean hasCycleUtil(int i, boolean[] visited, boolean[] recStack) {

	    if (!visited[i]) {
	        visited[i] = true;
	        recStack[i] = true;

	        Iterator<Integer> it = adj[i].iterator();
	        while (it.hasNext()) {
	            int n = it.next();
	            if (!visited[i] && hasCycleUtil(n, visited, recStack)) {
	                return true;
                } else if (recStack[n]) {
	                return true;
                }
            }
        }
        recStack[i] = false;
	    return false;
    }

    public static void main(String[] args) {
		// TODO Auto-generated method stub

//        Graph g = new Graph(6);
//        g.addEdge(5, 2);
//        g.addEdge(5, 0);
//        g.addEdge(4, 0);
//        g.addEdge(4, 1);
//        g.addEdge(2, 3);
//        g.addEdge(3, 1);

//        g.topologicalSort();


//        Graph g = new Graph(4);
//
//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 2);
//        g.addEdge(2, 0);
//        g.addEdge(2, 3);
//        g.addEdge(3, 3);

//        g.BFS(2);
//        g.DFS(2);

//        Graph g = new Graph(9);
//
//        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
//                {4, 0, 8, 0, 0, 0, 0, 11, 0},
//                {0, 8, 0, 7, 0, 4, 0, 0, 2},
//                {0, 0, 7, 0, 9, 14, 0, 0, 0},
//                {0, 0, 0, 9, 0, 10, 0, 0, 0},
//                {0, 0, 4, 14, 10, 0, 2, 0, 0},
//                {0, 0, 0, 0, 0, 2, 0, 1, 6},
//                {8, 11, 0, 0, 0, 0, 1, 0, 7},
//                {0, 0, 2, 0, 0, 0, 6, 7, 0}};
//
//        System.out.println();
//        g.Dijkstra(graph, 0);

        final int INF = 99999;
//
        Graph g = new Graph(4);
        int graph[][] = { {0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
        };

        g.floydWarshall(graph);
		
	}

}
