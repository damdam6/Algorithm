

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int n;
	
	public static void main(String[] args) throws Exception{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = Integer.parseInt(bf.readLine());
		
		for(int tc=1; tc<=t;tc++) {
			n = Integer.parseInt(bf.readLine());
			
			st = new StringTokenizer(bf.readLine());
			pos home = new pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			pos market[] = new pos[n];
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(bf.readLine());
				market[i] = new pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			st = new StringTokenizer(bf.readLine());
			pos fest = new pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			
			Deque<pos> qu = new ArrayDeque<>();
			
			qu.add(home);
			
			boolean tf = false;
			pos tmp;
			while(!qu.isEmpty()) {
				
				tmp = qu.poll();
				
				if(Math.abs(fest.x - tmp.x)+ Math.abs(fest.y - tmp.y) <= 1000) {
					tf = true;
					break;
				}
				
				for(int i=0;i<n;i++) {
					pos nx = market[i];
					
					if(nx.vt)continue;
					if(Math.abs(nx.x - tmp.x)+ Math.abs(nx.y - tmp.y) >1000)continue;
					market[i].vt = true;
					qu.add(nx);
				}
				
				
			}
			
			if(tf) {
				sb.append("happy").append("\n");
			}else {
				sb.append("sad").append("\n");
			}
		}

		System.out.println(sb);
	}
	
	
	static class pos{
		int x;
		int y;
		boolean vt;
		pos(int x, int y){
			this.x = x;
			this.y = y;
			this.vt = false;
		}
	}
}
