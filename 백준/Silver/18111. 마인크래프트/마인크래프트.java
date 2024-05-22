import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] ground;
	static int N;
	static int M;
	static int B;


	public static void main(String[] args) throws Exception{

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		ground = new int[N][M];

		int blockCount = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				ground[i][j] = Integer.parseInt(st.nextToken());
				blockCount += ground[i][j];
			}
		}

		// 가장 높은 위치로 고를 수 있는 땅의 높이

		int nowHeight = (blockCount+B)/(N*M);

		int recordTime = Integer.MAX_VALUE;
		int recordHeight = Integer.MIN_VALUE;


		while(nowHeight >= 0){

			// System.out.println("nowHeight " + nowHeight);
			int time = checkSecond(nowHeight);
			if(time != -1){
				if(recordTime>time){
					recordTime = time;
					recordHeight = nowHeight;
				}
			}
			nowHeight--;
		}


		System.out.println(recordTime+" "+recordHeight);
	}

	static public int checkSecond(int height){

		int stick = 0;
		int take = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if(ground[i][j] > height){
					take += ground[i][j]-height;
				}else if(ground[i][j] < height){
					stick += height - ground[i][j];
				}

			}
		}

		if(stick - (take+B) > 0){
			return -1;
		}
		// System.out.println("stick "+stick);
		// System.out.println("take "+take);
		return stick+take*2;
	}

}
