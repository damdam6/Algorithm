import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int N;
    static int[][] poArr;
    static int min;
    static boolean[] visited;
    static int dis;
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        //System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
             
            //xy
            poArr = new int[N+2][2];
            visited = new boolean[N+2];
            //0 회사
            poArr[0][0] = Integer.parseInt(st.nextToken());
            poArr[0][1] = Integer.parseInt(st.nextToken());
            //1 집
            poArr[1][0] = Integer.parseInt(st.nextToken());
            poArr[1][1] = Integer.parseInt(st.nextToken());
             
            //2부터 N+1까지의 인덱스를 순회하면서....
            for(int i=0;i<N;i++) {
                poArr[i+2][0] = Integer.parseInt(st.nextToken());
                poArr[i+2][1] = Integer.parseInt(st.nextToken());
            }
            visited[0] = true;
            visited[1] = true;
             
            min = Integer.MAX_VALUE;
             
            dis = 0;
            go(0,0);
            sb.append("#"+tc+" "+min+"\n"); 
        }
        System.out.println(sb);
    }
     
    public static void go(int cnt, int idx) {
         
        if(dis>min) {
            return;
        }
        if(cnt==N) {
            int tmp = dis;
            dis += Math.abs(poArr[idx][0] - poArr[1][0])+Math.abs(poArr[idx][1] - poArr[1][1]);
            min = Math.min(min, dis);
            dis = tmp;
            return;
        }
        visited[idx] = true;
        for(int i=2;i<=N+1;i++) {
            //visited - true /가면 안됨
            if(visited[i])continue;
            int tmp = dis;
            dis += Math.abs(poArr[idx][0] - poArr[i][0])+Math.abs(poArr[idx][1] - poArr[i][1]);
            go(cnt+1,i);
            dis = tmp;
        }
        visited[idx] = false;
    }
 
}