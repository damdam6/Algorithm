

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
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
			int N = sc.nextInt();
			int M = sc.nextInt();

			// 값의 갯수를 넣을 배열
			int[] arr = new int[N + M + 1];
			for (int n = 1; n <= N ; n++) {
				for(int m=1; m<=M; m++) {
					arr[n+m]++;					
				}
			}
			
			int max =0;
			
			for(int k:arr) {
				max = Math.max(max, k);
			}

			Queue<Integer> qu = new LinkedList<>();
			for(int i=0; i<arr.length;i++) {
				if(arr[i]==max) {
					qu.add(i);
				}
			}
			
			sb.append("#"+test_case);
			while(qu.size()>0) {
				sb.append(" "+qu.poll());
			}
			sb.append("\n");

		}
		System.out.println(sb.toString());
	}

}
