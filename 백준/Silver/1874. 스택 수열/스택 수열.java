
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		Stack<Integer> stk = new Stack<>();
		
		int[] arr = new int[N];
		for(int i=0; i<N;i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		//어레이에 나와야하는 숫자 집어넣음.
		
		int cnt = 1;//집어넣을 때마다 ++

allwhile:		while(cnt<=N) {
			
			for(int i=0;i<N;i++) {
				if(stk.isEmpty()||arr[i]>stk.peek()) {
					if(cnt>arr[i]) {
						sb = new StringBuilder("NO");
						break allwhile;
					}else {
						while(stk.isEmpty()||stk.peek()!=arr[i]) {
							stk.add(cnt++);
							sb.append("+\n");
						}
						stk.pop();
						sb.append("-\n");
					}
				}else if(arr[i]==stk.peek()) {
					stk.pop();
					sb.append("-\n");
				}else {
					sb = new StringBuilder("NO");
					break allwhile;
				}
			}
		}
		System.out.println(sb);
		
	}

}
