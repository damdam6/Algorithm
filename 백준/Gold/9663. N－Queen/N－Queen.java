


import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int N;

	static ArrayList<Integer> yPicked;
	static ArrayList<Integer> sum;
	static ArrayList<Integer> dif;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();


			N = Integer.parseInt(bf.readLine());
			yPicked = new ArrayList<>();
			sum = new ArrayList<>();
			dif = new ArrayList<>();
			//System.out.println("N" + N);

			chk = 0;
			for(int i=0;i<N;i++) {
				backT(0, i);
			}
			
			sb.append(chk);

		
		System.out.println(sb);

	}

	static int chk = 0;

	public static void backT(int x, int y) {
		if (x == N) {
			return;
		}
		
		// 조건 안되면 컷
		if (yPicked.contains(y) || dif.contains(x - y) || sum.contains(x + y)) {
			return;
		}


		if(x==N-1) {
			chk++;
			return;
		}
		int sumInt = x + y;
		int difInt = x - y;
		yPicked.add(y);
		sum.add(sumInt);
		dif.add(difInt);
		for (int i = 0; i < N; i++) {
			backT(x + 1, i);
			
		}


		yPicked.remove(Integer.valueOf(y));
		sum.remove(Integer.valueOf(sumInt));
		dif.remove(Integer.valueOf(difInt));

	}

}

