

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int L;
	static int[] ta;
	static int[] cal;
	
	static int mx;

	public static void main(String[] args) throws NumberFormatException, IOException {

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		//System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			//칼로리 제한
			L = Integer.parseInt(st.nextToken());
			ta = new int[N];
			cal = new int[N];
			
			for(int i=0; i<N;i++) {
				st = new StringTokenizer(bf.readLine());
				ta[i]=Integer.parseInt(st.nextToken());
				cal[i]=Integer.parseInt(st.nextToken());
			}
			
			mx = 0;			
			calSum=0;
			taSum=0;
			calChk(0);
			sb.append("#").append(test_case).append(" ").append(mx).append("\n");
			
		}
		System.out.println(sb);
	}
	static int calSum=0;
	static int taSum =0;
	
	static public void calChk(int i) {
		if(calSum>L) {
			return;
		}else if(i==N) {
				mx = Math.max(mx, taSum);
			return;
		}
		
		calSum+=cal[i];
		taSum+=ta[i];
		calChk(i+1);
		calSum-=cal[i];
		taSum-=ta[i];
		calChk(i+1);
	}
}
