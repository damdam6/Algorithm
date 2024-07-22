import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        List<List<Integer>> tree = new ArrayList<>();

        for (int i = 0; i < N+1; i++) {
            tree.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        int[] parent = new int[N+1];

        ArrayDeque<Integer> qu = new ArrayDeque<>();

        qu.add(1);

        while(!qu.isEmpty()) {
            int tmp = qu.poll();

            for(int i: tree.get(tmp)) {
                if(parent[i] == 0) {
                    parent[i] = tmp;
                    qu.add(i);
                }
            }


        }

        for (int i = 2; i < N+1 ; i++) {
            System.out.println(parent[i]);
        }



    }
}
