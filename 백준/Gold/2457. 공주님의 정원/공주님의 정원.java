import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Flower[] flowers = new Flower[N];

        // 월별 누적 일수 배열 (1월부터 12월까지)
        int[] monthCumDays = new int[13];
        int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
        for(int i = 1; i <= 12; i++) {
            monthCumDays[i] = monthCumDays[i-1] + daysInMonth[i-1];
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int startM = Integer.parseInt(st.nextToken());
            int startD = Integer.parseInt(st.nextToken());
            int endM = Integer.parseInt(st.nextToken());
            int endD = Integer.parseInt(st.nextToken());

            int start = getNumOfDay(monthCumDays, startM, startD);
            int end = getNumOfDay(monthCumDays, endM, endD);
            flowers[i] = new Flower(start, end);
        }

        // 꽃들을 시작일 기준으로 오름차순, 시작일이 같다면 끝일 기준으로 내림차순 정렬
        Arrays.sort(flowers, (a, b) -> {
            if(a.start != b.start) return Integer.compare(a.start, b.start);
            return Integer.compare(b.end, a.end);
        });

        int current = getNumOfDay(monthCumDays, 3, 1); // 3월 1일
        int targetEnd = getNumOfDay(monthCumDays, 12, 1); // 11월 30일
        int cnt = 0;
        int idx = 0;
        int maxEnd = current;

        while(current <= targetEnd) {
            boolean found = false;
            // 현재 날짜 이하로 시작하는 꽃들 중 가장 늦게 끝나는 꽃 찾기
            while(idx < N && flowers[idx].start <= current) {
                if(flowers[idx].end > maxEnd){
                    maxEnd = flowers[idx].end;
                    found = true;
                }
                idx++;
            }

            if(!found){
                cnt = 0;
                break;
            }

            cnt++;
            current = maxEnd;

            if(current >= targetEnd){
                break;
            }
        }

        if(maxEnd < targetEnd){
            System.out.println(0);
        } else {
            System.out.println(cnt);
        }
    }

    static int getNumOfDay(int[] monthCumDays, int month, int day){
        return monthCumDays[month-1] + day;
    }

    static class Flower{
        int start;
        int end;

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
