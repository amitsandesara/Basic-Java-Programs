public class MazePath {
    static int N;
    static int x1;
    static int y1;

    static void printSolution(int sol[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + sol[i][j] + " ");
            System.out.println();
        }
    }

    static boolean isSafe(int maze[][], int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
    }

    public static int isPath(int[][] grid) {
        N = grid.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 9) {
                    x1 = i;
                    y1 = j;
                }
            }
        }
        int sol[][] = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}};

        if (solveMazeUtil(grid, 0, 0, sol) == false) {
            System.out.print("Solution doesn't exist");
            return 0;
        }

        System.out.println("Solution exist");
        printSolution(sol);
        return 1;
    }

    static boolean solveMazeUtil(int maze[][], int x, int y, int sol[][]) {
        if (x == x1 && y == y1) {
            if (maze[x][y] == 9)
                sol[x][y] = 9;
            else
                sol[x][y] = 1;
            return true;
        }

        // Check if maze[x][y] is valid
        if (isSafe(maze, x, y) == true) {
            if (maze[x][y] == 9)
                sol[x][y] = 9;
            else
                sol[x][y] = 1;

            if (solveMazeUtil(maze, x + 1, y, sol))
                return true;

            if (solveMazeUtil(maze, x, y + 1, sol))
                return true;



            sol[x][y] = 0;
            return false;
        }

        return false;
    }

    public static void main(String args[]) {
        int maze[][] = {{1, 0, 0, 0, 0}, {1, 1, 1, 1, 0}, {0, 1, 0, 9, 1}, {1, 1, 1, 1, 1},
                {0, 1, 0, 0, 1}};

        MazePath.isPath(maze);
    }
}
