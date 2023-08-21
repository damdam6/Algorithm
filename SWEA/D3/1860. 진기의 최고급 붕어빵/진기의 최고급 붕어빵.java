
import java.io.FileNotFoundException;

import java.util.PriorityQueue;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(new FileInputStream("res/input.txt"));
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			// N명
			// M초만에 K개 만들 수 있음.
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();

			PriorityQueue<Integer> com = new PriorityQueue<>();

			// 들어오는 사람들
			for (int i = 0; i < N; i++) {
				com.add(sc.nextInt());
			}

			int boongSum=0;
			int idx = 1;
			String po = "Possible";
			while (com.size() > 0&&boongSum>=0) {
				
				//com.peek()초까지 붕어빵이 얼마나 쌓였는지 구하기
				while(idx<=com.peek()) {
					if(idx%M==0) {
						boongSum+=K;
					}
					idx++;
				}
				
				com.poll();
				boongSum--;
				
				if(boongSum<0) {
					 po = "Impossible";
					break;
				}
			}
			sb.append("#"+tc+" "+po+"\n");

		}
		System.out.println(sb);
	}

}
