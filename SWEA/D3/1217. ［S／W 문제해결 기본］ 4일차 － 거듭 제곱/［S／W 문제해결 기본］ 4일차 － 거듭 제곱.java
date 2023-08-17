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
             
            int k = sc.nextInt();
             
            int N = sc.nextInt();
            int M = sc.nextInt();
             
            sb.append("#"+test_case+" "+mulmul(N,0,M)+"\n");
        }
        System.out.println(sb.toString());
    }
     
    public static int mulmul(int a, int cnt, int N) {
        if(cnt>=N-1) {
            return a;
        }
        cnt++;
         
        return a*mulmul(a,cnt,N);
    }
 
}