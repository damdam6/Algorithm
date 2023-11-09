

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int time;
	static int chargeCnt;
	static charge[][] bd;

	static pos[] routeA;
	static pos[] routeB;
	
	static Port[] charE;
	public static void main(String args[]) throws Exception {

		StringBuilder sb = new StringBuilder();
		//System.setIn(new FileInputStream("res/sample_input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringTokenizer st2;
		int T;
		T = Integer.parseInt(bf.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(bf.readLine());
			time = Integer.parseInt(st.nextToken());
			chargeCnt = Integer.parseInt(st.nextToken());
			charE = new Port[chargeCnt];
			bd = new charge[10][10];
			routeA = new pos[time+1];
			routeB  = new pos[time+1];
		
			
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					bd[i][j] = new charge(chargeCnt);
				}
			}
			
			//A,B경로 기록
			st = new StringTokenizer(bf.readLine());
			st2 = new StringTokenizer(bf.readLine());
			
			int ax = 0;
			int ay = 0;
			int bx = 9;
			int by = 9;
			int a; 
			int b;
			routeA[0] = new pos(ax, ay);
			routeB[0] = new pos(bx, by);
			for(int i= 1; i< time+1 ;i++) {
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st2.nextToken());
				ax = ax + dx[a];
				ay = ay + dy[a];
				bx = bx + dx[b];
				by = by + dy[b];
				routeA[i] = new pos(ax, ay);
				routeB[i] = new pos(bx, by);
			}
			
			for(int i = 0 ; i<chargeCnt; i++) {
				st = new StringTokenizer(bf.readLine());
				charE[i] = new Port(
						Integer.parseInt(st.nextToken())-1,
						Integer.parseInt(st.nextToken())-1,
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));				
			}
			
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					for(int k = 0 ; k<chargeCnt; k++) {
						int cX = charE[k].p.x;
						int cY = charE[k].p.y;
						if(Math.abs(cX-i)+Math.abs(cY-j) <= charE[k].range) {
							bd[i][j].setCharge(k);
						}
					}
					
				}
			}
			
			
			max = 0;
			sb.append("#"+test_case+" "+comb()+"\n");
			
		}
		System.out.println(sb);

	}
	
	static int max;
	public static int comb() {
		int chk = 0;
		for(int sec = 0; sec < time +1 ; sec++) {
			int sum = 0;
			pos A = routeA[sec];
			pos B = routeB[sec];
			boolean aSum = false;
			int maxForsec = 0;
			for(int i = 0 ; i < chargeCnt ;i++) {

				//해당 charge랑 닿음
				if(bd[A.x][A.y].charArr[i] == 1) {
					sum += charE[i].amount;
					aSum = true;
				}
				
				//여기는 닿음
				for(int j = 0 ; j < chargeCnt ;j++) {
					if(bd[B.x][B.y].charArr[j] == -1 || (i == j && aSum )) {
						maxForsec = Math.max(maxForsec, sum);
						continue;
					}
					sum += charE[j].amount;
					maxForsec = Math.max(maxForsec, sum);
					sum -= charE[j].amount;
				}
				if(aSum) {
					sum -= charE[i].amount;
					aSum = false;
				}
				
			}
			chk += maxForsec;
		}
		return chk;

	}
	
	static int[] dx = new int[] {0, -1, 0, 1, 0};
	static int[] dy = new int[] {0, 0, 1, 0, -1};
	
	static class Port{
		int amount;
		pos p;
		int range;
		Port( int y, int x, int range, int amount){
			this.amount = amount;
			this.range = range;
			this.p = new pos(x, y);
		}
	}
	static class pos{
		int x;
		int y;
		pos(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + "]";
		}
		
	}
	static class charge{
		int[] charArr;
		
		charge(int num){
			charArr = new int[num];
			Arrays.fill(charArr, -1);
		}
		
		void setCharge(int idx) {
			charArr[idx] = 1;
		}
		
		public String toString() {
			String str = "";
			for(int i=0;i <charArr.length;i++) {
				if(charArr[i] == 1)str+=i+"";
			}
			if(str.equals(""))str = "x";
			return str;
		}
	}
}