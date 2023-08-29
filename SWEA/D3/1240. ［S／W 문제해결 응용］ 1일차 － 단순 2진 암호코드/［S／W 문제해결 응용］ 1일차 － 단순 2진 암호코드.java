
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {

		//System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(sc.readLine());
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */
		StringBuilder sbAsw = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(sc.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			String code = null;
			String temp;
			char[] tmpArr = null;
			boolean ck = true;
			// 전부 입력 받기
			for (int i = 0; i < N; i++) {
				temp = sc.readLine();
				if (ck && temp.contains("1")) {
					code = temp;
					ck = false;
				}
			}
			tmpArr = code.toCharArray();
			int idx = tmpArr.length - 1;
			while (tmpArr[idx--] != '1')
				;
			// 뒤에서부터 처음으로 1이 나오는 idx
			idx++;

			// 암호파트만 뽑아내기
			int[] arr = new int[56];
			for (int i = 55; i >= 0; i--) {
				arr[i] = tmpArr[idx--] - '0';
			}

			// 돌때마다 7개 숫자의 값 담는 곳
			int codeint = 0;

			// cnt = arr 순환용
			int cnt = 0;

			// 최종 sum
			int finSum = 0;
			// 암호여부 체크
			int chkSum = 0;
			// 암호숫자
			int tmpCode = 0;

			for (int c = 0; c < 8; c++) {
				codeint = 0;

				for (int j = 6; j >= 0; j--) {
					codeint += arr[cnt++] * Math.pow(2, j);
				}

				int com = 1;

				// 1을 세고 있을때는 true
				boolean pp = false;
				int tmpcnt = 0;

				int sum = 0;
				// 가장 많이 미룰 때부터 카운트
				for (int i = 6; i >= 0; i--) {

					// (codeint>>i)&1 가장 끝자리 수가 1일 때만 1 반환
					if (((codeint >> i) & 1) == 1) {
						// 끝자리가 1이라면

						// 이전에 1을 세고 있었으면 true
						if (pp) {
							// 연속된 숫자를 늘려준다.
							tmpcnt++;
						} else {
							// 이전에 0을 세고 있었으면 false
							pp = !pp;

							sum = sum * 10 + tmpcnt;
							tmpcnt = 1;

						}

					} else {
						// 끝자리가 0이라면

						// 이전에 0을 세고 있었으면
						if (!pp) {
							// 연속된 숫자를 늘려준다.
							tmpcnt++;
						} else {
							// 이전에 0을 세고 있었으면 false
							pp = !pp;
							sum = sum * 10 + tmpcnt;
							tmpcnt = 1;
						}
					}

				}

				switch (sum) {
				case 321:

					tmpCode = 0;
					break;
				case 222:

					tmpCode = 1;
					break;
				case 212:

					tmpCode = 2;
					break;
				case 141:

					tmpCode = 3;
					break;
				case 113:

					tmpCode = 4;
					break;
				case 123:

					tmpCode = 5;
					break;
				case 111:

					tmpCode = 6;
					break;
				case 131:

					tmpCode = 7;
					break;
				case 121:

					tmpCode = 8;
					break;
				case 311:

					tmpCode = 9;
					break;
				default:
					System.out.println("오류남");

				}

				// 암호문의 짝홀수번째 체크
				if (c % 2 == 0) {
					chkSum += tmpCode * 3;
				} else {
					chkSum += tmpCode;
				}

				// 최종합 저장
				finSum += tmpCode;

			}

			// 프린트
			sbAsw.append("#" + test_case + " ");
			if (chkSum % 10 == 0) {
				sbAsw.append(finSum);
			} else {
				sbAsw.append(0);
			}
			sbAsw.append("\n");

		}

		System.out.println(sbAsw.toString());

	}
}
