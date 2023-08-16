
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			//입력 받을 갯수
			int K=sc.nextInt();
			//최종인덱스 바로 위 값 == 추가해야되는위치
			int top=0;
			int[] stack=new int[K];
			for(int i=0; i<K;i++) {
				int temp=sc.nextInt();
				if(temp==0) {
					if(top !=0) {
						stack[--top]=0;
					}
				
				}else {
					stack[top++] = temp;
				}
				
				
			}
			
			int sum=0;
			for(int i=0;i<K;i++) {
				sum+=stack[i];
			}
			sb.append("#"+test_case+" "+sum+"\n");
		}
		
		System.out.println(sb.toString());
	}

}
