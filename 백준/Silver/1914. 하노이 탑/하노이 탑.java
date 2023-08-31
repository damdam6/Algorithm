

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	static BigInteger cnt;
	static StringBuilder sbr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sbr = new StringBuilder();
		int N = Integer.parseInt(bf.readLine());
		
		cnt = new BigInteger("0");
		
		if(N<=20) {
			Hnoi(N,1,2,3);
			sb.append(cnt);
			System.out.println(sb);
			System.out.println(sbr);
		}else {
			HnoiCnt(N);
			sb.append(cnt);
			System.out.println(sb);
		}
		
	}

	public static void Hnoi(int n, int a, int b, int c) {

		if (n == 1) {
			cnt = cnt.add(new BigInteger("1"));
			sbr.append(a + " " + c+"\n");
			return;
		}

		Hnoi(n - 1, a, c, b);
		cnt = cnt.add(new BigInteger("1"));
		sbr.append(a + " " + c+"\n");
		Hnoi(n - 1, b, a, c);
		

	}
	
	public static void HnoiCnt(int n) {

		//2의 N승 -1 
		
		// int로 수습이 안되므로.. BigInteger로 구현해야됨
		cnt=new BigInteger("2");		
		cnt =cnt.pow(n);
		cnt = cnt.subtract(BigInteger.ONE);

	}

}
