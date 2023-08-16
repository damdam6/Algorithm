

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		
		//System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);

		int T;
		T=sc.nextInt();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			//F = G*m1*m2/(d*d)
			//자성체와 물체 사이의 거리(d)와 자성체와 물체의 질량(m)
			
			double point; //균형점
			
			int N = sc.nextInt();
			System.out.print("#"+test_case);
			//거리, 질량 인덱스가 
			int[] x = new int[N];
			int[] m = new int[N];
			for(int i =0;i<N;i++) {
				x[i]=sc.nextInt();
			}
			for(int i =0;i<N;i++) {
				m[i]=sc.nextInt();
			}
			double med = 0;
			double fLeft;
			double fRight;
			for(int i=0; i<N-1;i++) {
				
				//f = (g*m)* m/(|(p-d)|^2)
				double start =x[i];
				double end = x[i+1];				
				while(end-start>0.000000000001) {
					 med = (start+end)/2;
					 fLeft=0;
					 fRight=0;
					 //좌
					 for(int j=0;j<=i;j++) {
						fLeft+=m[j]/Math.pow(med-x[j],2);
					 }
						 
					 //우
					 for(int j=i+1;j<N;j++) {
						 fRight+=m[j]/Math.pow(med-x[j],2);
					 }
					 
					 if(fLeft != fRight && fLeft>fRight) {
						 start = med;
					 }else if(fLeft != fRight && fLeft<fRight) {
						 end = med;
					 }else {
						 break;
					 }
					 
				}
				System.out.printf(" %.10f",med);
			}
		System.out.println();
		}
		
	}
	
}
