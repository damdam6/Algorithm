
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st = new StringTokenizer(bf.readLine());
			
			//마지막 N개만 확인하기
			int N = Integer.parseInt(st.nextToken());
			
			//2진수로 바꿀 숫자
			int  M = Integer.parseInt(st.nextToken());
			
			int tmp = M;

			int cnt = 0;
			//비교할 1111 &연산자용
			boolean check = true;
			do {
				cnt++;
				if(((tmp%2)&1)==0) {
					check = !check;
					break;
				}
				tmp = tmp/2;
			}while(cnt<N);

			sb.append("#").append(test_case);
			
			if(check) {
				sb.append(" ON\n");
			}else {
				sb.append(" OFF\n");
			}
			
			
		}
		System.out.println(sb);
	}

}
