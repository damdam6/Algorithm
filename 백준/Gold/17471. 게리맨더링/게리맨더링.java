
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] pCnt;
	static int[][] mtx;
	public static void main(String[] args) throws Exception{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		
		//구역 수
		N = Integer.parseInt(bf.readLine());
		
		//구역 별 인구 수 기록
		pCnt = new int[N+1];
		st = new StringTokenizer(bf.readLine());
		for(int i=1;i<N+1;i++) {
			pCnt[i] = Integer.parseInt(st.nextToken());
		}
		
		//System.out.println(Arrays.toString(pCnt));
		mtx = new int[N+1][N+1];

		//인접 행렬
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(bf.readLine());
			int nxt = Integer.parseInt(st.nextToken());
			for(int j=0;j<nxt;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				mtx[i][tmp] = 1;
				mtx[tmp][i] = 1;
			}
		}
		
		min =Integer.MAX_VALUE;
		pick = new int[N+1];
		pick[1] = 1; // 1은 무조건 좌측
		pickMe(2);
		
		if(min == Integer.MAX_VALUE)min =-1;
		System.out.println(min);
		
		
	}
	
	static int[] pick;
	static int min;
	//조합 1~N
	static public void pickMe(int n) {
		
		if(n==N+1) {
			
			int chkCnt =0;
			for(int i=1;i<N+1;i++) {
				if(pick[i]==1)chkCnt++;
			}
			if(chkCnt==N || chkCnt==0)return;
			
			//여기서 bfs체크
			//bfs(1)
			//bfs(0) return sum = 불가능하면 -1
			//System.out.println(Arrays.toString(pick));
			int cnt1 = bfs(1);
			int cnt2 = bfs(0);
			
			if(cnt1==-1||cnt2==-1)return;
			
			min = Math.min(min, Math.abs(cnt1-cnt2));
			
			return;
		}
		
		pickMe(n+1);
		pick[n]=1;
		pickMe(n+1);
		pick[n]=0;
		
	}
	
	static public int bfs(int chk) {
		
		int[] vt = new int[N+1];
		
		int sum = 0;
		Deque<Integer> qu = new ArrayDeque<>();
		
		for(int i=1;i<N+1;i++) {
			if(pick[i]!=chk)continue;
			qu.add(i);
			vt[i]=1;
			break;
		}
		
		int tmp;
		while(!qu.isEmpty()) {	
			tmp = qu.poll();
			sum += pCnt[tmp];
			
			for(int i=1;i<N+1;i++) {
				if(mtx[tmp][i]!=1 || vt[i]==1 || pick[i]!=chk)continue;
				
				qu.add(i);
				vt[i] = 1;
			}
		}
		
		for(int i=1;i<N+1;i++) {
			if(pick[i]==chk&&vt[i]!=1) {
				sum = -1;
				break;
			}
		}
		
		return sum;
	}

}
