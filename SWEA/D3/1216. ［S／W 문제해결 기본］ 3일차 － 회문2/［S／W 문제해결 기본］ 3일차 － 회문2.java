import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {

	public static void main(String args[]) throws Exception {

		//System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {

			// 가장큰 길이 100부터 확인
			// charAt(0~99)
			// 회문사이즈을 줄여가면서 -> 이미 담긴 회문의 길이보다 작아지면 종료

			int test = sc.nextInt();

			char[][] arr = new char[100][100];

			// 2차 배열에 char값 받기
			String tempStr;
			for (int i = 0; i < 100; i++) {
				tempStr = sc.next();
				for (int j = 0; j < 100; j++) {
					arr[i][j] = tempStr.charAt(j);
				}
			}
			// input 종료

			int maxLen = 0;

			// 가로체크부터
			
			
			
			//한줄 체크용
			
			
			for(int x = 0; x<100; x++) {
				int palLen = 100;
				//arr[x][변동]
				while (palLen > maxLen && palLen > 0) {
					
					//시작점의 범위
	ystart:				for(int y=0; y<100-palLen+1; y++) {
						
						boolean check=false;
						//시작점 y에서 가능한 길이 palLen의 문자열 확인
						for(int d=0; d<palLen/2+1; d++) {
							if(arr[x][y+d]==arr[x][y+palLen-d-1]) {
								check =true;
								continue;
							}else {
								check = false;
								break;
							}
						}
						//y에서부터 시작된 문자열의 여부 확인
						if(check&& maxLen<palLen) {
							maxLen=palLen;
							palLen--;
							break ystart; //동일한 palLen볼 필요 x
						}
						
					}
					palLen--;
				}
			}

			for(int y = 0; y<100; y++) {
				int palLen = 100;
				//arr[x][변동]
				while (palLen > maxLen && palLen > 0) {
					
					//시작점의 범위
	xstart:				for(int x=0; x<100-palLen+1; x++) {
						
						boolean check=false;
						//시작점 y에서 가능한 길이 palLen의 문자열 확인
						for(int d=0; d<palLen/2; d++) {
							if(arr[x+d][y]==arr[x+palLen-d-1][y]) {
								check =true;
								continue;
							}else {
								check = false;
								break;
							}
						}
						//y에서부터 시작된 문자열의 여부 확인
						if(check && maxLen<palLen) {
							maxLen=palLen;
							palLen--;
							break xstart; //동일한 palLen볼 필요 x
						}
						
					}
					palLen--;
				}
			}
			
			

				sb.append("#" + test_case + " " + maxLen + "\n");
			}

		System.out.println(sb.toString());

		}

		
	}