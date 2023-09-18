

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		//System.setIn(new FileInputStream("res/s_input.txt"));		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st= new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N+1][N+1];
			for(int i=0;i<M;i++) {
				st= new StringTokenizer(bf.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a][b] = 1;
				arr[b][a] = 1;
			}
			int cnt =0;
			
			//첫번째 정점
			for(int i=1;i<N+1;i++) {
				//두 번째 정점
				for(int j=i+1;j<N+1;j++) {
					if(arr[i][j]!=1) continue;
					
					//세번째 정점
					for(int k=j+1;k<N+1;k++) {
						
						if(arr[j][k]==1 && arr[k][i] ==1)cnt++;
					}
					
				}
				
			}
			sb.append("#"+test_case+" "+cnt+"\n");
		}
		
		System.out.println(sb);
	}
	
	
	

}


