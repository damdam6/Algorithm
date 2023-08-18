

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {

		StringBuilder sb = new StringBuilder();
		//System.setIn(new FileInputStream("res/sample_input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			Queue<String> Q1 = new LinkedList<>();
			Queue<String> Q2 = new LinkedList<>();
			
			int N = sc.nextInt();
			for(int i=0;i<N;i++) {
				if((N%2==0&&i<N/2)|| (N%2!=0&&i<=N/2)) {
					Q1.add(sc.next());
				}else {
					Q2.add(sc.next());
				}
			}
			sb.append("#"+test_case);
			
			while(Q1.size()>0) {
				sb.append(" "+Q1.poll());
				if(Q2.size()!= 0) {
					sb.append(" "+Q2.poll());
				}
			}
			sb.append("\n");

			
		}

		System.out.println(sb.toString());
	}

}
