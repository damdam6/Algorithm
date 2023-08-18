import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> qu = new LinkedList<>();
		for(int i=1;i<N+1;i++)qu.add(i);

		sb.append("<");
		while(qu.size()!=0) {		
			for(int i=0;i<K-1;i++) {
				qu.add(qu.poll());
			}
			sb.append(qu.poll());
			if(qu.size()!=0) {
				sb.append(", ");
			}
		}
		sb.append(">");
		
		System.out.println(sb);
	}

}
