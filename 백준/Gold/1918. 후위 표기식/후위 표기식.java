

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	
	//1. 숫자면 표시
	//2. 스택에 연산자
	//	- 스택에 없으면 넣기
	// 	- 스택의 peek보다 먼저 계산해야되면 스택에 넣기
	//  - 스택의 peek보다 나중에 계산or동일하게 계산이면 
			// --내가 얘보다 먼저 계산해야되는 연산자가 나올때까지 스택을 꺼내고 push
	// 	- ) 열린괄호까지 다 꺼내!!
	// 	- ( 무조건 집어넣기 / 내부에서는 약함
	
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();		
		char[] arr = str.toCharArray();
		
		Map<Character, Integer> pri = new HashMap<>();
		pri.put('+',1);
		pri.put('-', 1);
		pri.put('*', 2);
		pri.put('/', 2);
		pri.put('(', 0);
		pri.put(')', 9);
		
		Stack<Character> stk = new Stack<>();
		ArrayList<Character> arrL = new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			if(!pri.containsKey(arr[i])) {
				arrL.add(arr[i]);
			}else if(stk.isEmpty() || arr[i]=='(') {
				stk.push(arr[i]);
			}else if(arr[i]==')') {	
				while(stk.peek()!='(') {
					arrL.add(stk.pop());
				}
				stk.pop();
			}else {
				while(!stk.isEmpty() &&pri.get(stk.peek())>=pri.get(arr[i])) {
					arrL.add(stk.pop());
				}
				stk.push(arr[i]);
			}
		}
		while(!stk.isEmpty()) {
			arrL.add(stk.pop());
		}
		
		for(char k:arrL) {
			sb.append(k);
		}
		System.out.println(sb.toString());
	}

}
