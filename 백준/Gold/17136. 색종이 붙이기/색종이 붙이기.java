

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] base = new int[10][10];

        int totalColorCount = 0;
        TreeSet<Pos> posSet = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 10; j++) {
                base[i][j] = Integer.parseInt(st.nextToken());
                if(base[i][j] == 1){
                    posSet.add(new Pos(i,j));
                }
            }
        }

        int idxOfPaperPos = 1;
        int minPaper = Integer.MAX_VALUE;

        PriorityQueue<CurrentColor> pqu = new PriorityQueue<>();
        CurrentColor c = new CurrentColor();
        if(posSet.isEmpty()){
            System.out.println("0");
            return;
        }
        c.p = posSet.first();
        pqu.add(c);

        while (!pqu.isEmpty()){
            CurrentColor tmp = pqu.poll();
//            System.out.println(minPaper);
//            System.out.println(tmp);

            if(tmp.keys.size() >= minPaper)continue;

            if(tmp.p.x == 10 && tmp.p.y == 10){
                minPaper = Math.min(minPaper, tmp.keys.size());
                continue;
            }

            for (int i = 5; i >= 1; i--) {
                if(tmp.papers[i-1] >=5)continue;
                TreeSet<Pos> coverSet = cover(i, tmp.p, posSet, tmp.nowBase);
                if(coverSet.isEmpty())continue;

                CurrentColor newC = new CurrentColor(tmp);
                for (Pos p: coverSet){
                    newC.nowBase[p.x][p.y] = idxOfPaperPos;
                }
                newC.keys.add(idxOfPaperPos++);
                newC.p = getNextPos(newC,  posSet);
                newC.papers[i-1]++;
                if(newC.p.x == 10 && newC.p.y == 10){
                    minPaper = Math.min(minPaper, newC.keys.size());
                    continue;
                }
                pqu.add(newC);
            }

        }
        if(minPaper == Integer.MAX_VALUE){
            minPaper = -1;
        }

        System.out.println(minPaper);

    }
    static Pos getNextPos(CurrentColor newC, TreeSet<Pos> posSet){
        Pos getP = posSet.higher(newC.p);
        Pos newP = new Pos(10,10);
        if(getP == null){
            return newP;
        }
        newP = getP;

        while(newP != null && newC.nowBase[newP.x][newP.y] != 0){
            newP = posSet.higher(newP);
        }

        if(newP == null){
           newP = new Pos(10,10);
        }


        return newP;

    }

    static TreeSet<Pos> cover(int size, Pos startP, TreeSet<Pos> posSet, int[][] nowBase) {
        TreeSet<Pos> set = new TreeSet<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Pos pos = new Pos(startP.x + i, startP.y + j);
                if(pos.x < 0 || pos.y < 0 || pos.x >= 10 || pos.y >= 10 || nowBase[pos.x][pos.y] != 0){
                    return new TreeSet<>();
                }
                if (!posSet.contains(pos)) {
                    return new TreeSet<>(); // 빈 집합 반환
                }
                set.add(pos);
            }
        }
        return set;
    }


    static class CurrentColor implements Comparable<CurrentColor>{
        int[][] nowBase;
        TreeSet<Integer> keys;
        Pos p;
        int[] papers;

        public CurrentColor() {
            this.nowBase = new int[10][10];
            this.keys = new TreeSet<>();
            this.p = new Pos(0,0);
            this.papers = new int[5];
        }
        public CurrentColor(CurrentColor c){
            this.nowBase = new int[10][10];
            for (int i = 0; i < 10; i++) {
                this.nowBase[i] = c.nowBase[i].clone();
            }
            this.keys = new TreeSet<>(c.keys);
            this.p = new Pos(c.p);
            this.papers = c.papers.clone();
        }
        @Override
        public int compareTo(CurrentColor o) {
            int positionComparison = this.p.compareTo(o.p);
            if (positionComparison != 0) {
                // 위치 비교에서 음수를 반환해 순서를 역순으로 변경
                return -positionComparison;
            }
            // 위치가 동일할 경우, 사용한 색종이 수가 적은 순으로 정렬
            return Integer.compare(this.keys.size(), o.keys.size());
        }

        @Override
        public String toString() {
            return "CurrentColor{" +
//                    "nowBase=" + Arrays.deepToString(nowBase) +
                    ", keys=" + keys +
                    ", p=" + p +
                    ", paper="+ Arrays.toString(papers)+
                    '}';
        }
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
            if(this.x != o.x)return Integer.compare(this.x, o.x);
            return Integer.compare(this.y, o.y);
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
