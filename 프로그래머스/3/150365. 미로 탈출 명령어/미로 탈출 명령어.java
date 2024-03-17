class Solution {
    static int N, M, X, Y, R, C, K;
    static String answer = "";
    static char[] path;
    // Adjust the exploration order to prioritize lexicographically smaller paths
    static int[][] dirs = {{1, 0, 'd'}, {0, -1, 'l'}, {0, 1, 'r'}, {-1, 0, 'u'}};
    static boolean found = false;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n; M = m; X = x; Y = y; R = r; C = c; K = k;
        path = new char[k];

        dfs(X, Y, 0);
        return answer.isEmpty() ? "impossible" : answer;
    }

    static void dfs(int x, int y, int depth) {
        if(found) return; // Stop if already found

        // Check if it's possible to reach the destination from the current position
        if (Math.abs(x - R) + Math.abs(y - C) > K - depth || 
            (Math.abs(x - R) + Math.abs(y - C) + K - depth) % 2 != 0) return;

        if (x == R && y == C && depth == K) {
            found = true;
            answer = new String(path, 0, depth);
            return;
        }

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if (nx >= 1 && nx <= N && ny >= 1 && ny <= M) {
                path[depth] = (char) dir[2];
                dfs(nx, ny, depth + 1);
            }
        }
    }
}
