import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i]=sc.nextInt();
		}
		
		int k = sc.nextInt();
		
		int count = 0;
		for(int a: arr) {
			if(a==k) {
				count +=1;
			}
		}
		System.out.println(count);
	}

}