import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(new FileInputStream("res/input.txt"));
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			
			PriorityQueue<Integer> pque = new PriorityQueue<>();
			
			while(pque.size()<N)pque.add(sc.nextInt());
			sb.append("#"+tc);
			while(pque.size()>0)sb.append(" "+pque.poll());
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
}
