
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
		
		static int N;
		static int M;
		
		static boolean chk;
		
		static int[][] up;
		public static void main(String[] args) throws Exception{
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			int start =0;
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			ArrayList<edge> edList = new ArrayList<>();
			up = new int[N+1][N+1];
			for(int i=0;i<M+1;i++) {
				st = new StringTokenizer(bf.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int weight = Math.abs(Integer.parseInt(st.nextToken())-1);
				if(a==0||b==0) {
					start = weight;
					continue;
				}
				edList.add(new edge(a, b, weight));
			}
		
			
		chk = true;
		Collections.sort(edList);

		long sumMin = start;
		
		//find 메서드를 목적으로 하는 배열
		p = new int[N+1];
		for(int i=0;i<N+1;i++) {
			p[i] = i;
		}
		
		
		int count = 0;
		for(edge e: edList) {
			
			//합집합 실패하면 
			if(!union(e.a, e.b))continue;
			
			sumMin += e.cost;
			if(++count == N-1)break;

			//System.out.println(Arrays.toString(p));
		}

		
		
		
	chk = false;
	long sumMax = start;
	Collections.sort(edList);

	
	//find 메서드를 목적으로 하는 배열
	p = new int[N+1];
	for(int i=0;i<N+1;i++) {
		p[i] = i;
	}
	
	
	count = 0;
	for(edge e: edList) {
		
		//합집합 실패하면 
		if(!union(e.a, e.b))continue;
		
		sumMax += e.cost;
		if(++count == N-1)break;

		//System.out.println(Arrays.toString(p));
	}
	
	System.out.println((long) (Math.pow(sumMax, 2) - Math.pow(sumMin, 2)));
		
	}
	
	static int[] p;
	
	
	//부모 찾는 것
	static int find(int a) {
		if(p[a]==a) {
			return a;
		}
		return p[a] = find(p[a]);
	}
	
	//합치는 것
	static boolean union(int a, int b) {
		int aR = find(a);
		int bR = find(b);
		
		if(aR==bR) {
			return false;
		}
		
		p[bR] = aR;
		return true;
	}
	
	
	static class edge implements Comparable<edge>{
		int a;
		int b;
		int cost;
		
	public	edge(int a, int  b, int cost){
			
		if(a>b) {
			this.b = a;
			this.a = b;
			
		}else {
			this.a = a;
			this.b = b;
		}
		this.cost = cost;
		
		}

	@Override
	public int compareTo(edge o) {
		
		if(chk) {
			if(this.cost>o.cost) {
				return 1;
			}else if(this.cost<o.cost) {
				return -1;
			}else {
				return 0;
			}
		}else {
			if(this.cost>o.cost) {
				return -1;
			}else if(this.cost<o.cost) {
				return 1;
			}else {
				return 0;
			}
		}
	

		
	}
	
	public String toString() {
		return this.cost+"";
	}
	
	
	}

}
