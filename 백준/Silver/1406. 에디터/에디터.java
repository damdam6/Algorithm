

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
		
		char[] str = bf.readLine().toCharArray();
		int M = Integer.parseInt(bf.readLine());
		
		Stack<Character> st1 = new Stack<Character>();
		Stack<Character> st2 = new Stack<Character>();
		
		for(char c:str)st1.add(c);
		
		int curIdx = str.length;
		for(int i=0; i<M;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			
			switch(st.nextToken()) {
			case "L":
				if(curIdx!=0) {
					curIdx--;
					st2.push(st1.pop());
				}
				//System.out.println("case L");
				break;
			
			case "D":
				if(curIdx!=(st1.size()+st2.size())) {
					curIdx++;
					st1.push(st2.pop());
				}
				//System.out.println("case D");
				break;
			case "B":
				if(curIdx!=0) {
					st1.pop();
					curIdx--;
				}
				//System.out.println("case B");
				break;
			
			case "P":
				st1.push(st.nextToken().charAt(0));
				curIdx++;
				//System.out.println("case P");
				break;
			}
			//System.out.println("curIdx " +curIdx);
		}
		while(!st2.isEmpty()) {
			st1.push(st2.pop());
		}
		for(char c:st1)sb.append(c);
		System.out.println(sb);
		
	}

}
