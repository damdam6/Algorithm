import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int R;
    static int C;

    static char[][] maze;

    public static void main(String[] args) throws Exception {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        maze = new char[R][C];
        pos start = null;

        fireQue = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            String str = bf.readLine();
            for (int j = 0; j < C; j++) {

                maze[i][j] = str.charAt(j);

                if (maze[i][j] == 'J') {
                    start = new pos(i, j);
                    continue;
                }

                if (maze[i][j] == 'F') {
                    pos fire = new pos(i, j);
                    fireQue.add(fire);
                    continue;
                }

            }
        }
        // 맵 받기 완

        int[][] vt = new int[R][C];
        ArrayDeque<pos> qu = new ArrayDeque<>();


        qu.add(start);
        vt[start.r][start.c] = 1;
        int fireTime = 0;
        while (!qu.isEmpty()) {
            pos tmp = qu.poll();

            //  벽근처 이미 도달했을 경우
            if (tmp.r == 0 || tmp.r == R - 1 || tmp.c == 0 || tmp.c == C - 1) {

                System.out.println(tmp.time + 1);
                return;
            }
            if (fireTime != tmp.time+1) {
                fireBfs(tmp.time+1);
                fireTime = tmp.time+1;

            }

            for (int i = 0; i < 4; i++) {
                int nr = tmp.r + dr[i];
                int nc = tmp.c + dc[i];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;

                if (maze[nr][nc] == 'F' || maze[nr][nc] == '#') continue;
                if (vt[nr][nc] == 1) continue;

                vt[nr][nc] = 1;
                qu.add(new pos(nr, nc, tmp.time + 1));
            }


        }

        System.out.println("IMPOSSIBLE");


    }

    static int[] dr = new int[]{1, -1, 0, 0};
    static int[] dc = new int[]{0, 0, 1, -1};


    static ArrayDeque<pos> fireQue;

    static void fireBfs(int time) {

        while (!fireQue.isEmpty() && fireQue.peek().time < time) {
            pos tmp = fireQue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = tmp.r + dr[i];
                int nc = tmp.c + dc[i];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                if (maze[nr][nc] == '#' | maze[nr][nc] == 'F') continue;
                maze[nr][nc] = 'F';
                fireQue.add(new pos(nr, nc, tmp.time + 1));

            }
        }
    }


    static class pos {
        int r;
        int c;
        int time;

        public pos(int r, int c) {
            this.r = r;
            this.c = c;
            this.time = 0;
        }

        public pos(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
}
