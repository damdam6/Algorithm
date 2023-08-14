import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		StringBuilder sb = new StringBuilder();

		//System.setIn(new FileInputStream("res/input.txt"));


		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			String str = sc.next();
			int check = 1;
			for(int i=0; i<str.length();i++) {
				if(str.charAt(i) != str.charAt(str.length()-i-1)) {
					check = 0;
					break;
				}
			}

			sb.append("#"+(test_case)+" "+check+"\n");

		}
		
		System.out.println(sb.toString());
	}
}