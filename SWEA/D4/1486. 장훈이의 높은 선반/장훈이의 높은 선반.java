

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int min;
	static int N;
	static int B;

	static int[] empArr;

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(bf.readLine());
			empArr = new int[N];
			for (int i = 0; i < N; i++) {
				empArr[i] = Integer.parseInt(st.nextToken());
			}

			min = Integer.MAX_VALUE;
			check();
			sb.append("#"+tc+" "+(min-B)+"\n");
			

		} // tc 종료
		System.out.println(sb);

	} // main 종료

	public static void check() {
		// 전체 경우의 수 탐색용 <<
		for (int i = 0; i < (1 << N); i++) {

			int top = 0;
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) > 0) {
					top += empArr[j];
				}

				if(top>=B)min = Math.min(top, min);
			}
		}

	}

}
