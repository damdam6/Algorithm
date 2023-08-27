
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution{

	static class Tree {

		int[] arrTree;
		int endIdx;

		// Tree클래스
		Tree(int N) {
			arrTree = new int[N + 1];
			endIdx = 0;
		}

		public void addTree(int a) {
			arrTree[++endIdx] = a;
			toUP(endIdx);
		}

		public int rmtop() {

			if (endIdx == 0) {
				return -1;
			}
			int top = arrTree[1];
			if (endIdx == 1) {
				endIdx--;
				return top;
			}
			
			arrTree[1]=arrTree[endIdx--];


			toDown(1);

			return top;
		}

		// 위에서 아래로 정렬
		public void toDown(int parIdx) {
			// 현재 배열 arrTree;			
			//우 자식이 더 클때
			if (parIdx * 2 + 1 <=endIdx && arrTree[parIdx * 2] < arrTree[parIdx * 2 + 1]) {
              if (arrTree[parIdx * 2+1] > arrTree[parIdx]) {
				int tmp = arrTree[parIdx];
				arrTree[parIdx] = arrTree[parIdx * 2 + 1];
				arrTree[parIdx * 2 + 1] = tmp;
				toDown(parIdx * 2+1);
				
              }
              
			}else if(parIdx * 2 <= endIdx) {
				//좌 자식이 있음에서
				//우 자식이 없거나 or 좌 자식이 더 클 때
				if (arrTree[parIdx * 2] > arrTree[parIdx]) {
					int tmp = arrTree[parIdx];
					arrTree[parIdx] = arrTree[parIdx * 2];
					arrTree[parIdx * 2] = tmp;
					toDown(parIdx * 2);
				}
				
			} else {
				
				//자식 없음
				return;
			}

		}

		// 아래에서 위로 정렬

		public void toUP(int chIdx) {

			if (chIdx / 2 <= 0) {
				return;
			}
			// 현재 배열 arrTree;
			if (arrTree[chIdx] > arrTree[chIdx / 2]) {
				int tmp = arrTree[chIdx];
				arrTree[chIdx] = arrTree[chIdx / 2];
				arrTree[chIdx / 2] = tmp;
				toUP(chIdx / 2);
			}

		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		//System.setIn(new FileInputStream("res/sample_input.txt"));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bf.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {

			sb.append("#" + test_case);
			int N = Integer.parseInt(bf.readLine());
			Tree tr = new Tree(N);
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				int sw = Integer.parseInt(st.nextToken());
				switch (sw) {
				case 1:
					tr.addTree(Integer.parseInt(st.nextToken()));
					break;
				case 2:
					sb.append(" "+tr.rmtop());
					break;
				}

			}

			sb.append("\n");
		}
		System.out.println(sb);
	}

}

