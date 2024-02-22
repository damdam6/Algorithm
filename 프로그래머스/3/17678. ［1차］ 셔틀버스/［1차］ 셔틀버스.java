import java.util.*;

class Solution {
    static ArrayList<Integer> timeInt; // 타임테이블을 분 단위로 변환하여 저장하는 리스트

    public String solution(int n, int t, int m, String[] timetable) {
        timeInt = new ArrayList<>();
        // 타임테이블 시간을 분 단위로 변환
        for(String time : timetable) {
            int hour = Integer.parseInt(time.substring(0, 2));
            int minute = Integer.parseInt(time.substring(3));
            timeInt.add(hour * 60 + minute);
        }
        Collections.sort(timeInt); // 정렬

        int busTime = 9 * 60; // 첫 버스 시간 (09:00을 분 단위로)
        int lastTime = 0; // 마지막으로 버스를 탈 수 있는 시간

        for(int i = 0; i < n; i++) { // 모든 버스에 대해서 반복
            int count = 0; // 이번 버스에 탑승한 사람 수
            while(count < m && !timeInt.isEmpty() && timeInt.get(0) <= busTime) {
                lastTime = timeInt.remove(0) - 1; // 마지막 사람이 탑승한 시간보다 1분 빠르게
                count++;
            }
            if(i < n-1 || count < m) { // 마지막 버스가 아니거나, 마지막 버스에 자리가 남아있는 경우
                lastTime = busTime; // 버스 출발 시간에 맞춰 도착
            }
            busTime += t; // 다음 버스 시간 계산
        }

        // 마지막으로 탑승 가능한 시간을 "HH:MM" 형식으로 변환하여 반환
        return String.format("%02d:%02d", lastTime / 60, lastTime % 60);
    }
}
