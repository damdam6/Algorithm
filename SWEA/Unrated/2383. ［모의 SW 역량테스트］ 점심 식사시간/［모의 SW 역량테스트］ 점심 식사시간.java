import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Solution {
    static int N;
    static int[][] room;
    static int[][] people;
    static int[][] stair;
    static int pIdx;
    static int sIdx;
     
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("res/sample_input.txt"));
 
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());
         
        //테케 하나만 
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(bf.readLine());
             
            people = new int[10][2];
            stair = new int[2][2];
            room = new int[N][N];
            //사람 수
            pIdx = 0;
            sIdx = 0;
            //방 받기
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < N; j++) {
                    room[i][j] = Integer.parseInt(st.nextToken());
                    if(room[i][j]==1) {
                        people[pIdx][0] = i;
                        people[pIdx++][1] = j;
                    }else if(room[i][j]!=0) {
                        stair[sIdx][0] = i;
                        stair[sIdx++][1] = j;
                    }
                }
            }
            choice = new int[pIdx];
            minTime = Integer.MAX_VALUE;
            setStair(0);
            //qu에 사용자가 3이상 들어가면 안됨 
            sb.append("#"+tc+" "+minTime).append("\n");
 
        }
        System.out.println(sb);
    }
     
    //완탐
     
    //몇 번 계단으로 들어가는지 체크해야됨
    static int[] choice;
    static int minTime;
    static void setStair(int idx) {
        if(idx==pIdx) {
            int max = Math.max(Time(0), Time(1));
            //System.out.println(max);
            minTime = Math.min(minTime, max);
            return;
        }
         
        //0일때(기본)
 
        //1일때(변경)
        choice[idx] = 1;
        setStair(idx+1);
        choice[idx] = 0;
        setStair(idx+1);
         
    }
     
    static int Time(int roomN) {
         
        PriorityQueue<Integer> pqu = new PriorityQueue<>();
        Deque<Integer> qu = new ArrayDeque<>();
        for(int i=0;i<pIdx;i++) {
            if(choice[i]!=roomN)continue;
            int dis = Math.abs(people[i][0]-stair[roomN][0])+Math.abs(people[i][1]-stair[roomN][1]);
            pqu.add(dis+1);
        }
         
        int now =0;
        while(!pqu.isEmpty()) {
             
            //qu가 3개 미만일때
            while(!pqu.isEmpty()&&qu.size()<3) {
                 
                if(now >= pqu.peek()) {
                     
                    //
                    qu.add(now);
                    pqu.poll();
                }else {
                    now = pqu.poll();
                    qu.add(now);
                }
                 
            }
            //qu가 3개가 됨
             
            while(now >=qu.peek()+room[stair[roomN][0]][stair[roomN][1]]) {
                qu.poll();
            }
             
            if(qu.size()==3) {
                now = qu.poll()+room[stair[roomN][0]][stair[roomN][1]];
            }
             
        }
         
        while(!qu.isEmpty()) {
            if(now >=qu.peek()+room[stair[roomN][0]][stair[roomN][1]]) {
                qu.poll();
            }else {
                now = qu.poll()+room[stair[roomN][0]][stair[roomN][1]];
            }
        }
        return now;
    }
}