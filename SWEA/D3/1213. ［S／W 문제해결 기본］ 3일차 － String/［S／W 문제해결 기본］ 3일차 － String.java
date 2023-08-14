import java.io.FileInputStream;
import java.util.Scanner;

public class Solution{

	public static void main(String args[]) throws Exception {


		//System.setIn(new FileInputStream("res/test_input.txt"));

	
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;
	
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			
			//테스트케이스값 처리
			int k = sc.nextInt();
			//있어야할 문자열
			String check = sc.next();
			//전체 문자열
			String all = sc.next();
			
			int strLen = all.length();
			int checkLen = check.length();
			int cnt = 0;
			
			for(int i=0; i<strLen-checkLen+1;i++) {
				int checkN =0;
				if(all.charAt(i) == check.charAt(0)) {
					for(int j=1; j<checkLen;j++) {
						if(all.charAt(i+j) != check.charAt(j)) {
							break;
						}else {
							checkN++;
						}		
					}					
					if(checkN == checkLen-1) {
						cnt++;
					}
				}
			}
			
			sb.append("#"+test_case+" "+cnt+"\n");
		}
		
		System.out.println(sb.toString());

	}
}