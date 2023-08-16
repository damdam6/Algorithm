import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {
	public static void main(String[] args) throws Exception {

		//System.setIn(new FileInputStream("res/sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			String str = sc.next();
			char[] charA = str.toCharArray();

			// 스택
			int top = 0;
			int sum = 0;

			for (int i = 0; i < charA.length; i++) {

				if (i<charA.length-1 && charA[i] == '(' && charA[i+1] == ')') {
					// 바로 여닫는 것일때 -> 레이저
					sum += top;

				} else if(charA[i] == '('){
					//바로 닫는게 아닐때 -> 막대 추가
					sum++;
					top++;

				} else if(charA[i-1] != '(' && charA[i] == ')') {
					// 여는것 이후가 아닌 닫는 것일때 -> 막대 삭제
					top--;

				}

			}

			sb.append("#" + test_case + " " + sum + "\n");
		}
		System.out.println(sb.toString());
	}
}
