

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	
	static String[] stArr;
	
	//기호 배열
	static char[] Marr;
	//숫자 배열
	static int[] Narr;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine());
		
		stArr = bf.readLine().split("");
		Narr = new int[N/2+1];
		Marr = new char[N/2+1];
		//strMark = new boolean[N/2];
		
		Marr[0] = '+';
		for(int i=0;i<N;i++) {
			if(i%2==0) {
				//숫자 받는 곳
				Narr[i/2] = Integer.parseInt(stArr[i]); 
			}else {
				//기호(문자) 받는 곳
				Marr[i/2+1] = stArr[i].charAt(0); 
			}
		}

		tryAll(0);
		System.out.println(mx);
	}
	
	static int sum = 0;
	static int mx = Integer.MIN_VALUE;
	public static void tryAll(int idx) {
		//묶어서 수를 먼저 저장하고 -> 해당 스택을 계산해보기?
		//Marr[idx] & Narr[idx] <이렇게 숫자에 계산하기
		//Marr[idx] (Narr[idx]+Marr[idx+1]+Narr[idx+1) <이렇게 묶어서 계산하기
		//
		
		//멈추는 경우 : idx가 Marr-1 일때 (이후 묶을 수 없음 -> 바로 계산)
		//멈추는 경우 : idx가 Marr 일 때 (아무것도 없음 -> 계산이 끝남)
		
		if(idx==Marr.length-1) {
			sum =cal(Narr[idx], sum, Marr[idx]);
			mx = Math.max(sum, mx);
			return;
		}else if(idx>=Marr.length) {
			mx = Math.max(sum, mx);	
			return;
		}

	
		//임시로 이전값 저장
		int tmp = sum;
		//안 묶고 계산하기
		sum = cal(Narr[idx], sum, Marr[idx]);
		tryAll(idx+1);
		
		//계산 안한 상태로 돌리기
		sum = tmp;
		
		//묶은 값 먼저 계산해서 tmpCal에 저장
		int tmpCal = cal(Narr[idx+1], Narr[idx],Marr[idx+1]);
		sum = cal(tmpCal, sum, Marr[idx]);
		tryAll(idx+2);

	}

	
	public static int cal(int b, int a, char c ) {
		switch(c) {
		
		case '*':
			return a*b;
		case '+':
			return a+b;
		case '-':
			return a-b;

		}
		return -1;
	}
}
