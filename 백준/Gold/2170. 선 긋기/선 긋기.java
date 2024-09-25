import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws Exception {


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        PriorityQueue<Line> pqu = new PriorityQueue<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            pqu.add(new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int start = -1_000_000_000;
        int end = -1_000_000_000;

        int length = 0;
        while(!pqu.isEmpty()){

            Line tmp = pqu.poll();

            if(end < tmp.startP){
                length += end - start;
                start = tmp.startP;
                end = tmp.endP;
                continue;
            }
            if( tmp.endP > end){
                end = tmp.endP;
                continue;
            }

        }
        length += end - start;
        System.out.println(length);
    }

   static class Line implements Comparable<Line>{
        int startP;
        int endP;

        public Line(int startP, int endP) {
            this.startP = startP;
            this.endP = endP;
        }

        public int compareTo(Line o){
            if(this.startP < o.startP)return -1;
            if(this.startP > o.startP)return 1;
            if(this.endP < o.endP)return -1;
            if(this.endP > o.endP)return 1;
            return 0;
        }
    }
}