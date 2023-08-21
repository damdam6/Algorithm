import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt( bf.readLine());
		
		Deque<Integer> dequ = new LinkedList<>();
		String[] tmp;
		

		for(int i=0;i<N;i++) {

			tmp = bf.readLine().split(" ");
			switch(tmp[0]) {
			
			case "push_front":
				dequ.addFirst(Integer.parseInt(tmp[1]));
				break;
			
			case "push_back":
				dequ.addLast(Integer.parseInt(tmp[1]));
				break;
			
			case "pop_front":
				if(dequ.isEmpty()) {
					sb.append(-1+"\n");
					break;
				}else {
					sb.append(dequ.pollFirst()+"\n");
				}
				break;
			
			case "pop_back":
				if(dequ.isEmpty()) {
					sb.append(-1+"\n");
					break;
				}
				else {
					sb.append(dequ.pollLast()+"\n");
				}
				break;
			
			case "size":
				sb.append(dequ.size()+"\n");
				break;
			
			case "empty":
				if(dequ.isEmpty()) {
					sb.append(1+"\n");
				}else {
					sb.append(0+"\n");
				}
				break;
			
			case "front":
				if(dequ.isEmpty()) {
					sb.append(-1+"\n");
					break;
				}
				sb.append(dequ.peekFirst()+"\n");
				break;
			
			case "back":
				if(dequ.isEmpty()) {
					sb.append(-1+"\n");
					break;
				}
				sb.append(dequ.peekLast()+"\n");
				break;
			}
			
		}
		System.out.println(sb);
	}

}
