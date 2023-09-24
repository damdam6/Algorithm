

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		int T = 10;
		//System.setIn(new FileInputStream("res/sample_input.txt"));
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			int[][] mtx = new int[V + 1][V + 1];
			st = new StringTokenizer(bf.readLine());

			// 간선 받는 곳
			for (int i = 0; i < E; i++) {
				mtx[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}

			// 해당 정점에 들어가는 놈이 몇개인지 넣어두기
			int[] inCnt = new int[V + 1];

			int cnt;
			for (int j = 1; j < V + 1; j++) {
				cnt = 0;
				for (int i = 1; i < V + 1; i++) {
					if (mtx[i][j] == 1)
						cnt++;
				}
				inCnt[j] = cnt;
			}

			sb.append("#" + tc);

			// bfs

			Deque<Integer> dqu = new ArrayDeque<>();

			for (int i = 1; i < V + 1; i++) {
				if (inCnt[i] != 0 || inCnt[i] == -1)
					continue;

				dqu.offer(i);
				inCnt[i] = -1;
			}

			while (!dqu.isEmpty()) {

				int tmp = dqu.poll();

				for (int j = 1; j < V + 1; j++) {

					if (mtx[tmp][j] == 1) {
						inCnt[j]--;
					}

					if (inCnt[j] == 0) {
						dqu.offer(j);
						inCnt[j] = -1;
					}

				}
				sb.append(" " + tmp);

				if (dqu.isEmpty()) {
					for (int i = 1; i < V + 1; i++) {
						if (inCnt[i] != 0 || inCnt[i] == -1)
							continue;

						dqu.offer(i);
						inCnt[i] = -1;
					}
				}

			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
