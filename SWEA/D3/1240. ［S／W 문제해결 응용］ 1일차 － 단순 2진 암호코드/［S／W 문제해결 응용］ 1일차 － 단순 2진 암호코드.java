import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.lang.reflect.Array;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{

		//System.setIn(new FileInputStream("res/input.txt"));


		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		StringBuilder sbAsw = new StringBuilder();

	for(int test_case = 1; test_case <= T; test_case++){
			int N = sc.nextInt();
			int M = sc.nextInt();
			String code = null;
			String temp;
			//전부 입력 받기
			for(int i=0; i<N;i++) {
				temp = sc.next();
				if(temp.contains("1")) {
					code = temp;
				}
			}
			
			StringBuffer sb = new StringBuffer(code);
			
			char[] arrCode = code.toCharArray();
			
			int codeEndIdx = 0;
			for(int i=0; i<arrCode.length;i++) {
				if(arrCode[arrCode.length-i-1]=='1') {
					codeEndIdx = arrCode.length-i-1;
					break;
				}
			}
			
			sb.setLength(0);
			//5:0110001
			//1:0011001
			//0:0001101
			//3:0111101
			//2:0010011
			//4:0100011
			//9:0001011
			//7:0111011
			//8:0110111
			//6:0101111
			//codeEndIdx에서부터 7씩 빼면서 탐색
			//현재 봐야하는인덱스 idx;
			//가장 뒷자리는 항상 1이므로
			int idx = codeEndIdx;
			int[] intCode = new int[8];
			int cnt = 7;
			while(idx>=0 && arrCode[idx]=='1') {
			//뒤의 다섯자리 확인하면 됨
				
				
				//뒤에서 두 번째 자리
codeCheck:	switch(arrCode[idx-1]) {
				
				case '0':
					//뒤에서 세 번째 자리
					switch(arrCode[idx-2]) {
					case '0':
						//네 번째 자리만 체크하면 됨
						if(arrCode[idx-3]=='0') {
							intCode[cnt]=5;
							//sb.insert(0, 5);
							break codeCheck;
						}else {
							intCode[cnt]=1;
							//sb.insert(0, 1);
							break codeCheck;
						}
					
					case '1':						
						//다섯 번째 자리만 체크하면 됨
						if(arrCode[idx-4]=='0') {
							intCode[cnt]=0;
							//sb.insert(0, 0);
							break codeCheck;
						}else {
							intCode[cnt]=3;
							//sb.insert(0, 3);
							break codeCheck;
						}
						
					}
				case '1':
					//세 번째 자리  1인 경우가 2
					if(arrCode[idx-2]=='1') {
						//네 번째 자리 차이 체크
						if(arrCode[idx-3]=='0') {
							intCode[cnt]=8;
							//sb.insert(0, 8);
							break codeCheck;
						}else {
							intCode[cnt]=6;
							//sb.insert(0, 6);
							break codeCheck;
						}

					}else {
						
						//2:0010011
						//4:0100011
						//9:0001011
						//7:0111011
						
						//세번째자리가 0인 경우에 대한 체크
						
						//네번재자리가 0 && 다섯번째자리가 0 = 4
						if(arrCode[idx-3]=='0' && arrCode[idx-4]=='0' ) {
							intCode[cnt]=4;
							//sb.insert(0, 4);
							break codeCheck;
						}else if(arrCode[idx-3]=='0' && arrCode[idx-4]=='1'){
							//네번재자리가 0 && 다섯번째자리가 1 = 2
							intCode[cnt]=2;
							//sb.insert(0, 2);
							break codeCheck;
						}else if(arrCode[idx-3]=='1' && arrCode[idx-4]=='0') {
							//네번재자리가 1 && 다섯번째자리가 0 = 9
							intCode[cnt]=9;
							//sb.insert(0, 9);
							break codeCheck;
						}else if(arrCode[idx-3]=='1' && arrCode[idx-4]=='1'){
							//네번재자리가 1 && 다섯번째자리가 1 = 7
							intCode[cnt]=7;
							//sb.insert(0, 7);
							break codeCheck;
						}else {
							System.out.println("오류발생");
						}
						
					}
					
				
				}

			cnt--;
			idx -= 7;
			
			}
			
			int sumReal =0;
			int sum =0;
			//intCode에 코드 들어감.
			for(int i=0;i<intCode.length;i++) {
				if(i%2==0){
					sumReal+=intCode[i]*3;
					
				}else {
					sumReal+=intCode[i];
				}
				sum += intCode[i];
			}
			
				if(sumReal%10!=0) {
				sum = 0;
			}

			sbAsw.append("#"+test_case+" "+sum+"\n");
			
			
		}

	System.out.println(sbAsw.toString());
		
	}
}