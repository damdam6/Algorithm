import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		
		//뽑으려고 하는 갯수
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(bf.readLine()," ");
		int[] pick = new int[M];
		
		for(int i=0;i<M;i++) pick[i]=Integer.parseInt(st.nextToken());
		
		
		//덱에 순서대로 집어넣기
		LinkedList<Integer> qu = new LinkedList<>();
		
		int cnt=1;
		while(qu.size()<N) {
			qu.add(cnt++);

		}
		
		//가장 앞의 인덱스
		cnt = 0;
		//가장 뒤의 인덱스
		for(int k: pick) {
			//k 값을 뽑아내야됨
			if(qu.indexOf(k)>(qu.size()/2)){
				while(qu.peekFirst()!=k) {
					qu.addFirst(qu.pollLast());
					cnt++;
					

				}
				qu.pollFirst();
			}else {
				while(qu.peekFirst()!=k) {
					qu.addLast(qu.pollFirst());
					cnt++;
					

				}
				qu.pollFirst();
			}

		
		}

		System.out.println(cnt);
	}
}
