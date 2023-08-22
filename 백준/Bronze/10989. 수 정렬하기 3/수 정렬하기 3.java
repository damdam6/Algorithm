

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());

		int[] arr = new  int[10001];
				
		for(int i=0;i<N;i++) {
			arr[Integer.parseInt(bf.readLine())]++;
		}
		
		bf.close();
		StringBuilder sb = new StringBuilder();
		//인덱스가 값 
		for(int i=1;i<arr.length;i++) {
			while(arr[i]>0) {
				sb.append(i).append("\n");
				arr[i]--;
			}
		}
		
		System.out.println(sb);

	}
	
}
