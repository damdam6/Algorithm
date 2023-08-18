

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		Deque<Integer> qu = new LinkedList<>();
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			
			st = new StringTokenizer(bf.readLine());
			switch(st.nextToken()) {
			
			case "push":
				qu.add(Integer.parseInt(st.nextToken()));
				break;		
			case "pop":
				if(!qu.isEmpty()) {
					sb.append(qu.poll()+"\n");
				}
				else {
					sb.append("-1\n");
				}
				break;
			case "front":
				if(qu.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(qu.peek()+"\n");
				}
				
				break;
			
			case "back":
				if(qu.isEmpty()) {
					sb.append("-1\n");
				}else {
				sb.append(qu.getLast()+"\n");
				}
				break;
			case "size":
				sb.append(qu.size()+"\n");
				break;
			case "empty":
				if(qu.isEmpty()) {
					sb.append(1+"\n");
				}else {
					sb.append(0+"\n");
				}
				break;
			}
			
			
		}
		
		System.out.println(sb.toString());
	}

}
