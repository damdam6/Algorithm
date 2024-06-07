import java.util.*;

class Solution {
    public int solution(int[][] targets) {

        // 화살표 함수 (sort대상), (sort 기준)
        // Integer.compare을 통해서 비교하기
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int lastEnd = -1;

        for (int[] target : targets) {
            if (target[0] > lastEnd) {
                // Place an interceptor just before the end of the current interval
                lastEnd = target[1] - 1;
                count++;
            }
        }

        return count;
    }
}
