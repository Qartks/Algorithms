package com.algorithms.qartks;

/**
 * Created by qartks on 3/7/17.
 */
public class TomAndJerry {

    static final int INF = 9999;
    static class Point {
        int x, y;

        public Point (int ix, int iy) {
            this.x = ix;
            this.y = iy;
        }
    }

    static int[] xd = {1, 0, -1, 0};
    static int[] yd = {0, 1, 0, -1};

    static int minPathStep(int[][] maze, int x, int y, boolean[][] visited) {

        Point src = new Point(0, 0);
        Point dst = new Point(x, y);
        return minPathStep(maze, src, dst);


    }

    private static int minPathStep(int[][] maze, Point src, Point dst) {
        if (maze[src.x][src.y] == 1 || maze[dst.x][dst.y] == 1)
            return INF;
        return 0;
    }

    public static void main(String[] args) {
        int[][] maze = {{0, 2, 0},
                        {1, 1, 2},
                        {1, 0, 0}};

        boolean[][] visited = {{false, false, false},
                                {false, false, false},
                                {false, false, false}};

        System.out.println(minPathStep(maze, 2, 1, visited));
    }
}
