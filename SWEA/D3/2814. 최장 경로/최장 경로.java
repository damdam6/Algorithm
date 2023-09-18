
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static boolean[] chk;
	static int maxLong;
	static int cnt;
	static int N;
	static int[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		//System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			chk = new boolean[N+1];
			maxLong = 1;
			cnt = 0;
			arr = new int[N + 1][N + 1];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(bf.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a][b] = 1;
				arr[b][a] = 1;
			}
			for(int i=1;i<N+1;i++) {
				dfs(i);
			}
			sb.append("#"+test_case+" "+maxLong+"\n");
		}
		System.out.println(sb);

	}
	
	public static void dfs(int idx) {
		if(chk[idx]){

			
			maxLong = Math.max(maxLong, cnt);
			return;
		}
		
		cnt++;
		chk[idx]=true;
		for(int i=1;i<N+1;i++) {
			if(arr[idx][i]!=1)continue;
			dfs(i);
		}
		chk[idx]=false;
		cnt--;
		
	}

}
