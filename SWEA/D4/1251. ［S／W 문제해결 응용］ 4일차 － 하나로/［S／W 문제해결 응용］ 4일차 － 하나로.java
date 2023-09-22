import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int pos[][];
	static double E;
	
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/re_sample_input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		StringTokenizer st2;
		for(int tc=1; tc<=T;tc++) {
			
			N = Integer.parseInt(bf.readLine());
			pos = new int[N][N];
			edList = new Edge[N*(N-1)/2];

			st = new StringTokenizer(bf.readLine());
			st2 = new StringTokenizer(bf.readLine());

			for(int i=0;i<N;i++) {				
				pos[i][0] = Integer.parseInt(st.nextToken());
				pos[i][1] = Integer.parseInt(st2.nextToken());
	
			}
			E = Double.parseDouble(bf.readLine());
			//System.out.println(E);
			
			
			//일단 전부 각자 그래프
			make();
			int idx=0;
			for(int i =0; i<N;i++) {
				for(int j=i+1;j<N;j++) {
					double x =pos[i][0]-pos[j][0];
					double y =pos[i][1]-pos[j][1];
					double w = Math.pow(x, 2)+Math.pow(y, 2);
					edList[idx++] = new Edge(i,j,w);
				}
			}
			
			
			Arrays.sort(edList);
			
			double result = 0;
			int count = 0;
			for(Edge e : edList) {
				if(union(e.from, e.to)) {
					result += e.weight;
					if(++count == N-1)break;
				}
			}
			
			sb.append("#"+tc+" "+Math.round(result*E)).append("\n");
			
		}
		System.out.println(sb);
		
	}
	
	static class Edge implements Comparable<Edge>{
		int from, to;
		double weight;
		
		public Edge(int from, int to, double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}
	}
	
	static Edge[] edList;

	static int[] p;
	
	static void make() {
		p = new int[N];
		for(int i=0; i<N;i++) {
			p[i] = i;
		}
	}
	
	static int find(int a) {
		if(p[a] == a)return a;
		
		return p[a] = find(p[a]);
	}
	
	static boolean union(int a, int b) {
		int aR = find(a);
		int bR = find(b);
		
		if(aR==bR)return false;
		
		p[bR] = aR;
		return true;
	}

}
