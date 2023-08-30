

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] arr;
	static int[] combArr;
	static int[] comb2Arr;
	static boolean[] chk;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 가능한 조합의 갯수 쌍을 구하고
		// 해당하는 조합을 구하여
		// 그 경우만 살펴보자

		// N은 짝수이므로 N/2일때는 딱 절반만 하면 된다.
		// 1~N/2라고 생각해보자
		// 1 , N-1
		// 2, N-2 ....
		// N/2까지가 갯수임

		// r개의 조합을 구하는 코드

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			N = Integer.parseInt(bf.readLine());

			arr = new int[N][N];
			combArr = new int[N];
			comb2Arr = new int[N];
			chk = new boolean[N];

			// 다 입력 받기
			for (int i = 0; i < N; i++) {
				// 한 줄씩 잘라옴
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// x-y와 y-x 모두 합해야됨
			min = Integer.MAX_VALUE;

			for (int i = 2; i <= N / 2; i++) {
				comb(0, 0, 0, i);
			}

			sb.append("#").append(test_case).append(" ").append(min).append("\n");
		}

		System.out.println(sb);
	}

	static int sum;
	static int sum2;

	public static void comb(int idx, int sidx, int ridx, int r) {

		if (idx == N) {
			sum = 0;
			sum2 = 0;
			// 조합 생성 완료

			for (int i = 0; i < sidx; i++) {
				for (int j = 0; j < sidx; j++) {
					sum += arr[combArr[i]][combArr[j]];
				}
			}
			for (int i = 0; i < ridx; i++) {
				for (int j = 0; j < ridx; j++) {
					sum2 += arr[comb2Arr[i]][comb2Arr[j]];
				}
			}
			min = Math.min(min, Math.abs(sum - sum2));
			return;
		}

		if (sidx < r) {
			combArr[sidx] = idx;
			comb(idx + 1, sidx + 1, ridx, r);
		}

		comb2Arr[ridx] = idx;
		comb(idx + 1, sidx, ridx + 1, r);
	}

}
