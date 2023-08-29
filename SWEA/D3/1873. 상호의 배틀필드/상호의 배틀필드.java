
import java.io.BufferedReader;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Solution {
	static char[][] gboard;
	static int x;
	static int y;
	static char dir;
	static int H;
	static int W;

	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(bf.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			gboard = new char[H][W];
			for (int i = 0; i < H; i++) {
				gboard[i] = bf.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					if (gboard[i][j] == '^') {
						x = i;
						y = j;
						dir = 'u';
					} else if (gboard[i][j] == 'v') {
						x = i;
						y = j;
						dir = 'd';
					} else if (gboard[i][j] == '<') {
						x = i;
						y = j;
						dir = 'l';
					} else if (gboard[i][j] == '>') {
						x = i;
						y = j;
						dir = 'r';
					}
				}
			}


			int N = Integer.parseInt(bf.readLine());
			char[] user = bf.readLine().toCharArray();
			
			for(int i=0;i<N;i++) {
				car(user[i]);
			}
			
			sb.append("#"+test_case+" ");
			
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					sb.append(gboard[i][j]);
				}
				sb.append("\n");
			}

		}
		System.out.println(sb);

	}

	public static void car(char c) {
		switch (c) {

		case 'U':
			// 방향 변경
			dir = 'u';
			
			// 한 칸 위가 평지라면 그 칸으로 이동
			if (x - 1 >= 0 && gboard[x - 1][y] == '.') {
				gboard[x][y] = '.';
				x = x - 1;
			}
			gboard[x][y] = '^';
			break;

		case 'D':
			// 방향 변경
			dir = 'd';
			if (x + 1 < H && gboard[x + 1][y] == '.') {
				gboard[x][y] = '.';
				x = x + 1;
			}
			gboard[x][y] = 'v';
			break;

		case 'L':
			// 방향 변경
			dir = 'l';
			if (y-1 >=0 && gboard[x][y-1] == '.') {
				gboard[x][y] = '.';
				y=y-1;
			}
			gboard[x][y] = '<';
			break;

		case 'R':
			// 방향 변경
			dir = 'r';
			if (y+1 <W && gboard[x][y+1] == '.') {
				gboard[x][y] = '.';
				y=y+1;
			}
			gboard[x][y] = '>';
			break;

		case 'S':
			bomb(dir);
			break;

		}
		
/*		System.out.println(c);
		System.out.println("__________");
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				System.out.print(gboard[i][j]);
			}
		System.out.println();	
		}
		System.out.println("__________");*/
	}
	
	public static void bomb(char dir) {
		int start = 0;
		int end = 0;
		int UpORDown = 0;
		char[] arr;
		switch(dir) {
		case 'u':
			//x값을 줄여보기
			start = x-1;
			end = -1;
			UpORDown = -1;
			bombGoX(start, end, UpORDown);
			break;

		case 'd':
			//x값을 늘려보기
			start = x+1;
			end = H;
			UpORDown = 1;
			bombGoX(start, end, UpORDown);
			break;
		case 'l':
			//y값을 줄여보기
			start = y-1;
			end = -1;
			UpORDown = -1;
			bombGoY(start, end, UpORDown);
			break;
			
		case 'r':
			//y값을 늘려보기
			start = y+1;
			end = W;
			UpORDown = 1;
			bombGoY(start, end, UpORDown);
			break;
		}


	}
	
	public static void bombGoX(int start, int end, int UpDown) {
		
		//x좌표 변경하면서 탐색

		
		if(UpDown>0) {
			for(int i=start;i<end;i=i+UpDown) {
				if(gboard[i][y]=='#') {
					break;
				}else if(gboard[i][y]=='*') {
					gboard[i][y]='.';
					break;
				}
				
			}
			
		}else {
			for(int i=start;i>end;i=i+UpDown) {
				if(gboard[i][y]=='#') {
					break;
				}else if(gboard[i][y]=='*') {
					gboard[i][y]='.';
					break;
				}
				
			}
		}
	}

	public static void bombGoY(int start, int end, int UpDown) {
		
		//y좌표 변경하면서 탐색

		if(UpDown>0) {
			for(int i=start;i<end;i=i+UpDown) {
				if(gboard[x][i]=='#') {
					break;
				}else if(gboard[x][i]=='*') {
					gboard[x][i]='.';
					break;
				}
			}
		}else {
			for(int i=start;i>end;i=i+UpDown) {
				if(gboard[x][i]=='#') {
					break;
				}else if(gboard[x][i]=='*') {
					gboard[x][i]='.';
					break;
				}
			}
		}
	}
}
