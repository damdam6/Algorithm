import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Solution {
     
    public static void main(String[] args) throws NumberFormatException, IOException {
         
        //System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new  StringBuilder();
        StringTokenizer st;
        int T = 10;
         
        for(int tc = 1; tc<=T;tc++) {
             
            //원본 암호문의 길이
            int N  = Integer.parseInt(bf.readLine());
            //LinkedList선언 후 담기
            LinkedList<String> linkL = new LinkedList<>();
            st = new StringTokenizer(bf.readLine());
            while(linkL.size()<N) {
                linkL.add(st.nextToken());
            }
             
            //명령어의 개수 받기
            int O = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
 
             
            //명령어를 나누기
            for(int i=0;i<O;i++) {
                //st.nextToken()에 [명령어 숫자 숫자 암호문 암호문...] 담겨있음.
 
                char check = st.nextToken().charAt(0);
                int idx;
                int cnt;
                 
                switch(check) {
                case 'I':
                    idx = Integer.parseInt(st.nextToken());
                    cnt = Integer.parseInt(st.nextToken());
                    for(int j=0;j<cnt;j++) {
                        linkL.add(idx++,st.nextToken());
                        }
                    break;              
                case 'D':
                    idx = Integer.parseInt(st.nextToken());
                    cnt = Integer.parseInt(st.nextToken());
                    for(int j=0;j<cnt;j++) {
                        linkL.remove(idx);
                        }
                    break;
                 
                case 'A':
                    cnt = Integer.parseInt(st.nextToken());
                    for(int j=0;j<cnt;j++) {
                        linkL.add(st.nextToken());
                        }
                    break;
                     
                }
                 
             
            }
             
            sb.append("#").append(tc);
            for(int i=0;i<10;i++) {
                sb.append(" ").append(linkL.pollFirst());
            }
            sb.append("\n");
 
        }
        System.out.println(sb);
    }
 
}