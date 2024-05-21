import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[] dy = {-1, 0, 1};
	static int[][] board;
	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		// 전체 입력 받음
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dpLine = new int[M][3];

		int minInStartLine = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			int minSum = Integer.MAX_VALUE;
			for (int j = 0; j < 3; j++) {
				int beforeM = i + dy[j];
				if (beforeM < 0 | beforeM >= M) {
					dpLine[i][j] = Integer.MAX_VALUE;
					continue;
				}
				dpLine[i][j] = board[1][i] + board[0][beforeM];

				minInStartLine = Math.min(
					minInStartLine,
					dpLine[i][j]
				);
			}
		}

		if(N == 2){
			System.out.println(minInStartLine);
			return;
		}

		// N줄까지 반복하기
		for (int i = 2; i < N; i++) {

			int[][] newDpLine = new int[M][3];
			for(int j=0; j<M;j++){
				for (int k = 0; k < 3; k++) {

					int minSum = Integer.MAX_VALUE;
					if(j+dy[k] <0 | j+dy[k] >=M) {
						newDpLine[j][k] = minSum;
						continue;
					}
					for (int l = 0; l < 3; l++) {
						if(k==l){
							continue;
						}
						minSum = Math.min(
							minSum,
							dpLine[j+dy[k]][l]
						);
					}
					newDpLine[j][k] = minSum + board[i][j];
				}

			}
			// System.out.println("----------------");
			// for (int j = 0; j < M; j++) {
			// 	System.out.println(Arrays.toString(newDpLine[j]));
			// }
			dpLine = newDpLine;

		}

		int minResult =Integer.MAX_VALUE;

		for(int i=0;i<M;i++){
			for (int j = 0; j < 3; j++) {
				minResult = Math.min(
					minResult,
					dpLine[i][j]
				);
			}
		}

		System.out.println(minResult);

	}
}
