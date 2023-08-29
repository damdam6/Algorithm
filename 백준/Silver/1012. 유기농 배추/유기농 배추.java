import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] field;
	
	static int M;
	static int N;
	static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(bf.readLine());
		
		for (int test_case = 0; test_case < T; test_case++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());

			// x -y - 배추갯수
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			
			//필드 입력 받기 -> 배추가 있을 경우 1
			field = new int[M][N];
			
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(bf.readLine());
				field[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			
			int cnt=0;
			for(int i=0;i<M;i++) {
				for(int j =0; j<N;j++) {
					
					if(field[i][j]==1) {
						bfs(i,j);
						cnt++;
					}
					
				}
			}
			
			sb.append(cnt+"\n");
		}
		System.out.println(sb);
	}
	
	static int[] dx = new int[] {1,-1,0,0};
	static int[] dy = new int[] {0,0,1,-1};

	public static void bfs(int x, int y) {		
		Queue<int[]> qu = new ArrayDeque<>();
		int nx;
		int ny;
		//시작점
		qu.add(new int[] {x,y});	
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
				if(nx>=0&&nx<M&&ny>=0&&ny<N&&field[nx][ny]==1) {
					field[nx][ny]=0;
					qu.add(new int[] {nx,ny});
				}
			}
		}
	}
}
