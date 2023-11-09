import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static int n;
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(bf.readLine());
		PriorityQueue<sum> pqu = new PriorityQueue<>();
		
		for(int i=1;i <= Math.sqrt(n);i++)
		{
			pqu.add(new sum(n - i*i,1));
		}
		sum tmp = null;
		
all:		while(!pqu.isEmpty()) {
			//System.out.println(pqu.toString());
			tmp = pqu.poll();
			//System.out.println("tmp "+tmp);
			if(tmp.sum < 0 )continue;
			if(tmp.sum == 0) {
				break;
			}
			
			for(int i=1;i<=Math.sqrt(n);i++) {
				int chk = tmp.sum - i*i;
				if(chk == 0) {
					tmp.cnt++;
					break all;
				}
				if(chk < 0) continue;
				pqu.add(new sum(chk, tmp.cnt+1));
			}
			
			
		}
		
		System.out.println(tmp.cnt);
		
	}
	
	static class sum implements Comparable<sum>{
		int sum;
		int cnt;
		sum(int sum, int cnt){
			this.sum = sum;
			this.cnt = cnt;
		}
		public int compareTo(sum o) {
			if(this.cnt < o.cnt ) {
				return -1;
			}else if(this.cnt > o.cnt) {
				return 1;
			}
			
			return Integer.compare(this.sum, o.sum);
		}
		@Override
		public String toString() {
			return "sum [sum=" + sum + ", cnt=" + cnt + "]";
		}
		
		
	}

}
