
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[][] bd;
	static int N;
	static int M;

	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		bd = new int[N][M];
		
		cnt =0;
		dfs(0,0);
		System.out.println(cnt);

	}
	
	static int cnt;
	static public void dfs(int x, int y) {
		
		if(x == N) {
			cnt++;
			return;
		}
		
		int nx;
		int ny;
		
		if(y == M-1) {
			nx = x+1;
			ny = 0;
		}else {
			nx = x;
			ny = y+1;
		}
		
		//여기에 네모 안그림
		
		
		if(chck(x,y)) {
			bd[x][y] = 1;
			dfs(nx,ny);
		}
		bd[x][y] = 0;
		dfs(nx,ny);
		
	}

	static public boolean chck(int x, int y) {

		if (x >= 1 && y >= 1) {

			if (bd[x - 1][y - 1] == 1 && bd[x][y - 1] == 1 && bd[x - 1][y] == 1) {
				return false;
			}

		}

		if (x >= 1 && y < M - 1) {
			if (bd[x - 1][y + 1] == 1 && bd[x][y + 1] == 1 && bd[x - 1][y] == 1) {
				return false;
			}
		}
		
		if(x < N-1 && y >= 1) {
			if (bd[x + 1][y - 1] == 1 && bd[x][y - 1] == 1 && bd[x + 1][y] == 1) {
				return false;
			}
		}
		
		if (x < N-1 && y < M - 1) {
			if (bd[x + 1][y + 1] == 1 && bd[x][y + 1] == 1 && bd[x + 1][y] == 1) {
				return false;
			}
		}

		return true;
	}
}
