import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] pic;
	static boolean[][] visited; //true 방문함
	static  int n;
	static int m;
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		pic = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; j++) {
				pic[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = 0;
		int picCnt =0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
			if(pic[i][j]==1&&!visited[i][j]) {
				picCnt++;
				max = Math.max(bfs(i,j), max);
			}
			}
		}
		
		sb.append(picCnt+"\n"+max);
		System.out.println(sb);
	}
	
	static int[] dx = new int[] {1,-1,0,0};
	static int[] dy = new int[] {0,0,1,-1};

	public static int bfs(int x, int y) {		
		Queue<int[]> qu = new ArrayDeque<>();
		int nx;
		int ny;
		//시작점
		qu.add(new int[] {x,y});	
		visited[x][y] = true;
		int cnt=0;
		int[] xyArr;
		
		while(!qu.isEmpty()) {
			xyArr=qu.poll();
			cnt++;
			x = xyArr[0];
			y = xyArr[1];
			
			for(int i=0;i<4;i++) {
				nx = x+dx[i];
				ny = y+dy[i];
				if(nx>=0&&nx<n&&ny>=0&&ny<m&&!visited[nx][ny]&&pic[nx][ny]==1) {
					visited[nx][ny] = true;
					qu.add(new int[] {nx,ny});
				}
			}
		}
		
		return cnt;
	}

}
