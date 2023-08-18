
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
	
	static int[] arrN;
	static Map<Character, Integer> pri;
	
	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String str = sc.next();
		
		
		arrN = new int[N];
		for(int i=0;i<N;i++) {
			arrN[i]=sc.nextInt();
		}
		
		char[] arrS = str.toCharArray();
		
		pri = new HashMap<>();
		pri.put('+',1);
		pri.put('-', 2);
		pri.put('*', 3);
		pri.put('/', 4);
		

		double[] stk = new double[100];
		
		
		//'A' 65 아스키
		//숫자가 나오면 - 스택에 넣기
		//연산자가 나오면 - 스택에서 꺼내서 계산
		// 꺼내서 계산할땐 '문자'-65 의 인덱스 값을 arrN에서 찾기
		
		stk[0]=arrN[arrS[0]-65];
		stk[1]=arrN[arrS[1]-65];
		int topIdx = 1;
		for(int i=2;i<arrS.length;i++) {

			if(!pri.containsKey(arrS[i])) {
				//숫자일때!
				//topIdx증가 -> 해당 인덱스에 값 넣기
				stk[++topIdx] = arrN[arrS[i]-65];				
			}else {
				//연산자일 때! -> 두 개가 필요하므로 top 줄이기
				topIdx--;
				//위의 두 개 꺼내서 계산 후 탑에 넣기
				stk[topIdx]=cal(arrS[i],stk[topIdx+1],stk[topIdx]);
			}

		}
		System.out.printf("%.2f",stk[topIdx]);

	}
	
	public static double cal(char c, double a, double b) {
		
		switch(c) {
		case '+':
			return a+b;
		case '-':
			return b-a;
		case '*':
			return a*b;
		case '/':
			return b/a;
		}
		
		return 0;
	}
	

}
