
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


		private int parent=0;
		private int chdL=0;
		private int chdR=0;
		
		public node() {
			
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
		
	}
 
    static StringBuilder sb = new StringBuilder();
 
    public static void main(String args[]) throws NumberFormatException, IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(bf.readLine());
 
        for (int test_case = 1; test_case <= T; test_case++) {

            StringTokenizer st = new StringTokenizer(bf.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
 
            node[] noArr = new node[V+1];
            for(int i=0;i<noArr.length;i++)noArr[i]=new node();
            
            st = new StringTokenizer(bf.readLine());
            for (int i = 0; i < E; i++) {
            	int idx =Integer.parseInt(st.nextToken());
            	 noArr[idx].setChd(Integer.parseInt(st.nextToken()));
            	 
             	if(noArr[idx].getChdL()!=0) {
            		noArr[noArr[idx].getChdL()].setPar(idx);
            	}
             	if(noArr[idx].getChdR()!=0) {
            		noArr[noArr[idx].getChdR()].setPar(idx);
            	}

            }
            ArrayList<Integer> n1Way = new ArrayList<Integer>();

            int n1 = node1;
            while (n1 != 1) {
                n1Way.add(n1);
                n1 = noArr[n1].getPar();
            }
            n1Way.add(1);

            int n2 = node2;

            int parent = 1;
            while (n2 != 1) {
                if (n1Way.contains(n2)) {
                    parent = n2;
                    break;
                }
                n2 = noArr[n2].getPar();
            }

            Queue<node> qu = new ArrayDeque<>();
            int cnt = 0;

            qu.offer(noArr[parent]);

            while (!qu.isEmpty()) {
                cnt++;
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
