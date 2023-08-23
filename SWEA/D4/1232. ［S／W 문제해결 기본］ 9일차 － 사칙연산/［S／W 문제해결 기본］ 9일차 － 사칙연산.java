import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class Solution {
 
    static int N;
    static String[][] arr;
    static StringBuilder sb = new StringBuilder();
    static StringBuilder tmp;
    static int cal;
    static Stack<Integer> stk = new Stack<>();
    public static void main(String args[]) throws Exception
    {
        //System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=10;
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            cal = 0;
            tmp =  new StringBuilder();
            //후위탐색
            N = Integer.parseInt(bf.readLine());
                         
            arr = new String[N+1][4];
            for(int i=1;i<N+1;i++) {
                String str = bf.readLine();
                //String[] [idx, char, left, right]
                arr[i] =str.split(" ");
            }
             
 
            dfsByInOrder(1);
 
            sb.append("#"+test_case+" "+cal+"\n");
             
        }
         
        System.out.println(sb);
         
    }
     
    public static void dfsByInOrder(int current) {
        //현재 노드를 중위순회로 탐색
        //자식부터 탐색
        if(arr[current].length ==4)dfsByInOrder(Integer.parseInt(arr[current][2]));     
        //현재 탐색대상을 통해 탐색해야할 새로운 대상을 재귀호출로 탐색시키기
        if(arr[current].length ==4)dfsByInOrder(Integer.parseInt(arr[current][3]));
         
        if(arr[current][1].equals("-")) {
            int b = stk.pop();
            int a = stk.pop();
            cal = a - b;
            stk.push(cal);
             
        }else if(arr[current][1].equals("+")) {
            cal = stk.pop()+stk.pop();
            stk.push(cal);
             
        }else if(arr[current][1].equals("/")) {
            int b = stk.pop();
            int a = stk.pop();
            cal = a / b;
            stk.push(cal);
             
        }else if(arr[current][1].equals("*")) {
            cal = stk.pop()*stk.pop();
            stk.push(cal);
        }else {
            stk.push(Integer.parseInt(arr[current][1]));
        }
    }
     
     
}