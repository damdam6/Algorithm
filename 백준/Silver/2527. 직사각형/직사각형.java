

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 4;
		
		for(int tc=1; tc<=T;tc++) {
			
			
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			int ax = Integer.parseInt(st.nextToken());
			int ay = Integer.parseInt(st.nextToken());
			int ax2 = Integer.parseInt(st.nextToken());
			int ay2 = Integer.parseInt(st.nextToken());
			
			int bx = Integer.parseInt(st.nextToken());
			int by = Integer.parseInt(st.nextToken());
			int bx2 = Integer.parseInt(st.nextToken());
			int by2 = Integer.parseInt(st.nextToken());
			if (ax2 < bx || ay2 < by || bx2 < ax || by2 < ay) {
			
				sb.append("d\n");
			}
			else if ((ax== bx2 && ay == by2) || (ax == bx2 && ay2 == by) || (ax2 == bx && ay2 == by) || (ax2 == bx && ay == by2)) {

				sb.append("c\n");
			}
			else if (ax == bx2 || ay == by2|| bx == ax2 || by == ay2){
				sb.append("b\n");
			}
			else {
				sb.append("a\n");
			}


			}
		System.out.println(sb);
			
		
		
	}

}
