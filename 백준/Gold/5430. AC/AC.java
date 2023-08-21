import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int  T = Integer.parseInt(bf.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			
			char[] str = bf.readLine().toCharArray();
			int n = Integer.parseInt(bf.readLine());
			
			LinkedList<Integer> stk = new LinkedList<>();

			StringTokenizer st = new StringTokenizer(bf.readLine());			
			
			for(int i=0;i<n;i++) {
				stk.add(Integer.parseInt(st.nextToken("[],")));
			}
			
			//System.out.println(stk.toString());
			//앞에서부터인지, 뒤에서부터인지 확인
			boolean front = true;
			boolean check = false;
			
allfor:			for(char c : str) {
	
				switch(c) {
				
				case 'R':
					//방향 반전
					front = !front;
					break;
				case 'D':
					if(stk.isEmpty()) {
						check = true;
						break allfor;
					}
					else if(front) {
						stk.pollFirst();
					}else {
						stk.pollLast();
					}
					break;
				}
			}
			
			if(check) {
				sb.append("error\n");
			}
			else if(stk.size()==0) {
				sb.append("[]\n");
			}
			else if(front) {
				int Len = stk.size();
				sb.append("[");
				for(int i=0; i<Len-1;i++) {
					sb.append(stk.pollFirst());
					sb.append(",");
				}
				sb.append(stk.pollLast());
				sb.append("]\n");

			}else {
				sb.append("[");
				int Len = stk.size();
				for(int i=0; i<Len-1;i++) {
					sb.append(stk.pollLast());
					sb.append(",");
				}
				sb.append(stk.pollLast());
				sb.append("]\n");
			}


		}
		
		System.out.println(sb);
		
	}

}
