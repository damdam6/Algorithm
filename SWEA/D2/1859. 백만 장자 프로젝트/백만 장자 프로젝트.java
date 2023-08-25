import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();

		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(bf.readLine());
			int[] price = new int[N];
			StringTokenizer st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < N; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}

			Stack<Integer> stk = new Stack<>();
			int btm = 0;
			long sum = 0;
			// 값을 받음 -> 뒤에서부터 탐색..ㅋㅋ
			for (int i = N - 1; i >= 0; i--) {
				if (stk.size() == 0) {
					// 스택이 비어있으면 스택에 집어넣으삼
					stk.push(price[i]);
				} else {
					// stk의 peek보다 작거나 같으면 스택에 넣기 -> btm일때 파니깐
					if (price[i] <= stk.peek()) {
						stk.push(price[i]);
					} else {
						// stk의 peek보다 크면 btm과의 차를 sum에 더하기
						while (stk.size() != 0 && price[i] > stk.peek()) {
							sum += btm - stk.pop();
						}
						stk.push(price[i]);
					}
					// stk 사이즈가 1이면 btm갱신

				}
				if (stk.size() == 1) {
					btm = stk.peek();
				}
			}

			while (stk.size() > 0) {
				sum += btm - stk.pop();
			}
			sb.append("#").append(test_case).append(" ").append(sum + "\n");

		}
		System.out.println(sb);

	}

}
