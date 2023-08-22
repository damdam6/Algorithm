import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		
		int cnt = N;
allfor:		for(int i=0;i<N;i++) {
			Stack<Character> stk = new Stack<>();
			//어레이에 넣기
			char[] str = bf.readLine().toCharArray();
			
			//홀수인 경우 불가
			if(str.length%2==1) {
				cnt--;
				continue;
			}
			
			for(char c:  str) {
				
				if(stk.isEmpty() || c!=stk.peek()) {
					stk.push(c);
				}else{
					stk.pop();
				}
				
			}
			
			if(!stk.isEmpty()) {
				cnt--;
				continue allfor;
			}
		}
		sb.append(cnt);
		System.out.println(sb);

	}

}
