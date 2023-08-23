import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
 
    static StringBuilder sb = new StringBuilder();
 
    public static void main(String args[]) throws Exception {
        //System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(bf.readLine());
 
        for (int test_case = 1; test_case <= T; test_case++) {
            // 첫줄에 정점의개수V 간선의개수E 공통조상찾는두놈1 2
            // 간선의 나열E
            // 부모-자식 부모-자식 / 부모2-자식2....
 
            // 해결방안
            // 자식 -> 루트 노드로 탐색하는 방법체크
            // 두 개의 경로 중 가장 먼저 공통으로 등장하는 노드 check
            // 서브 트리의 크기도??? ㅁㅊ..
 
            // 서브 트리는 BFS로 해결해보기
 
            // 자식 -> 부모 루트 탐색하기
 
            // 일단 값부터 받기 - 첫줄
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
 
            // 짝수 - 부모노드
            // 홀수 - 자식 노드
            st = new StringTokenizer(bf.readLine());
            ArrayList<Integer> parArr = new ArrayList<Integer>();
            ArrayList<Integer> subArr = new ArrayList<Integer>();
            for (int i = 0; i < E; i++) {
                parArr.add(Integer.parseInt(st.nextToken()));
                subArr.add(Integer.parseInt(st.nextToken()));
            }
 
            ArrayList<Integer> n1Way = new ArrayList<Integer>();
 
            // node1의 부모노드를 찾아서 기록하기
            int n1 = node1;
            while (n1 != 1) {
                n1Way.add(n1);
                n1 = parArr.get(subArr.indexOf(n1));
            }
            n1Way.add(1);
            //System.out.println(n1Way.toString());
 
            // 2가 탐색하는 중간에 n1Way에 있는지 확인
            int n2 = node2;
 
            // 공통 조상 노드 담을 변수
            int parent = 1;
            while (n2 != 1) {
                if (n1Way.contains(n2)) {
                    parent = n2;
                    break;
                }
                n2 = parArr.get(subArr.indexOf(n2));
            }
 
            // 조상을 구했으므로 걔의 서브트리 구하기 BFS?
 
            Queue<Integer> qu = new ArrayDeque<>();
            int cnt = 0;
            // 탐색 시작의 대상부터 큐에 넣기
            qu.offer(parent);
            int idx;
            while (!qu.isEmpty()) {
                cnt++;
                //cur은 현재의 부모 노드
                int cur = qu.poll();
                while(parArr.contains(cur)) {
                    idx = parArr.indexOf(cur);
                    qu.offer(subArr.get(idx));
                    parArr.set(idx, 0);
                }
     
            }
            sb.append("#"+test_case+" "+parent+" "+cnt+"\n");
        }
        System.out.println(sb);
    }
 
}