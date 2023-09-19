

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] chkplan;
	static int[] plan;
	static int day;
	static int month;
	static int month3;
	static int year;
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/sample_input.txt"));

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			day = Integer.parseInt(st.nextToken());
			month = Integer.parseInt(st.nextToken());
			month3 = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(bf.readLine());
			
			
			plan = new int[13];
			for(int i=1;i<=12;i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}

			chkplan = new int[13];
			//일단 자료는 다 받았음
			//일 달 석달 년
			minPay = Integer.MAX_VALUE;
			setPlan(1);
			sb.append("#"+tc+" "+minPay).append("\n");
		}
		System.out.println(sb);
	}
	
	static int minPay;
	// 0, 1, 2, 3 으로 
	public static  void setPlan(int n) {
		if(n==13) {
			//System.out.println(Arrays.toString(chkplan));
			int tmp = sumPay();
			minPay = Math.min(minPay, tmp);	

			return;
		}
		
		//년으로 설정
		if(n==1) {
			for(int i=n;i<13;i++) {
				chkplan[i]=3;
			}
			setPlan(n+12);
		}

		
		if(n+3<=13) {
			//석달치
			for(int i=n;i<n+3;i++) {
				chkplan[i]=2;
			}
			setPlan(n+3);
		}

		
		//한달치
		chkplan[n] = 1;
		setPlan(n+1);
		
		chkplan[n] = 0;
		setPlan(n+1);
		
	}
	
	public static int sumPay() {
		int sum = 0;
		for(int i=1;i<13;i++) {
			if(chkplan[i]==0) {
				sum += plan[i]*day;
			}else if(chkplan[i]==1) {
				sum += month;
			}else if(chkplan[i]==2) {
				sum += month3;
				i = i+2;
			}else {
				sum = year;
			}
		}
		
		return sum;
	}
}
