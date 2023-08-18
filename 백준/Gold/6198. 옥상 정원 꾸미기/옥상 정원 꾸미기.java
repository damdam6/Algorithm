

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		//빌딩갯수
		int N =Integer.parseInt(bf.readLine());
		
		Stack<Integer> stk = new Stack<>();
		Stack<Integer> idx = new Stack<>();
		
		int tmp;
		int cnt =0;
		int idxN=1;
		long sum =0;
		for(int i= 0;i<N;i++) {
			tmp =Integer.parseInt(bf.readLine());
			if(stk.isEmpty()) {
				stk.push(tmp);
				idx.push(idxN++);
			}else if(stk.peek() > tmp) {
				stk.push(tmp);
				idx.push(idxN++);
			}else {
				//크거나 같을때
				//스택이 비지 않았으면서 top이 작거나같을때
				while(!stk.isEmpty()&&stk.peek()<=tmp) {
					stk.pop();
					//인덱스끼리 차 -1
					sum+=(idxN-idx.pop())-1;
				}
				
				//top이 커지거나, 스택이 비었을때
				stk.push(tmp);
				idx.push(idxN++);
			}
			

		}
		
		while(!stk.isEmpty()) {
			sum+= idxN-idx.pop()-1;
			stk.pop();
		}

		System.out.println(sum);
		
		
	}

}
