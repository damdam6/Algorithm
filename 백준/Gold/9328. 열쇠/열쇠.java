

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for (int tc = 0; tc < test_case; tc++) {
            st = new StringTokenizer(bf.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            char[][] map = new char[h][w];

            for (int i = 0; i < h; i++) {
                String str = bf.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = str.charAt(j);
                }
            }

            String keyString = bf.readLine();
            HashSet<Character> keys = new HashSet<>();
            if(!keyString.equals("0")){
                for (int i = 0; i < keyString.length(); i++) {
                    keys.add(keyString.charAt(i));
                }
            }

            int docs = getTotalDocs(keys, map);

            System.out.println(docs);

        }
    }

    // 모든 맵의 key는 소문자로 저장
    static char toLowerCase(char c){
        return Character.toLowerCase(c);
    }

    char toUpperCase(char c){
        return Character.toUpperCase(c);
    }

    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};

   static int getTotalDocs(HashSet<Character> keys, char[][] map){
        int totalDocs = 0;

        HashMap<Character, HashSet<Pos>> cannotGoThrough = new HashMap<>();

        StartPoint start = setStartPoints(map, keys, cannotGoThrough);
        ArrayDeque<Pos> qu = start.qu;
        int[][] vt = start.vt;

        while(!qu.isEmpty()){
            Pos tmp = qu.poll();
//            for(int[] v: vt){
//                System.out.println(Arrays.toString(v));
//            }
//            System.out.println("keys "+keys);
//            System.out.println("cannotGoThrough "+cannotGoThrough);
//            System.out.println("totaldocs "+totalDocs);

            if(vt[tmp.x][tmp.y] == 1)continue;
            vt[tmp.x][tmp.y] = 1;
            if(map[tmp.x][tmp.y] == '$'){
                totalDocs++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length )continue;
                if(vt[nx][ny] == 1)continue;
                totalBFSwork(vt, new Pos(nx, ny), map, keys, cannotGoThrough, qu);

            }

        }



        return totalDocs;
    }

    static class StartPoint {
        ArrayDeque<Pos> qu;
        int[][] vt;

        public StartPoint(ArrayDeque<Pos> qu, int[][] vt) {
            this.qu = qu;
            this.vt = vt;
        }
    }

    static StartPoint setStartPoints(char[][] map, HashSet<Character> keys, HashMap<Character, HashSet<Pos>> cannotGoThrough){

        int[][] vt = new int[map.length][map[0].length];
        ArrayDeque<Pos> bfs = new ArrayDeque<>();

        for (int i = 0; i < map.length; i++) {
            // 세로로 뒤져보기
            Pos p = new Pos(i, 0);
            totalBFSwork(vt, p, map,keys, cannotGoThrough, bfs);

            p.y = map[0].length - 1;
            totalBFSwork(vt , p, map,keys, cannotGoThrough, bfs);
        }

        for (int i = 0; i < map[0].length; i++) {
            Pos p = new Pos(0, i);
            totalBFSwork(vt, p, map,keys, cannotGoThrough, bfs);

            p.x = map.length - 1;
            totalBFSwork(vt , p, map,keys, cannotGoThrough, bfs);
        }

        return new StartPoint(bfs, vt);
    }

    static void totalBFSwork(int[][] vt, Pos p, char[][] map, HashSet<Character> keys, HashMap<Character, HashSet<Pos>> cannotGoThrough, ArrayDeque<Pos> bfs){
      int docs = 0;
      if(map[p.x][p.y] == '$'){
          docs++;
      }
      checkMapCase(p, map,keys, cannotGoThrough, bfs);
    };


    static void checkMapCase(Pos p, char[][] map, HashSet<Character> keys, HashMap<Character, HashSet<Pos>> cannotGoThrough, ArrayDeque<Pos> bfs){

        if(map[p.x][p.y] == '*')return;

        if(map[p.x][p.y] == '.' || map[p.x][p.y] == '$' ){
            bfs.add(new Pos(p));
            return;
        }

        if(Character.isLowerCase(map[p.x][p.y])){
            keys.add(toLowerCase(map[p.x][p.y]));
            if(cannotGoThrough.containsKey(toLowerCase(map[p.x][p.y]))){
                bfs.addAll(cannotGoThrough.get(toLowerCase(map[p.x][p.y])));
                cannotGoThrough.put(toLowerCase(map[p.x][p.y]),new HashSet<>());
            }
            bfs.add(new Pos(p));
            return;
        }

        if(Character.isUpperCase(map[p.x][p.y])){
                if(keys.contains(toLowerCase(map[p.x][p.y]))){
                    bfs.add(new Pos(p));
                    return;
                }
                addkeyToMap(cannotGoThrough, map[p.x][p.y]);
                cannotGoThrough.get(toLowerCase(map[p.x][p.y])).add(new Pos(p));
        }

        return;
    }

    static void addkeyToMap(HashMap<Character, HashSet<Pos>> cannotGoThrough, char c){
        if (cannotGoThrough.containsKey(toLowerCase(c)))return;
        cannotGoThrough.put(toLowerCase(c), new HashSet<>());
    }

    static class Pos implements Comparable<Pos>{
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public Pos(Pos p){
            this.x = p.x;
            this.y = p.y;
        }

        public int compareTo(Pos o){
            if(this.x != o.x){
                return Integer.compare(this.x, o.x);
            }
            if(this.y != o.y){
                return Integer.compare(this.y, o.y);
            }
            return 0;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}