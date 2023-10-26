import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        dp = new int[N][N];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // Initialize base cases
        for (int i = 0; i < N; i++) {
            dp[i][i] = 1; // every single number is a palindrome
            if (i < N - 1 && arr[i] == arr[i + 1]) {
                dp[i][i + 1] = 1; // two consecutive same numbers are palindrome
            }
        }

        // Build up dp table
        for (int len = 3; len <= N; len++) {
            for (int i = 0; i <= N - len; i++) {
                int j = i + len - 1;
                if (arr[i] == arr[j] && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                }
            }
        }

        M = Integer.parseInt(bf.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            sb.append(dp[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1]).append("\n");
        }
        System.out.println(sb);
    }
}
