import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{

        // 날짜 계산기
        MONTH_DATE = new HashMap<>(){};
        MONTH_DATE.put(0,0);
        for (int i = 1; i <= 12; i++) {
            if(i%2 == 1 && i <= 7){
                MONTH_DATE.put(i, MONTH_DATE.get(i-1)+ 31);
            }else if(i%2 == 1){
                MONTH_DATE.put(i,  MONTH_DATE.get(i-1)+ 30);
            }else if(i == 2){
                MONTH_DATE.put(i, MONTH_DATE.get(i-1)+  28);
            }else if(i >= 8){
                MONTH_DATE.put(i,  MONTH_DATE.get(i-1)+ 31);
            }else {
                MONTH_DATE.put(i, MONTH_DATE.get(i-1)+ 30);
            }
        }


        Comparator<Flower> comp = new Comparator<Flower>() {
            @Override
            public int compare(Flower o1, Flower o2) {
                if(o1.start < o2.start)return -1;
                if(o1.start > o2.start)return 1;
                if(o1.end < o2.end)return 1;
                if(o1.end > o2.end)return -1;
                return 0;
            }
        };


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        TreeSet<Flower> flowers = new TreeSet<>(comp);

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            int startM = Integer.parseInt(st.nextToken());
            int startD = Integer.parseInt(st.nextToken());
            int endM = Integer.parseInt(st.nextToken());
            int endD = Integer.parseInt(st.nextToken());

            Flower f = new Flower(
                    getNumOfDay(startM, startD),
                    getNumOfDay(endM, endD)
            );
            flowers.add(f);
        }
        flowerArr = new ArrayList<>(flowers);

        int nowDate = getNumOfDay(3,1);
        int maxE = nowDate;
        int cnt = 0;
        int idx = 0;

        int checkEnd = 0;
        while(nowDate < getNumOfDay(12,1)){

            checkEnd = 0;
            while(idx < flowerArr.size() && flowerArr.get(idx).start <= nowDate){
                if(flowerArr.get(idx).end > maxE){
                    maxE = flowerArr.get(idx).end;
                    checkEnd = 1;
                }
                idx++;
            }
            if(checkEnd != 1){
                cnt = 0;
                break;
            }

            cnt++;
            nowDate = maxE;
        }

        System.out.println(cnt);

    }

    static  ArrayList<Flower> flowerArr;
    static HashMap<Integer, Integer> MONTH_DATE;
    static int getNumOfDay(int month, int date){
        return MONTH_DATE.get(month-1) + date;
    };

    static class Flower{
        int start;
        int end;

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Flower{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
