import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        boolean[][] graph = new boolean[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        int[] distances = new int[n + 1];

        // Construct the graph
        for (int[] link : edge) {
            graph[link[0]][link[1]] = graph[link[1]][link[0]] = true;
        }

        queue.add(1);
        visited[1] = true;

        // BFS
        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i = 2; i <= n; i++) {
                if (graph[node][i] && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    distances[i] = distances[node] + 1;
                }
            }
        }

        // Find the maximum distance
        int maxDistance = Arrays.stream(distances).max().getAsInt();
        int count = 0;
        for (int distance : distances) {
            if (distance == maxDistance) {
                count++;
            }
        }

        return count;
    }
}
