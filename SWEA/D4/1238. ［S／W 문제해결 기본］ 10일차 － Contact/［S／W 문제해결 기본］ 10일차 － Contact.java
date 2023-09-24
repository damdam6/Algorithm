
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		int T =10;
		//System.setIn(new FileInputStream("res/input.txt"));
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			int[][] mtx = new int[101][101];
			st = new StringTokenizer(bf.readLine());

			for(int i=0;i<N/2;i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				mtx[a][b] =1;
			}
			
			//bfs

			Deque<node> qu = new ArrayDeque<>();

			int max = Integer.MIN_VALUE;
			int[] vt = new int[101];
			int numb = s;
			//첫번째꺼
			qu.offer(new node(s,0));
			vt[s] = 1;

			while(!qu.isEmpty()) {

				node tmp = qu.poll();
				
				//System.out.println(tmp.stage +"층 "+tmp.val);
				boolean ck = false;
				for(int i=1;i<101;i++) {

					if(vt[i]!=1 && mtx[tmp.val][i]==1) {
						ck = true;
						vt[i] = 1;
						qu.offer(new node(i, tmp));
					}
				}
				
					if(tmp.stage > max) {
						numb = tmp.val;
						max = tmp.stage;
					}else if(tmp.stage == max) {
						numb = Math.max(tmp.val, numb);
					}

			}

			sb.append("#"+tc+" "+numb).append("\n");
		}
		System.out.println(sb);
	}

	static class node{
		int stage;
		int val;
		public node(int val, int stage) {
			super();
			this.stage = stage;
			this.val = val;
		}

		public node(int val, node n) {
			super();
			this.stage = n.stage+1;
			this.val = val;
		}
	}

}
