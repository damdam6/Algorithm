
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int r;
	static int c;
	
	static int al[];
	static char[][] bd;
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		r = Integer.parseInt(st.nextToken()	);
		c = Integer.parseInt(st.nextToken()	);
		
		
		bd = new char[r][c];
		String str;
		for(int i = 0; i<r;i++) {
			str = bf.readLine();
			for(int j=0; j<c;j++) {
				bd[i][j] = str.charAt(j);
			}
		}
		
		al = new int[26];
		
//		for(int i='A';i<'A'+26;i++) {
//			al[i-'A'] = (char) i;
//		}
		max = Integer.MIN_VALUE;
		al[bd[0][0]-'A'] =1;
		dfs(0,0,1);
		

		System.out.println(max);
		
		
	}
	
	static int max;
	
	static int[] dx = new int[] {0,0,1,-1};
	static int[] dy = new int[] {1,-1,0,0};
	
	public static void dfs(int x, int y, int depth) {
		
		if(depth>max) {
			max = depth;
		}
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0||nx>=r||ny<0||ny>=c|| al[bd[nx][ny]-'A']==1)continue;
			
			al[bd[nx][ny]-'A'] = 1;
			dfs(nx, ny, depth+1);
			al[bd[nx][ny]-'A'] = 0;
		}
		
		
	}

}
