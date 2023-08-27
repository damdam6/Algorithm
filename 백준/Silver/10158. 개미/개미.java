

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());


			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int t = Integer.parseInt(bf.readLine());

			// 가능한 범위 0~w / 0~h



			// x 좌표 구하기

			int nx=x;
			int ny = y;

			if (t <= (w - x)) {
				nx = x + t;
			} else if ((t - (w - x) )/ w % 2 == 0) {
				// 짝수면
				
				nx = w - (t - (w - x)) % w;
			} else {
				// 홀수 면
				nx = (t - (w - x)) % w;
			}

			if (t <= (h - y)) {
				ny = y + t;
			} else if ((t - (h - y)) / h % 2 == 0) {
				// 짝수면
				ny = h - (t - (h - y)) % h;
			} else {
				// 홀수 면
				ny = (t - (h - y)) % h;
			}

			sb.append(nx + " " + ny);

			System.out.println(sb);
		}
	

}
