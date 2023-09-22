
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	static int N;
	static int mtx[][];

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(bf.readLine());
			mtx = new int[N][N];
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine(), "0|1|2|3|4|5|6|7|8|9", true);

				for (int j = 0; j < N; j++) {
					mtx[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 0,0에서 N-1 , N-1까지
			visited = new int[N][N];
			sb.append("#"+tc+" "+bfs()).append("\n");

		}

		System.out.println(sb);
	}
	
	static int visited[][];
	
	public static int bfs() {
		
		int[] dx = new int[] {0,0,-1,1};
		int[] dy = new int[] {-1,1,0,0};
		
		PriorityQueue<node> pqu = new PriorityQueue<>();
		pqu.offer(new node(0,0,0));
		//방문시 1

		int result =0;
		
all:		while(!pqu.isEmpty()) {
			node tmp = pqu.poll();
			
			//이미 방문했다면
			if(visited[tmp.x][tmp.y]==1)continue;
			visited[tmp.x][tmp.y] = 1;
			
			//방문 안했다면
			
			for(int i=0;i<4;i++) {
				
				int nx = tmp.x+dx[i];
				int ny = tmp.y+dy[i];
				
				if(nx == N-1 && ny == N-1) {
					result = tmp.w;
					break all;
				}
		
				if( nx < 0 || nx >= N || ny <0 ||ny>= N || visited[nx][ny] ==1) continue;
				
				node nxtmp = new node(nx, ny, mtx[nx][ny]+tmp.w);

				pqu.offer(nxtmp);
				
				
			}

			
		}

		//System.out.println(pqu.toString());
		return result;
	}
	
	static class node implements Comparable<node> {
		
		int x;
		int y;
		int w;
		
		public node(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(node o) {
			return Integer.compare(this.w, o.w);
		}
		
		public String toString() {
			return "x : "+this.x+" y : "+this.y+" w : "+w+"\n";
		}
		
		
	}

}
