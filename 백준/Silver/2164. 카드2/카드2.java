import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
		
		int N = Integer.parseInt(br.readLine());		
		Queue<Integer> qu = new LinkedList<>();
		
		int i=1;
		while(i<=N)qu.add(i++);
		
		while(qu.size()!=1) {
			qu.poll();
			qu.add(qu.poll());
		}
		
		System.out.println(qu.poll());
	}

}
