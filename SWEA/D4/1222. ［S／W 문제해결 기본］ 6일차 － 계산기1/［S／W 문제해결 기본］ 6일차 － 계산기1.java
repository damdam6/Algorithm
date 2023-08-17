import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String args[]) throws Exception {

		//System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
		
		
		Map<Character, Integer> priority = new HashMap<>();
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('(', 0); 
		
		
		int T;
		T = 10;

		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			
			int N = sc.nextInt();
			
			Stack<Character> stack = new Stack<>();
			
			String str = sc.next();
			char[] arr = str.toCharArray();
			char[] Harr = new char[N];
			int cnt=0;
			for(int i=0; i<N; i++) {
				//짝수 0부터 -> 숫자
				//홀수 1부터 -> 연산자				
				if(i%2==0) {
					Harr[cnt++]=arr[i];
				}else {
					if(stack.size()==0) {
						stack.push(arr[i]);
					}else{						
						while(stack.size()!=0 &&priority.get(stack.peek()) >=priority.get(arr[i])) {
							Harr[cnt++]=stack.pop();
						}
						stack.push(arr[i]);
					}
				}
			}
			
			//스택에 남은 연산자 담아주기
			while(!stack.isEmpty()) {
				Harr[cnt++]=stack.pop();
			}
			
			//System.out.println(Arrays.toString(Harr));
			Stack<Integer> stackInt = new Stack<>();
			int ans =0;
			//Harr에 담긴 연산진행하기
			for(int i=0; i<N;i++) {
				
							
				//연산자가 아니라면
				if(!priority.containsKey(Harr[i])) {
					stackInt.push(Harr[i]-'0');
				}else {
					//현재 문제는 연산자가 sum뿐임
					stackInt.push(sum(stackInt.pop(), stackInt.pop()));
					
				}
			}
			sb.append("#"+test_case+" "+stackInt.pop()+"\n");

		}
		System.out.println(sb.toString());
	}
	
	public static Integer sum(Integer a, Integer b) {
		return a+b;
	}

	public static Integer sub(Integer a, Integer b) {
		return a-b;
	}

	public static Integer mul(Integer a, Integer b) {
		return a*b;
	}

	public static Integer div(Integer a, Integer b) {
		return a/b;
	}
	
	
	
	
//	public static Integer sum(char a, char b) {
//		return (a-'0')+(b-'0');
//	}
//	public static Integer  sub(char a, char b) {
//		return (a-'0')-(b-'0');
//	}
//	public static Integer  mul(char a, char b) {
//		return (a-'0')*(b-'0');
//	}
//	public static Integer  div(char a, char b) {
//		return (a-'0')/(b-'0');
//	}
	
}
