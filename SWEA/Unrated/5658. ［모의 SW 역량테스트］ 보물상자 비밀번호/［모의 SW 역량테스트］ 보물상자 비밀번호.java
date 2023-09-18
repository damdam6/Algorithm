

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 16진수 숫자 0~9 A B C D E F
		// 시계 방향 회전 -> 숫자 회전
		// 각 변 : 동일 한 개수의 숫자 -> 시계방향으로 높은 자리 숫자

		// 비밀 번호 -> K 번째 큰수를 10진수로 만든 수
		// N개의 숫자를 입력
		// K 번째 의 큰 수 입력

		//System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			// 0, 1, 2회전 마다 숫자를 찾아서 정렬해야 되네

			String[] tmpArr = bf.readLine().split("");
			int[] arr = new int[tmpArr.length];

			for (int i = 0; i < tmpArr.length; i++) {
				switch (tmpArr[i]) {
				case "A":
					arr[i] = 10;
					break;
				case "B":
					arr[i] = 11;
					break;
				case "C":
					arr[i] = 12;
					break;
				case "D":
					arr[i] = 13;
					break;
				case "E":
					arr[i] = 14;
					break;
				case "F":
					arr[i] = 15;
					break;
				default:
					arr[i] = Integer.parseInt(tmpArr[i]);
				}
			}

			// 총 N/4*3개의 케이스가 나옴

			int start;
			int cnt = 0;
			arrsort = new int[(N / 4) * 4];
			// 회전 반복
			for (int i = 0; i < N / 4; i++) {
				start = i;

				// 4번 반복 -> 숫자 1
				for (int k = 0; k < 4; k++) {
					int ten = 0;
					for (int j = N/4-1; j >=0; j--) {
						int idx = start + ( N/4-1 - j);
						// 16 진수
						if (idx >= N) {
							idx = idx - N;
						}
						ten += arr[idx] * Math.pow(16, j);
					}
					// arr에 넣어야되네

					sortArr(ten, cnt);
					cnt++;
					start += N / 4;
					
				}

			}
			int chk =1;
			int idx = cnt-1; //맨 뒤에서부터 체크
			while(chk<K) {
				idx--;
				if(arrsort[idx]==arrsort[idx+1]) {
					continue;
				}
				chk++;
			}
			sb.append("#"+test_case+" "+arrsort[idx]).append("\n");

		}
		System.out.println(sb);
	}

	// 정렬 알고리즘

	static int[] arrsort;
	
	static // n 정렬할 숫자, cnt 여태까지의 갯수
	void sortArr(int n, int cnt) {
		if(cnt==0) {
			arrsort[0] = n;
			cnt++;
			return;
		}
		
		for(int i = cnt-1 ;i>=0;i--) {
			if(arrsort[i] >n) {
				arrsort[i+1] = arrsort[i];
				if(i==0)arrsort[0]=n;
			}
			else if(arrsort[i]<=n) {
				arrsort[i+1]=n;
				break;
			}
		}
	}

}
