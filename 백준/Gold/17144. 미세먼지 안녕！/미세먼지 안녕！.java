import java.io.*;
import java.util.*;

public class Main {
    static int[][] room;
    static int R, C, T;
    static int[] airCleaner;
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        room = new int[R][C];
        airCleaner = new int[2];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == -1) {
                    airCleaner[1] = i; // 공기청정기 아래쪽 위치 저장
                }
            }
        }
        airCleaner[0] = airCleaner[1] - 1; // 공기청정기 위쪽 위치 저장

        for (int t = 0; t < T; t++) {
            spreadDust();
            cleanAir();
        }

        System.out.println(sumDust());
    }

    // 미세먼지 확산
    static void spreadDust() {
        int[][] temp = new int[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (room[r][c] > 0) {
                    int amount = room[r][c] / 5;
                    for (int[] d : directions) {
                        int nr = r + d[0], nc = c + d[1];
                        if (nr >= 0 && nr < R && nc >= 0 && nc < C && room[nr][nc] != -1) {
                            temp[nr][nc] += amount;
                            room[r][c] -= amount;
                        }
                    }
                }
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                room[r][c] += temp[r][c];
            }
        }
    }

    // 공기청정기 작동
    static void cleanAir() {
        // 위쪽 공기청정기
        for (int i = airCleaner[0] - 1; i > 0; i--) room[i][0] = room[i-1][0];
        for (int i = 0; i < C - 1; i++) room[0][i] = room[0][i+1];
        for (int i = 0; i < airCleaner[0]; i++) room[i][C-1] = room[i+1][C-1];
        for (int i = C - 1; i > 1; i--) room[airCleaner[0]][i] = room[airCleaner[0]][i-1];
        room[airCleaner[0]][1] = 0;

        // 아래쪽 공기청정기
        for (int i = airCleaner[1] + 1; i < R - 1; i++) room[i][0] = room[i+1][0];
        for (int i = 0; i < C - 1; i++) room[R-1][i] = room[R-1][i+1];
        for (int i = R - 1; i > airCleaner[1]; i--) room[i][C-1] = room[i-1][C-1];
        for (int i = C - 1; i > 1; i--) room[airCleaner[1]][i] = room[airCleaner[1]][i-1];
        room[airCleaner[1]][1] = 0;
    }

    // 미세먼지 총량 계산
    static int sumDust() {
        int sum = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (room[r][c] > 0) sum += room[r][c];
            }
        }
        return sum;
    }
}
