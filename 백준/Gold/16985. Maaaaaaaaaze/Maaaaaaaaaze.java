

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int[][][] bd;
	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 5 * 5

		 bd = new int[5][5][5];
		for (int h = 0; h < 5; h++) {
			for (int i = 0; i < 5; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < 5; j++) {
					bd[h][i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		int IM = Integer.MAX_VALUE;
		min = IM;
		makeMaze(0);
		if(min == IM)min =-1;
		System.out.println(min);
		
		

//		int[][] tmp2 = makeBD(1, 0);
//		
//
//		for(int i=0;i<5;i++) {
//			System.out.println(Arrays.toString(tmp2[i]));
//		}

	}
	
	static boolean[] hvt = new boolean[5];
	static int[][][] maz = new int[5][5][5];
	
	static public void makeMaze(int h) {
		
		if(h==5) {
			bfs();
			//System.out.println("test");
			return;
		}
		
		for(int num =0;num<5;num++) {
			
			if(hvt[num])continue;
			
			hvt[num] = true;
			for(int i=0;i<4;i++) {
				
				maz[h] = makeBD(i, num);
				if(h==0&&maz[h][0][0] == 0)continue; 
				if(h==4&&maz[h][4][4] == 0)continue; 
				makeMaze(h+1);
			}
			hvt[num] = false;

		}
		
	}
	
	static int min;
	
	static int[] dx = new int[] {0,0, -1,1, 0,0};
	static int[] dy = new int[] {0,0, 0,0, -1,1};
	static int[] dh = new int[] {1,-1, 0,0, 0,0};
	static void bfs() {
		if(maz[0][0][0]==0 || maz[4][4][4] ==0)return;
		int[][][] vt = new int[5][5][5];
		
		
		Deque<block> qu = new ArrayDeque<>();
		
		qu.add(new block(0,0,0,0));
		vt[0][0][0] = 1; //방문시 1 아닐시0
		
		block tmp = qu.peek();
		while(!qu.isEmpty()) {
			tmp = qu.poll();
			
			if(tmp.x == 4 && tmp.y ==4 && tmp.h ==4) {
				min = Math.min(min, tmp.cnt);
				break;
			}
			
			for(int i=0;i<6;i++) {
				
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				int nh = tmp.h + dh[i];
				
				if(nx<0 || nx>=5 || ny<0 || ny>=5 || nh<0 || nh>=5 || maz[nx][ny][nh]==0 ||vt[nx][ny][nh]==1)continue;
				qu.add( new block(nx,ny,nh,tmp.cnt+1));
				vt[nx][ny][nh]=1;
				
			}

		}
		
		
	}
	
	static class block{
		int x;
		int y;
		int h;
		int cnt;
		
		block(int x, int y, int h, int cnt) {
			this.x = x;
			this.y = y;
			this.h = h;
			this.cnt = cnt;
		}
		
	}
	
	
	static public int[][] makeBD(int dir, int h){
		int[][] newbd = new int[5][5];
		
		switch(dir) {
		
		case 0:
			newbd = bd[h];
			break;
		case 1:
			for(int i=0;i<5;i++) {
				for(int j=0;j<5;j++) {
					newbd[i][j] = bd[h][4-i][4-j];
				}
			}

			break;
		case 2:
			for(int i=0;i<5;i++) {
				for(int j=0;j<5;j++) {
					newbd[i][j] = bd[h][4-j][i];
				}
			}
			break;
		case 3:
			
			for(int i=0;i<5;i++) {
				for(int j=0;j<5;j++) {
					newbd[i][j] = bd[h][j][4-i];
				}
			}
			break;

		}
		
		
		
		return newbd;
	}

}
