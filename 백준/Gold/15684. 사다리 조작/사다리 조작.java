import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H;
    static boolean[][] ladder;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로선
        M = Integer.parseInt(st.nextToken()); // 가로선
        H = Integer.parseInt(st.nextToken()); // 가로선을 놓을 수 있는 위치

        ladder = new boolean[H+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a][b] = true;
        }

        for (int i = 0; i <= 3; i++) {
            dfs(1, 0, i);
            if (answer != Integer.MAX_VALUE) break;
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void dfs(int x, int count, int limit) {
        if (count == limit) {
            if (check()) answer = count;
            return;
        }

        for (int i = x; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if (!ladder[i][j] && !ladder[i][j-1] && !ladder[i][j+1]) {
                    ladder[i][j] = true;
                    dfs(i, count + 1, limit);
                    ladder[i][j] = false;
                }
            }
        }
    }

    static boolean check() {
        for (int i = 1; i <= N; i++) {
            int col = i;
            for (int row = 1; row <= H; row++) {
                if (ladder[row][col]) col++;
                else if (col > 1 && ladder[row][col-1]) col--;
            }
            if (col != i) return false;
        }
        return true;
    }
}
