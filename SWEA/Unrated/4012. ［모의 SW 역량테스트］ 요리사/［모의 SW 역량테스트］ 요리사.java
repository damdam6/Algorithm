import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
 
    static int N;
    static int[][] arr;
    static boolean[] chk;
    static int min;
 
    public static void main(String[] args) throws Exception {
 
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
 
        //System.setIn(new FileInputStream("res/sample_input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(bf.readLine());
 
        for (int test_case = 1; test_case <= T; test_case++) {
 
            N = Integer.parseInt(bf.readLine());
 
            arr = new int[N][N];
            chk = new boolean[N];
 
            // 다 입력 받기
            for (int i = 0; i < N; i++) {
                // 한 줄씩 잘라옴
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            // x-y와 y-x 모두 합해야됨
            min = Integer.MAX_VALUE;
 
            chk = new boolean[N];
            chk[0] =true;
            comb(1, 0, N/2-1);
 
            sb.append("#").append(test_case).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }
 
    static int sum;
    static int sum2;
    public static void comb(int idx, int sidx, int r) {
 
        if (sidx == r) {
            sum = add(0);
            sum2 = 0;
             
            for (int j = 0; j < chk.length; j++) {
                if (chk[j]) {
                    sum += add(j);
                } else {
                    sum2 += add(j);
                }
            }
            min = Math.min(min, Math.abs(sum - sum2));
 
        } else {
 
            for (int i = idx; i <= N - r + sidx; i++) {
                chk[i] = true;
                comb(i + 1, sidx + 1, r);
                chk[i] = false;
            }
 
        }
 
    }
     
    public static int add(int idx) {
        int all =0;
        for(int i=0;i<idx;i++) {
            if(chk[idx]==chk[i]) {
                all+=arr[idx][i]+arr[i][idx];
            }
        }       
        return all;
    }
 
}