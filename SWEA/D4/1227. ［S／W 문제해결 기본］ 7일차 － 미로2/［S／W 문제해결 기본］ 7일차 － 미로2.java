
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
	static char[][] maze;
	static int[][] vt;
	static int[] start;
	static int[] end;

	public static void main(String[] args) throws Exception {

		//System.setIn(new FileInputStream("res/input.txt"));
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			bf.readLine();

			// 100X100
			start = new int[2];
			end = new int[2];
			maze = new char[100][100];
			vt = new int[100][100];
			for (int i = 0; i < 100; i++) {
				String[] tmp = bf.readLine().split("");
				for (int j = 0; j < 100; j++) {
					maze[i][j] = tmp[j].charAt(0);
					if (maze[i][j] == '2') {
						start[0] = i;
						start[1] = j;
					} else if (maze[i][j] == '3') {
						end[0] = i;
						end[1] = j;
					}
				}
			}

			chk = false;

			bfs();

			sb.append("#" + tc + " ");
			if (chk) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static boolean chk;
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, 1, -1 };

	public static void bfs() {

		Deque<int[]> dqu = new ArrayDeque<>();

		dqu.offer(start);
		vt[start[0]][start[1]] = 1;

		allwhile: while (!dqu.isEmpty()) {

			int[] tmp = dqu.poll();

			if (maze[tmp[0]][tmp[1]] == '3') {
				chk = true;
				break allwhile;
			}

			for (int i = 0; i < 4; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];

				if (nx < 100 && ny < 100 && nx >= 0 && ny >= 0 && maze[nx][ny] != '1' && vt[nx][ny] == 0) {
					dqu.offer(new int[] { nx, ny });
					vt[nx][ny] = 1;
				}

			}

		}

	}
}
