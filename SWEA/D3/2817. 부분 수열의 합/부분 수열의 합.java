
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static StringTokenizer st;
	static int[] arr;

	static int K;
	static int N;

	static int cnt = 0;
	static int sum = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for (int test_case = 1; test_case <=T; test_case++) {
			st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(bf.readLine());
			arr = new int[N];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			cnt = 0;

			checkK(0);

			sb.append("#"+test_case+" "+cnt+"\n");
		
		}

		System.out.println(sb);
	}


	// 조합 만들기
	public static void checkK(int i) {		
		if(sum>K||i>N) {
			return;
		}else if(sum==K) {
			cnt++;
			return;
		}else if(i==N) {
			return;
		}

		sum += arr[i];
		checkK(i+1);
		sum -= arr[i];
		checkK(i+1);	
			
	}
}
