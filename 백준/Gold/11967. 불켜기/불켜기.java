import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static Room[][] roomBd;

	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		roomBd = new Room[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				roomBd[i][j] = new Room();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int xTarget = Integer.parseInt(st.nextToken())-1;
			int yTarget = Integer.parseInt(st.nextToken())-1;
			roomBd[x][y].btn.add(new pos(xTarget, yTarget));
		}

		int[][] vt = new int[N][N];

		int lightOnCnt = 1;

		ArrayDeque<pos> qu = new ArrayDeque<>();
		qu.add(new pos(0,0));
		roomBd[0][0].onOff = 1;

		for(pos p:roomBd[0][0].btn){
			if(roomBd[p.x][p.y].onOff==1)continue;
			roomBd[p.x][p.y].onOff = 1;
			vt = new int[N][N];
			lightOnCnt++;
		}
		vt[0][0] = 1;

		while (!qu.isEmpty()){
			pos temp = qu.poll();
			// drawRoom();

			for (int i = 0; i < 4; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				if(nx < 0 || ny <0 || nx >= N || ny >= N)continue;
				// if(roomBd[nx][ny].vt ==1)continue;
				if(vt[nx][ny] ==1)continue;
				if(roomBd[nx][ny].onOff == 0)continue;
				for(pos p:roomBd[nx][ny].btn){
					if(roomBd[p.x][p.y].onOff==1)continue;
					roomBd[p.x][p.y].onOff = 1;
					vt=new int[N][N];
					lightOnCnt++;
				}
				vt[nx][ny] = 1;
				qu.add(new pos(nx,ny));
			}

		}
		System.out.println(lightOnCnt);


	}
	static int[] dy = new int[]{-1,1,0,0};
	static int[] dx = new int[]{0,0,1,-1};

	static public void drawRoom() {
		System.out.println("----------");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(roomBd[i][j].onOff+" ");
			}
			System.out.println();
		}
		System.out.println("---------------");
	}

	static public class Room {
		int onOff;
		List<pos> btn;
		int vt;

		public Room(int onOff, List<pos> btn) {
			this.onOff = onOff;
			this.btn = btn;
		}
		public Room(){
			this.onOff = 0;
			this.vt = 0;
			this.btn = new ArrayList<>();
		}

		@Override
		public String toString() {
			return "Room{" +
				"onOff=" + onOff +
				", btn=" + btn +
				", vt=" + vt +
				'}';
		}
	}

	static public class pos{
		int x;
		int y;

		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}


}
