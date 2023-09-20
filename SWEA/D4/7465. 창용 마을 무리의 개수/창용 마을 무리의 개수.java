

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int M;
	static int[][] grph;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/s_input.txt"));
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc=1;tc<=T;tc++) {
		StringTokenizer st = new StringTokenizer(bf.readLine());
		//N명 M개
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			grph = new int[N+1][N+1];
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(bf.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());				
				grph[a][b] = 1;
				grph[b][a] = 1;
			}

			
			//System.out.println();
			int cnt = 0;
			chk = new int[N+1];
			for(int i=1;i<N+1;i++) {
				//System.out.println(Arrays.toString(chk));
				if(chk[i]!=1) {
					cnt++;
					bfs(i);
				}
			}
			sb.append("#"+tc+" "+cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	static int[] chk;
	public static void bfs(int a) {
		Deque<Integer> qu = new ArrayDeque<>();
		
		qu.add(a);
		chk[a] = 1;
		while(!qu.isEmpty()) {
			//System.out.println(qu.toString());
			int x = qu.poll();
			
			for(int i=1;i<N+1;i++) {
				if(chk[i]!=1&&grph[x][i]==1) {
					qu.add(i);
					chk[i] = 1;
				}
			}
			
			
		}
		
	}

}
