
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class Solution {

	static class Vertex implements Comparable<Vertex> {
		int no;
		double weight;

		// no 노드로 들어오는 간선 중 weigt계산하는 것
		public Vertex(int no, double weight) {
			super();
			this.no = no;
			this.weight = weight;
		}

		public int compareTo(Vertex v) {
			return Double.compare(this.weight, v.weight);
		}
	}

	static int N;
	static double adjMx[][]; // adjMx[a][b] 두 개 연결하는 가중치

	static int pos[][];
	static double E;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/re_sample_input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		StringTokenizer st2;
		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(bf.readLine());
			pos = new int[N][2];

			st = new StringTokenizer(bf.readLine());
			st2 = new StringTokenizer(bf.readLine());
			for (int i = 0; i < N; i++) {
				pos[i][0] = Integer.parseInt(st.nextToken());
				pos[i][1] = Integer.parseInt(st2.nextToken());

			}
			E = Double.parseDouble(bf.readLine());

			boolean[] visited = new boolean[N];
			double[] minEg = new double[N];

			PriorityQueue<Vertex> pqu = new PriorityQueue<>();
			Arrays.fill(minEg, Double.MAX_VALUE);

			minEg[0] = 0;

			pqu.offer(new Vertex(0, minEg[0]));

			double result = 0;
			double min = 0;
			int minVertex = 0;
			int cnt = 0;

			while (!pqu.isEmpty()) {
				Vertex cur = pqu.poll();

				minVertex = cur.no;
				min = cur.weight;

				if (visited[minVertex])
					continue;

				visited[minVertex] = true;
				result += min;
				if (++cnt == N)
					break;

				// 트리에 추가된 새로운 정점 기준으로 기존 정점과 간선비용 고려

				for (int i = 0; i < N; i++) {
					if (visited[i])
						continue;
					double tmp = disP(minVertex, i);
					if (tmp < minEg[i]) {
						minEg[i] = tmp;
						pqu.offer(new Vertex(i, tmp));
					}
				}
			}
			
			sb.append("#"+tc+" "+Math.round(result*E)).append("\n");
		}
		System.out.println(sb);
	}

	public static double disP(int a, int b) {

		return Math.pow(pos[a][0] - pos[b][0], 2) + Math.pow(pos[a][1] - pos[b][1], 2);
	}
}
