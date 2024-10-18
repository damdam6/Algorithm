import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        // 위 왼 오 에서 진입할 때의 기록을 칸마다.
        // 두 줄을 가지고 진행.
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] mars = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                mars[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 위 왼 오
        int[][][] dp = new int[N][M][4];


        dp[0][0][0] = mars[0][0];
        dp[0][0][1] = mars[0][0];
        dp[0][0][2] = mars[0][0];
        dp[0][0][3] = mars[0][0];

        for (int j = 1; j < M; j++) {
            dp[0][j][0] = Integer.MIN_VALUE;
            dp[0][j][1] = mars[0][j] + dp[0][j-1][1];
            dp[0][j][2] = Integer.MIN_VALUE;
            dp[0][j][3] = mars[0][j] + dp[0][j-1][1];
        }

        for (int i = 1; i < N; i++) {

            // 위에서 내려오기 -> 가장 큰 값 3에 저장
            for (int j = 0; j < M; j++) {
                dp[i][j][0] = dp[i-1][j][3] + mars[i][j];
            }
            // 가장 좌측에서 -> 우측으로 갱신 (0번 숫자 기준)
            dp[i][0][1] = mars[i][0] + dp[i-1][0][3];
            for (int j = 1; j < M; j++) {
                dp[i][j][1]= mars[i][j] + Math.max(dp[i][j-1][0], dp[i][j-1][1]);
            }
            // 가장 우측에서 -> 가장 좌측으로 갱신 (0번 숫자 기준)
            dp[i][M-1][2] = mars[i][M-1] + dp[i-1][M-1][3];
            for (int j = M-2; j >= 0 ; j--) {
                dp[i][j][2]= mars[i][j] + Math.max(dp[i][j+1][0], dp[i][j+1][2]);
            }

            for (int j = 0; j < M; j++) {
                dp[i][j][3] = Math.max(dp[i][j][0], dp[i][j][1]);
                dp[i][j][3] = Math.max(dp[i][j][3], dp[i][j][2]);
            }


        }

        System.out.println(dp[N-1][M-1][3]);

    }
}
