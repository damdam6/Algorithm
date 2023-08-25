import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
     
    public static int N;
    public static int M;
    public static char[][] br;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
 
        StringBuilder sb = new StringBuilder();
        //System.setIn(new FileInputStream("res/sample_input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
 
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
             N = Integer.parseInt(st.nextToken());
             M = Integer.parseInt(st.nextToken());
              
             br = new char[N][M];
                for(int i=0;i<N;i++) {
                    br[i] = bf.readLine().toCharArray();
                }
             
             
            int m = N*M;
            for(int i=0;i<=N-3;i++) {
                for(int j=i+1;j<=N-2;j++) {
                    m = Math.min(m, color(i,j));
                }
            }
            sb.append("#"+test_case+" "+m+"\n");
        }
        System.out.println(sb);
    }
     
    //w줄까지 w
    //b줄까지 b
    public static int color(int w, int b) {
        int cnt = 0;
        //가로 탐색 하는 반복문
        for(int i=0;i<M;i++) {
            for(int j=0;j<w+1;j++) {
                if(br[j][i]!='W') cnt++;
            }
            for(int j=w+1;j<b+1;j++) {
                if(br[j][i]!='B') cnt++;
            }
            for(int j=b+1;j<N;j++) {
                if(br[j][i]!='R') cnt++;
            }
        }
        return cnt;
    }
}