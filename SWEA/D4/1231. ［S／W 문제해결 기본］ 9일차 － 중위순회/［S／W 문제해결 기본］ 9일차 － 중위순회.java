
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static String[][] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			//N개의 정점
			N = Integer.parseInt(bf.readLine());

			arr = new String[N+1][4];
			for(int i=1;i<N+1;i++) {
				String str = bf.readLine();
				arr[i] =str.split(" ");
			}
			//배열 탐색하기
			
			sb.append("#"+test_case+" ");
			dfsByInOrder(1);
			sb.append("\n");

		}
		System.out.println(sb);
	}
	
	
	public static void dfsByInOrder(int current) {
		//현재 노드를 중위순회로 탐색
		
		//자식부터 탐색
		if(current*2<=N)dfsByInOrder(current*2);
		sb.append(arr[current][1]);
		//현재 탐색대상을 통해 탐색해야할 새로운 대상을 재귀호출로 탐색시키기
		
		if(current*2+1<=N)dfsByInOrder(current*2+1);
	}
}
