import java.util.LinkedList;
import java.util.Queue;

public class Wave {
    static int M = 5;
    static int N = 5;

    static boolean isValid(int[][] matrix, boolean[][] visited, int row, int col) {
        return ((row >= 0) && (row < M)) && ((col >= 0) && (col < N)) && (matrix[row][col] == 1)
                && (!visited[row][col]);
    }

    private static void bfs(int[][] matrix, int sourceX, int sourceY, int targetX, int targetY) {
        int[] row = new int[] { -1, 0, 0, 1 };
        int[] col = new int[] { 0, -1, 1, 0 };

        int minimumDistance = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[M][N];
        visited[sourceX][sourceY] = true;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sourceX, sourceY, 0));
        while (!q.isEmpty()) {
            Node currentNode = q.poll();
            if (currentNode.x == targetY && currentNode.y == targetX) {
                minimumDistance = currentNode.dist;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int newX = currentNode.x + row[i];
                int newY = currentNode.y + col[i];
                if (isValid(matrix, visited, newX, newY)) {
                    visited[newX][newY] = true;
                    Node n = new Node(newX, newY, currentNode.dist + 1);
                    q.add(n);
                }
            }
        }
        if (minimumDistance == Integer.MAX_VALUE) {
            System.out.println("Not path");
        } else {
            System.out.println("The shorted path - " + minimumDistance);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 0, 0, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 0, 1, 0, 1, 1 },
                { 0, 0, 0, 0, 1 },
                { 1, 1, 0, 0, 1 }
        };
        bfs(matrix, 0, 0, 3, 2);
    }
}

class Node {
    public int x;
    public int y;
    public int dist;

    Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
