import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[][] maze;
	static boolean[][] visited; // true 방문함
	static int M;
	static int N;


	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		
	
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N=Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze = new char[N][M];
		visited =  new boolean[N][M];
		for(int i=0;i<N;i++) {
			maze[i]=bf.readLine().toCharArray();
		}
		System.out.println(bfs());
		
	}
	static int[] dx = new int[] {1,-1,0,0};
	static int[] dy = new int[] {0,0,1,-1};
	public static int bfs() {		
		
		int x = 0;
		int y = 0;
		int nx;
		int ny;
		
		Queue<int[]> qu = new ArrayDeque<>();
		//시작점
		qu.add(new int[] {x,y,1});	
		visited[x][y] = true;
		int cnt;
		int[] xyArr;
		
		while(!qu.isEmpty()) {
			xyArr=qu.poll();
			cnt = xyArr[2];
			x = xyArr[0];
			y = xyArr[1];
			
			for(int i=0;i<4;i++) {
				nx = x+dx[i];
				ny = y+dy[i];
				if(nx==N-1&&ny==M-1) {					
					return ++cnt;
				}
				if(nx>=0&&nx<N&&ny>=0&&ny<M&&!visited[nx][ny]&&maze[nx][ny]=='1') {
					visited[nx][ny] = true;
					qu.add(new int[] {nx,ny,cnt+1});
				}
			}
		}
		
		return 0;
	}

}
