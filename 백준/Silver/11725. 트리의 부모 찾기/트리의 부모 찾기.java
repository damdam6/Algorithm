
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		//노드 갯수
		int N = Integer.parseInt(bf.readLine());
		
		//간선 갯수
		ArrayList<ArrayList<Integer>> verArr = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<N+1;i++)verArr.add(new ArrayList<>());
		
		StringTokenizer st;
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			verArr.get(a).add(b);
			verArr.get(b).add(a);
		}

		//verArr에 순차대로 있음
		int[] arr = new int[N+1];
		Queue<Integer> qu = new ArrayDeque<>();
		qu.add(1);
		while(!qu.isEmpty()) {			
			//큐에서 값 꺼내기 - 해당 값이 부모 값
			int par = qu.poll();
			for(int a: verArr.get(par)) {
				if(arr[a] ==0) {
					arr[a] = par;
					qu.add(a);
				}
			}

		}

		for(int i=2;i<N+1;i++)sb.append(arr[i]+"\n");
		System.out.println(sb);
	}

}
