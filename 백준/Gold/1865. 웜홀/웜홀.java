
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for (int test_case = 0; test_case < tc; test_case++) {
            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            ArrayList<Edge> edges = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(bf.readLine());
                int  s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());
                edges.add(new Edge(s,e,val));
                edges.add(new Edge(e, s,val));
            }
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(bf.readLine());
                int  s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());
                edges.add(new Edge(s, e, -1*val));
            }


            boolean checkFlag = false;


                checkFlag = checkHasMinusCycle(N, edges);



            if(checkFlag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }
    }

    static int checkIdxNotReached(int[] dist){
        for (int i = 0; i < dist.length; i++) {
            if(dist[i] == Integer.MAX_VALUE){
                return i;
            }
        }
        return -1;
    }


    static boolean checkHasMinusCycle(int N, ArrayList<Edge> edges){

        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int checkAll = 1;


        while(checkAll != -1){
            dist[checkAll] = 0;
            for (int i = 0; i < N-1; i++) {
                for(Edge e: edges){
                    if(dist[e.s] != Integer.MAX_VALUE && dist[e.s] + e.val < dist[e.e]){
                        dist[e.e] = dist[e.s] + e.val;
                    }
                }
            }
            checkAll = checkIdxNotReached(dist);
        }

        for(Edge e: edges){
            if(dist[e.s] != Integer.MAX_VALUE && dist[e.s] + e.val < dist[e.e]){
                return true;
            }
        }

        return false;
    }

    static class Edge{
        int s;
        int e;
        int val;

        public Edge(int s, int e, int val) {
            this.s = s;
            this.e = e;
            this.val = val;
        }
    }
}
