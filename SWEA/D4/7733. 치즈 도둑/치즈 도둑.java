import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
 
public class Solution {
 
    static int N;
    static int[][] chkArr;
    static int[][] ch;
    static Deque<int[]> qu = new ArrayDeque<>();
 
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("res/input.txt"));
 
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(bf.readLine());
            ch = new int[N][N];
             
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    ch[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            int maxP = 1;
            for (int n = 1; n <= 100; n++) {
                chkArr = new int[N][N];
                cnt = 0;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
 
                        bfs(i, j, n);
                    }
                }
 
                maxP = Math.max(maxP, cnt);
 
            }
            sb.append("#"+tc+" "+maxP).append("\n");
 
        }
        System.out.println(sb);
    }
 
    // check 덩어리
    static int[] dx = new int[] { -1, 1, 0, 0 };
    static int[] dy = new int[] { 0, 0, 1, -1 };
    static int cnt;
 
    static void bfs(int x, int y, int now) {
 
        if (chkArr[x][y] != 0 || ch[x][y] <= now)
            return;
 
        // 시작점 qu에 넣기
        chkArr[x][y] = 1;
        qu.add(new int[] { x, y });
 
        int[] tmp;
        while (!qu.isEmpty()) {
            tmp = qu.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                //제한 조건들
                if(nx<0 || nx>=N||ny<0||ny>=N)continue;
                if (chkArr[nx][ny] != 0 || ch[nx][ny] <= now)continue;
 
                chkArr[nx][ny] = 1;
                qu.add(new int[] { nx, ny });
            }
        }
 
        cnt++;
    }
 
}