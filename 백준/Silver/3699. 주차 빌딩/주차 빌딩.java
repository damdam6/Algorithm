
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static park[] carlist;
	static int[][] b;
	static int l;
	static int h;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(bf.readLine());
			h = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			
			b = new int[h][l];
			
			int maxNum = 0;
			
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < l; j++) {
					b[i][j] = Integer.parseInt(st.nextToken());
					if(b[i][j]!=-1) {
						
						maxNum = Math.max(maxNum, b[i][j]);
					}
				}
			}
			
			carlist = new park[maxNum+1];
			
			carlist[0] = new park(0,0);
			for(int i=0;i<h;i++) {
				for (int j = 0; j < l; j++) {			
					if(b[i][j]!=-1) {	
						carlist[b[i][j]] = new park(i,j);
					}
				}
			}
			
			
			int realsum =0;
			for(int i=0;i<h;i++) {
				realsum+=count(i, b[i]);
			}
			System.out.println(realsum);
		}
	}
	
	public static int count(int h, int[] arr) {
		
		
		int[] chk = Arrays.copyOf(arr, arr.length);
		Arrays.sort(chk);
		
		int idx = -1;
		for(int i=0;i<chk.length;i++) {
			if(chk[i]==-1)continue;
			idx = i;
			break;
		}
		
		if(idx==-1) {
			return 0;
		}
		
		int start = 0;
		int sum = 0;
		//System.out.println(Arrays.toString(chk));
		//System.out.println("carli "+Arrays.toString(carlist));

		for(int i=idx;i<chk.length;i++) {

			int a = Math.min(start, carlist[chk[i]].y);
			int b =  Math.max(start, carlist[chk[i]].y);
			

			int min = Math.min(Math.abs(a-b), Math.abs(a)+Math.abs(chk.length-b));
			start = carlist[chk[i]].y;

			sum +=min;
		}
		

		return sum*5+(chk.length-idx)*h*10*2;
	}
	
	static class park{
		int x;
		int y;
		int vt;
		
		park(int h, int l){
			this.x = h;
			this.y = l;
		}
		
		public String toString() {
			return "xy"+ x+" "+y;
		}
	}

}
