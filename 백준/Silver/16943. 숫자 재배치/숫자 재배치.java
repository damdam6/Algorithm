
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		int[] arrA = new int[10];
		
		Arrays.fill(arrA, -1);
		
		int tmp = A;
		int idx = 0;
		while(tmp > 0) {
			arrA[idx] = tmp%10;
			tmp = tmp/10;
			idx++;
		}
		
		Arrays.sort(arrA);
		//System.out.println(Arrays.toString(arrA));
		reArr = new int[10];

		for(int i=9;i>=0;i--) {
			reArr[9-i] = arrA[i];
		}
	
		//System.out.println(Arrays.toString(reArr));
		
		size = idx;
		nowInt = 0;
		vt = new int[10];
		dfs(0);
		if(!chk) {
			nowInt = -1;
		}
		System.out.println(nowInt);
	}
	
	static int B;
	static int size;
	static int[] vt;
	static int nowInt;
	static int[] reArr;
	static boolean chk;
	public static void dfs(int nowSize) {
		
		if(chk)return;
		
		if(nowSize == size) {
			if(nowInt < B) {
				chk = true;
			}
			
			return;
		}
		
		
		for(int i=0;i<size;i++) {
			if(vt[i]==1)continue;
			if(nowSize==0 && reArr[i] == 0 )continue;
			vt[i] = 1;
			nowInt = nowInt*10+ reArr[i];
			dfs(nowSize+1);
			if(chk)return;
			nowInt = nowInt/10;
			vt[i] = 0;
		}
		

	}
	

}
