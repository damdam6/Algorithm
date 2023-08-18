
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();		
		Scanner sc = new Scanner(System.in);		

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int mul = A*B*C;
		
		
		int[] cnt = new int[10];
		int check;
		do {		
			cnt[mul%10]++;
			mul = mul/10;			
		}while(mul!=0);
		
		for(int k:cnt) {
			sb.append(k+"\n");
		}
		
		System.out.println(sb.toString());
	}

}


