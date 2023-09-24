

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {

		//System.setIn(new FileInputStream("res/sample_input.txt"));
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {

			// NxM 판 RxC 시작점 L 시간

			// bfs로 풀며되는거 아님?

			st = new StringTokenizer(bf.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			tile[][] brd = new tile[N][M];
			int[][] vt = new int[N][M];

			int[] start = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
			int stage = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < M; j++) {
					brd[i][j] = new tile(Integer.parseInt(st.nextToken()));
				}
			}

			int[] dx = new int[] { 1, -1, 0, 0 };
			int[] dy = new int[] { 0, 0, 1, -1 };

			int cnt = 0;
			Deque<node> dqu = new ArrayDeque<>();

			dqu.offer(new node(start[0], start[1], 1));
			vt[start[0]][start[1]] = -1; // 이미 방문함

			while (!dqu.isEmpty()) {
				//System.out.println(dqu.toString());

				node tmp = dqu.poll();

				if (tmp.stage > stage) {
					break;
				}

				cnt++;

				for (int i = 0; i < 4; i++) {
					// 타일이 가는 방향 아님 -> 생략
					if (brd[tmp.x][tmp.y].dir[i] == 0)
						continue;

					int nx = tmp.x + dx[i];
					int ny = tmp.y + dy[i];

					// 다음이 보드 범위 밖이면 -> 안함
					// 다음이 이미 방문한 곳이면 -> 안함
					if (nx < 0 || nx >= N || ny < 0 || ny >= M || vt[nx][ny] == -1)
						continue;

					if ((i == 0 && brd[nx][ny].dir[1] == 1) || (i == 1 && brd[nx][ny].dir[0] == 1)
							|| (i == 2 && brd[nx][ny].dir[3] == 1) || (i == 3 && brd[nx][ny].dir[2] == 1)) {
						dqu.offer(new node(nx, ny, tmp));
						vt[nx][ny] = -1;
					}

				}

			}
			sb.append("#"+tc+" "+cnt).append("\n");
		}
		System.out.println(sb);
	}

	static class tile {
		int[] dir = new int[4];

		tile(int n) {
			switch (n) {

			case (1):
				dir[0] = 1;
				dir[1] = 1;
				dir[2] = 1;
				dir[3] = 1;
				break;
			case (2):
				dir[0] = 1;
				dir[1] = 1;
				break;
			case (3):
				dir[2] = 1;
				dir[3] = 1;
				break;
			case (4):
				dir[1] = 1;
				dir[2] = 1;
				break;
			case (5):
				dir[0] = 1;
				dir[2] = 1;
				break;
			case (6):
				dir[3] = 1;
				dir[0] = 1;
				break;
			case (7):
				dir[1] = 1;
				dir[3] = 1;
				break;
			}
		}

	}

	static class node {

		int x, y;
		int stage;

		node(int x, int y, node node) {
			this.x = x;
			this.y = y;
			this.stage = node.stage + 1;
		}

		node(int x, int y, int stage) {
			this.x = x;
			this.y = y;
			this.stage = stage;

		}

		public String toString() {

			return "x: " + this.x + " y: " + this.y + " stage: " + this.stage + "\n";
		}

	}

}
