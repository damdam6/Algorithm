import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int testCase;
	public static void main(String[] args) throws Exception{

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		testCase = Integer.parseInt(bf.readLine());

		sb = new StringBuilder();

		StringTokenizer st;

		// 큐브 그리기
		char[] colors = new char[]{'w','y','r','o','g','b'};

		tempCount = 0;


		for (int i = 0; i < testCase; i++) {
			// color 큐브 초기화
			for (int t = 0; t <6; t++) {
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						cube[t][j][k] = colors[t];
					}
				}
			}
			int count = Integer.parseInt(bf.readLine());
			char[][] work = new char[count][2];

			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < count; j++) {
				String tempString = st.nextToken();
				work[j][0] = tempString.charAt(0);
				work[j][1] = tempString.charAt(1);
			}

			working(count, work);
			// printCube();


		}

		System.out.println(sb);
	}

	static StringBuilder sb;
	static char[] dir = new char[]{'U','D','F', 'B', 'L', 'R'};
	static char[] rotaDir = new char[]{'-', '+'};

	static int[][][] cubeSect = new int[][][]{
		{
			//U
			{2,1,0},{2,1,0}, {2,1,0}, {2,1,0}
		},
		{
			//D
			{6,7,8}, {6,7,8}, {6,7,8},{6,7,8}
		},
		{
			//F
			{6,7,8}, {0,3,6}, {6,7,8}, {8,5,2}
		},
		{
			//B
			{2,1,0}, {0,3,6}, {2,1,0}, {8,5,2}
		},
		{
			//L
			{0,3,6}, {0,3,6},  {8,5,2},  {8,5,2}
		},
		{
			//R
			{8,5,2}, {0,3,6}, {0,3,6}, {8,5,2}

		}
	};

	static int[][] nextSide = new int[][]{
		{3,5,2,4},
		{3,4,2,5},
		{0,5,1,4},
		{0, 4, 1, 5},
		{0,2,1,3},
		{0,3,1,2}
	};

	static char[][][] cube = new char[6][3][3];
	static int tempCount;
	static public void working(int count, char[][] work){

		for (int i = 0; i < count; i++) {
			turnCube(work[i][0], work[i][1]);

		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				sb.append(cube[0][i][j]);
			}
			sb.append("\n");
		}


	}

	static public void turnCube(char dir, char rotDir){
		int dirIdx = -1;
		switch (dir){
			case 'U':
				dirIdx =0;
				break;
			case 'D':
				dirIdx = 1;
				break;
			case 'F':
				dirIdx = 2;
				break;
			case 'B':
				dirIdx = 3;
				break;
			case 'L':
				dirIdx = 4;
				break;
			case 'R':
				dirIdx = 5;
				break;
			default:
				System.out.println("case에서 틀림");
		}

		// 마지막 칸을 땡기기
		char[] tempSave = new char[3];
		for (int i = 0; i < 3; i++) {
			tempSave[i] = cube[nextSide[dirIdx][3]][cubeSect[dirIdx][3][i]/3][cubeSect[dirIdx][3][i]%3];
		}

		switch (rotDir){
			case '+':
				clockwise(dirIdx,tempSave);
				break;
			case '-':
				antiClockwise(dirIdx, tempSave);
				break;
		}

		//  그 화면도 돌리기 해야지!!

		moveMain(dirIdx, rotDir);


	}

	static int[] idxCal = new int[]{0,1,2,5,8,7,6,3};
	static int[] idxCalD = new int[]{0,3,6,7,8,5,2,1};
	static int[] cal = new int[]{2,4,6,2,-2,-4,-6,-2};
	static int[] calD = new int[]{6,4,2,-2,-6,-4,-2,2};

	static public void moveMain(int dirIdx, char rotDir){
		char[][] movedMain = new char[3][3];
		int count = 0;
		int idx =0;
		switch (rotDir){
			case '+':
				while(count < 8){
					idx = idxCal[count];
					// System.out.println("==movedMain");
					// for (int i = 0; i < 3; i++) {
					// 	System.out.println(Arrays.toString(movedMain[i]));;
					// }
					// System.out.println("===아래는 큐브");

					// for (int i = 0; i < 3; i++) {
					// 	System.out.println(Arrays.toString(cube[dirIdx][i]));
					// }
					movedMain[(idx+cal[count])/3][(idx+cal[count])%3] = cube[dirIdx][idx/3][idx%3];
					// idx = idx+calD[count];

					count++;
				}
				break;
			case '-':
				while(count < 8){
					idx = idxCalD[count];
					// System.out.println("==movedMain");
					// for (int i = 0; i < 3; i++) {
					// 	System.out.println(Arrays.toString(movedMain[i]));;
					// }
					// System.out.println("===아래는 큐브");
					//
					// for (int i = 0; i < 3; i++) {
					// 	System.out.println(Arrays.toString(cube[dirIdx][i]));
					// }
					movedMain[(idx+calD[count])/3][(idx+calD[count])%3] = cube[dirIdx][idx/3][idx%3];
					// idx = idx+calD[count];

					count++;
				}
				break;

		}

		movedMain[1][1] = cube[dirIdx][1][1];
		cube[dirIdx] = movedMain;
		// System.out.println("===마지막");
		// for (int i = 0; i < 3; i++) {
		// 	System.out.println(Arrays.toString(movedMain[i]));;
		// }
		// System.out.println("===아래는 큐브");
		//
		// for (int i = 0; i < 3; i++) {
		// 	System.out.println(Arrays.toString(cube[dirIdx][i]));
		// }
	}
	static public void clockwise(int dirIdx, char[] tempSave){
		// 큰것부터 땡겨서 하기
		for (int i = 2; i >= 0; i--) {
			for (int j = 0; j < 3; j++) {
				cube[nextSide[dirIdx][i+1]][cubeSect[dirIdx][i+1][j]/3][cubeSect[dirIdx][i+1][j]%3]
					= cube[nextSide[dirIdx][i]][cubeSect[dirIdx][i][j]/3][cubeSect[dirIdx][i][j]%3];
			}

		}

		for (int j = 0; j < 3; j++) {
			cube[nextSide[dirIdx][0]][cubeSect[dirIdx][0][j]/3][cubeSect[dirIdx][0][j]%3]
				=tempSave[j];
		}
	}
	static public void antiClockwise(int dirIdx, char[] tempSave){
		// 3을 temp에 저장해놨음

		// 0 -> 3으로
		// 1->0
		// 2->1
		// 3->2
		for (int i = 0; i <=2; i++) {
			for (int j = 0; j < 3; j++) {
				cube[nextSide[dirIdx][(i+3)%4]][cubeSect[dirIdx][(i+3)%4][j]/3][cubeSect[dirIdx][(i+3)%4][j]%3]
					= cube[nextSide[dirIdx][i]][cubeSect[dirIdx][i][j]/3][cubeSect[dirIdx][i][j]%3];
			}


		}


		for (int j = 0; j < 3; j++) {
			cube[nextSide[dirIdx][2]][cubeSect[dirIdx][2][j]/3][cubeSect[dirIdx][2][j]%3]
				=tempSave[j];
		}
	}

	static public void printCube() {
		System.out.println(++tempCount);
		System.out.println("print - cube");
		for (int j = 0; j < 6; j++) {
			for (int k = 0; k < 3; k++) {
				System.out.println(Arrays.toString(cube[j][k]));
			}
			System.out.println("---------");
		}
	}
}
