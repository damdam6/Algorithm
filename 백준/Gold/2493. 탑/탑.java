

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		Stack<Integer> stk = new Stack<>();
		Stack<Integer> idx = new Stack<>();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		

		int cnt = 1;
		stk.push(Integer.parseInt(st.nextToken()));
		idx.push(cnt);
		sb.append("0 ");
		for(int i=0; i<N-1;i++) {
			cnt++;
			//이번 탑의 높이
			int temp = Integer.parseInt(st.nextToken());;

			while(!stk.isEmpty() && stk.peek() < temp) {
				stk.pop();
				idx.pop();
			}

			if(!stk.isEmpty()) {
				sb.append(idx.peek()+" ");
				
			}else {
				sb.append("0 ");
			}
			stk.push(temp);
			idx.push(cnt);
		}

		System.out.println(sb);
		
	}

}
