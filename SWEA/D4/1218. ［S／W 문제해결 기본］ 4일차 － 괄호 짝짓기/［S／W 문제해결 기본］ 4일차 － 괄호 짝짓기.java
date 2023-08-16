import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T;
		T=10;
		

		for(int test_case = 1; test_case <= T; test_case++)
		{

			//입력 받을 괄호의 갯수
			int K=sc.nextInt();
			//string도 무조건 받아주는 케이스를 짜야됨
			String str = sc.next();	
			int check=1;
			if(K%2!=0) {
				check=0;
				
			}
			else {
				
				char[] charA = str.toCharArray();
				
				//스택
				int top=-1;
				
				char[] stackF = new char[charA.length/2];
				
				for(int i=0;i<charA.length;i++) {
					//여는 것인가 ? or 닫는 것인가?

					if(charA[i]=='(' ||charA[i]=='{'||charA[i]=='['||charA[i]=='<') {
						
						//스택에 쌓을 것임
						//스택이 full인지 체크부터
						if(top==stackF.length-1) {
							//full 더 쌓을 수 없음 - 쌍 오류
							check=0;
						}else {
							//스택에 여는 괄호 넣어주기
							stackF[++top]=charA[i];
						}
						
					}else {
						
						//스택에 아무것도 없으면 아웃
						if(top<0) {
							check =0;
							break;
						}else if((stackF[top]=='('&&charA[i]==')') ||(stackF[top]=='{'&&charA[i]=='}')||(stackF[top]=='['&&charA[i]==']')||(stackF[top]=='<'&&charA[i]=='>')) {
							//스택top이 동일한 값이라면 훌륭! = 통과
							//top에서 해당 값 제거
							stackF[top--]='0';
							continue;
						}else {
							
							//동일한 값이 아니라면
							check =0;
							break;
						}
	
					}
						
					}
					
					
				

			}
			sb.append("#"+test_case+" "+check+"\n");

		}
		
		System.out.println(sb.toString());
	}

}
