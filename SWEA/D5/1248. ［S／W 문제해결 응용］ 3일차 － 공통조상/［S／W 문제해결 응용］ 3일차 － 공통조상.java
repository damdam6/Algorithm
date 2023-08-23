import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;
  
public class Solution {
     
    public static class node{
 
        //전부 숫자로 주어지므로 숫자로 해결 가능
        private int parent=0;
        private int chdL=0;
        private int chdR=0;
        private int cur;
         
        public node(int num) {
            this.cur = num;
        }
         
        public void setPar(int num) {
            this.parent=num;
        }
        public void setChd(int num) {
            if(chdL==0) {
                this.chdL = num;
            }else if(chdR==0) {
                this.chdR = num;
            }else {
                System.out.println("오류");
            }
        }
         
        public int getPar() {
            return this.parent;
        }
        public int getChdL() {
            return chdL;
        }
        public int getChdR() {
            return chdR;
        }
        public int getM() {
            return cur;
        }
         
        public String toString() {
            return "부모 "+parent+" 나 "+cur+" 자식 "+chdL+" "+chdR;
        }
         
    }
  
    static StringBuilder sb = new StringBuilder();
  
    public static void main(String args[]) throws NumberFormatException, IOException {
       //System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  
        int T = Integer.parseInt(bf.readLine());
  
        for (int test_case = 1; test_case <= T; test_case++) {
            // 첫줄에 정점의개수V 간선의개수E 공통조상찾는두놈1 2
            // 간선의 나열E
            // 부모-자식 부모-자식 / 부모2-자식2....
   
            // 일단 값부터 받기 - 첫줄
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
  
            // 짝수 - 부모노드
            // 홀수 - 자식 노드
             
            //자식값과 부모값 할당
            node[] noArr = new node[V+1];
            for(int i=1;i<noArr.length;i++)noArr[i]=new node(i);
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < E; i++) {
                int idx =Integer.parseInt(st.nextToken());
                //노드 생성
                 noArr[idx].setChd(Integer.parseInt(st.nextToken()));
                  
                if(noArr[idx].getChdL()!=0) {
                    noArr[noArr[idx].getChdL()].setPar(idx);
                }
                if(noArr[idx].getChdR()!=0) {
                    noArr[noArr[idx].getChdR()].setPar(idx);
                }     
 
            }
             
            //for(int i=1;i<noArr.length;i++)System.out.println(noArr[i].toString());
  
  
            ArrayList<Integer> n1Way = new ArrayList<Integer>();
            // node1의 부모노드를 찾아서 기록하기
            int n1 = node1;
            while (n1 != 1) {
                n1Way.add(n1);
                n1 = noArr[n1].getPar();
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
                n2 = noArr[n2].getPar();
            }
            //System.out.println(parent);
//// 
            //조상을 구했으므로 걔의 서브트리 구하기 BFS?
  
            Queue<node> qu = new ArrayDeque<>();
            int cnt = 0;
            // 탐색 시작의 대상부터 큐에 넣기
            qu.offer(noArr[parent]);
            int idx;
            while (!qu.isEmpty()) {
                cnt++;
                //cur은 현재의 부모 노드
               node cur = qu.poll();
                 
               if(cur.chdL!=0) {
                   qu.add(noArr[cur.chdL]);
               }
               if(cur.chdR !=0) {
                   qu.add(noArr[cur.chdR]);
               }
      
            }
            sb.append("#"+test_case+" "+parent+" "+cnt+"\n");
        }
        System.out.println(sb);
    }
  
}