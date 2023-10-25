import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int K;
	static int W;
	static int H;
	
	static int[][] bd;
	public static void main(String[] args) throws Exception {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		
		
		K = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		bd = new int[H][W];
		
		for(int i=0;i<H;i++) {
			st = new StringTokenizer(bf.readLine());
			
			for(int j=0; j<W;j++) {
				bd[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(bfs());
	}
	
	static int[] h_dx = new int[] {2, 2, 1, 1, -1, -1, -2,-2};
	static int[] h_dy = new int[] {1, -1, 2, -2, 2, -2, 1, -1};
	
	static int[] dx = new int[] {1,-1,0,0};
	static int[] dy = new int[] {0,0,1,-1};
	
	
	static int bfs() {
		
		cnt = new monkey[H][W];
		
		for(int i=0;i<H;i++) {
			for(int j=0; j<W;j++) {
			cnt[i][j] = new monkey(Integer.MAX_VALUE,-1);
			}
		}
		
		PriorityQueue<monkey> pqu = new PriorityQueue<>();
		pqu.add(new monkey(0,0,0,0));
		
		monkey tmp;
		int nx;
		int ny;
		while(!pqu.isEmpty()) {
			
			tmp = pqu.poll();
			
			if(tmp.x==H-1&&tmp.y==W-1) {
				return tmp.mov;
			}
			//평범하게 사방향
			
			for(int i=0;i<4;i++) {
				nx = tmp.x+dx[i];
				ny = tmp.y+dy[i];
				if(!canGoRange(nx,ny, tmp.mov+1, tmp.h_mov))continue;
				pqu.add(new monkey(tmp.mov+1, tmp.h_mov,nx, ny));
			}
			
			if(tmp.h_mov==K)continue;
			
			for(int i=0;i<8;i++) {
				nx = tmp.x+h_dx[i];
				ny = tmp.y+h_dy[i];
				
				if(!canGoRange(nx,ny,tmp.mov+1, tmp.h_mov+1))continue;
				pqu.add(new monkey(tmp.mov+1, tmp.h_mov+1,nx, ny));
			}
			
			
		}
		
		
		
		return -1;
	}

	static monkey cnt[][];
	static boolean canGoRange(int x, int y, int newCnt, int newHCnt) {
		
		if(x<0||y<0||x>=H||y>=W)return false;
		if(bd[x][y] == 1)return false;
		if(cnt[x][y].mov<=newCnt&&cnt[x][y].h_mov<=newHCnt)return false;
		
		cnt[x][y].mov = newCnt;
		cnt[x][y].h_mov = newHCnt;
		return true;
	}
	

	static class monkey implements Comparable<monkey>{

		int mov;
		 int h_mov;
		 int x;
		 int y;
		 
		 public monkey(int mov, int h_mov, int x, int y) {
			this.mov = mov;
			this.h_mov = h_mov;
			this.x = x;
			this.y = y;
		}
		 
		public monkey(int mov, int h_mov) {
			this.mov = mov;
			this.h_mov = h_mov;
		}

		 @Override
		public int compareTo(monkey o) {
			
			 if(this.mov>o.mov) {
				 return 1;
			 }else if(this.mov<o.mov) {
				 return -1;
			 }
			
			return 0;
		}

		@Override
		public String toString() {
			return "monkey [mov=" + mov + ", h_mov=" + h_mov + ", x=" + x + ", y=" + y + "]";
		}

		 
		 
	 }


}

