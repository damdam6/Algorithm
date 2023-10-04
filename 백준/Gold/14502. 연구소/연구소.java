

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;

	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		tmpArr = new node[N][M];
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		m = 0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					mkWall(0,i,j);
					arr[i][j] = 0;
				}
				
			}
		}
		
		System.out.println(m);

	}
	
	static int m;
	public static void mkWall(int n, int x, int y) {
		

		if(n==2) {
					
			resetArr();
			m = Math.max(m, vibfs());
			

			return;
		}
		
			
		for(int i=x;i<N;i++) {
			for(int j=0;j<M;j++) {
				
				if(i==x&&j<=y)continue;
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					mkWall(n+1, i, j);
					arr[i][j] = 0;
				}

			}
		}

		
		
	}

	static node[][] tmpArr;
	static int[][] arr;

	// 배열 초기화
	public static void resetArr() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tmpArr[i][j] != null) {
					tmpArr[i][j].vt = false;
					tmpArr[i][j].val = arr[i][j];
				} else {
					tmpArr[i][j] = new node(i, j, arr[i][j]);
				}
			}
		}
	}

	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };

	public static int vibfs() {

		Deque<node> qu = new ArrayDeque<>();

		// 2인 출발점 다 추가
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tmpArr[i][j].val == 2) {
					tmpArr[i][j].vt = true;
					qu.add(tmpArr[i][j]);
				}

			}

		}

		node n;
		while (!qu.isEmpty()) {

			n = qu.poll();
			

			for (int i = 0; i < 4; i++) {
				int nx = n.x + dx[i];
				int ny = n.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M || tmpArr[nx][ny].vt || tmpArr[nx][ny].val == 1)
					continue;
				
				tmpArr[nx][ny].vt = true;
				if (tmpArr[nx][ny].val == 0) {
					tmpArr[nx][ny].val = 2;
					qu.add(tmpArr[nx][ny]);
				}
					
			}

		}
		
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tmpArr[i][j].val == 0) cnt++;
			}

		}
		return cnt;

	}

	static class node {
		int x;
		int y;
		int val;
		boolean vt;

		public node(int x, int y, int val) {
			super();
			this.x = x;
			this.y = y;
			this.val = val;
			this.vt = false;
		}
		
		public String toString() {
			
			return this.val+"";
		}

	}

}
