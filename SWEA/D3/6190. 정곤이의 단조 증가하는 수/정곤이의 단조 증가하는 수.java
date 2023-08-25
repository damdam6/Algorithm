import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		StringBuilder sb = new StringBuilder();
		// System.setIn(new FileInputStream("res/s_input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			
			int N = Integer.parseInt(bf.readLine());
			sb.append("#").append(test_case).append(" ");
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int cnt = 0;
			long mul;

			long max = 0;
			for (int i = 0; i < arr.length - 1; i++) {
				for (int j = i + 1; j < arr.length; j++) {
					mul = arr[i] * arr[j];

					if (check(mul)) {
						max = Math.max(max, mul);
						cnt++;
					}

				}
			}

			if(arr.length==1&&check(arr[0])) {
				sb.append(arr[0]).append("\n");
			}
			else if (cnt == 0) {
				sb.append(-1).append("\n");
			}else {
				sb.append(max).append("\n");
			}

		}

		System.out.println(sb);

	}

	static public boolean check(long n) {
		// n이 단조 증가하는 수인지 확인하는 메서드
		long tmp = n;
		
		while(tmp>0) {
			long n1=tmp%10; //먼저 나온 나머지 더 큰수여야함
			long n2=(tmp/10)%10;
			
			if(n1<n2) {
				return false;
			}
			tmp = tmp/10;
		}
		

		return true;
	}

}
