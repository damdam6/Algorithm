import java.io.FileInputStream;
import java.util.Arrays;
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
		priority.put(')', 9);//필요없는 값contains를 목적으로 할당
		
		
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
			
			//arr부터 체크하면서 후위표기식 Harr로 변경
			for(int i=0; i<N; i++) {
			
				//priority에 안 속해있으면 숫자다.
				if(!priority.containsKey(arr[i])) {
					//후위표기식에 그대로 넣기
					Harr[cnt++]=arr[i];
				}else {
					//연산자일때
					
					//1.스택 공백 체크
					if(stack.isEmpty()) {
						stack.push(arr[i]);
					}else if(priority.get(arr[i]) ==0) {
						//여는 괄호일 경우 -> 스택 밖이므로 일단 스택에push
						stack.push(arr[i]);
						
					}else if(priority.get(arr[i]) ==9) {
						//닫는 괄호일 경우
						
						//여는 괄호 만날때까지 pop
						while(stack.peek() != '(') {
							Harr[cnt++]=stack.pop();
						}
						stack.pop(); //여는 괄호 날려주기
					}
					else{
						//2. 스택 공백 아닐때
						
						//우선순위가 낮은게 나올때까지 while로 pop하여 Harr에 할당
						while((!stack.isEmpty()) &&priority.get(stack.peek()) >=priority.get(arr[i])) {
							Harr[cnt++]=stack.pop();
						}
						//종료 후 push
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
			int i =0;
			//Harr에 담긴 연산진행하기
			
			//cnt 이전인덱스까지 진행하기
			while(cnt>i) {
				
				
				//연산자가 아니라면
				if(!priority.containsKey(Harr[i])) {
					stackInt.push(Harr[i]-'0');
				}else {		
					
					//이번 문제는 +와 *만
					
					if(Harr[i]=='+') {
						stackInt.push(sum(stackInt.pop(),stackInt.pop()));
	
					}else if(Harr[i]=='*') {
						stackInt.push(mul(stackInt.pop(),stackInt.pop()));
					}
					
				}
				
				i++;
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
	
	
}
