import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        // getInfo 함수의 로직을 구현하는 부분
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] edge : edges) {
            int giveNode = edge[0];
            int receiveNode = edge[1];

            map.computeIfAbsent(giveNode, k -> new int[]{0, 0})[0]++;
            map.computeIfAbsent(receiveNode, k -> new int[]{0, 0})[1]++;

        }

        // chkInfo 함수의 로직을 구현하는 부분
        int[] res = new int[4];
        int keyWithMaxGive = -1;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int key = entry.getKey();
            int[] io = entry.getValue();
            int give = io[0];
            int receive = io[1];

            if (give >= 2 && receive == 0) {
                keyWithMaxGive = key;
            } else if (give == 0) {
                res[2]++;
            } else if (give >= 2 && receive >= 2) {
                res[3]++;
            }
        }

        // 도넛 그래프 개수 계산 로직
        if (keyWithMaxGive != -1) {
            res[1] = map.get(keyWithMaxGive)[0] - res[2] - res[3];
            res[0] = keyWithMaxGive;
        }

        return res;
    }
}