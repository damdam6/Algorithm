

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		char[] arr = str.toCharArray();
		
		int[] cnt = new int[26];
		//a == 0;
		for(int i=0;i<arr.length;i++) {
			
			cnt[arr[i]-97]++;
		}
		for(int k:cnt) {
			sb.append(k+" ");
		}

		System.out.println(sb.toString());
	}

}
