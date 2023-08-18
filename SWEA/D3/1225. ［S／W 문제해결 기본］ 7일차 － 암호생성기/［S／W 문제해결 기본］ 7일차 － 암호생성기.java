

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		StringBuilder sb = new StringBuilder();
		//System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;
		int t;
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			t= sc.nextInt();
			
			//큐에 집어넣기
			Queue<Integer> qu = new LinkedList<>();
			for(int i=0; i<8;i++) {
				qu.add(sc.nextInt());
			}
			int check = qu.peek();
			int cnt = 1;
			
			do {

				if(qu.peek() > 0) {
					check = qu.poll()-cnt;
					cnt++;
				}else {
					check =qu.poll();
				}
				
				if(check<0) {
					check = 0;
				}
				
				qu.add(check);
				
				if(cnt>5) {
					cnt=1;
				}
	
			}while(check != 0);
			
			
			sb.append("#"+test_case);
			while(qu.size()>0) {
				sb.append(" "+qu.poll());
			}
			sb.append("\n");

		}
		System.out.println(sb.toString());
	}

}
