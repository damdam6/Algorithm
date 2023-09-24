

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static int N, M;
    public static int [][] map ;
    public static int [][] visited;
    public static int [] dr = {0,0,-1,1};
    public static int [] dc = {1,-1,0,0};
    
    
    private static class Node{
        int r, c;

        public Node(int r, int c) {
            super();
            this.r = r;
            this.c = c;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        map = new int [M][N];
        visited = new int [M][N];
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                
                //여기!
                //처음 초기값을 -1로 해준다. 경우의 수가 마이너스인 경우는 없으니까.
                visited[i][j] = -1;
            }
        }//map 입력
        
        //답이 0이 나오는 케이스를 없애기 위해 최초의 케이스를 1로 지정해둔다.
        visited[M-1][N-1] = 1;
        
        dfs(new Node(0,0));
        
        System.out.println(visited[0][0]);
        
    }//main
    
    public static int dfs(Node node) {
        //visited[node.r][node.c] ==0이면 무조건 방문하지 않은 것이 맞나?
        //아님. 더 큰 숫자일 경우 갈 수 있는 경우가 없을 수도 있음. 무조건 방문X는 아님.
        //위에서 visited[i][j] = -1 로 지정해준다. (무한루프 막기) => 재방문 케이스 없애기 가능
        if(visited[node.r][node.c] > -1) {
            return visited[node.r][node.c];
        }
        
        //초기값이 -1이었으니 경우의 수를 더하기 전에 0으로 다시 처리 해준다.
        visited[node.r][node.c] =0;
    
        
        for(int d=0; d<4; d++) {
            int nr = node.r + dr[d];
            int nc = node.c + dc[d];
            
            if (nr >= 0 && nr < M && nc >= 0 && nc < N && map[node.r][node.c] > map[nr][nc]) {
                visited[node.r][node.c] += dfs(new Node(nr, nc));
            }
            
                
//            if(map[node.r][node.c] > map[nr][nc]) {
//                visited[node.r][node.c] += dfs(new Node(nr, nc));
//            }
        
        }
        return visited[node.r][node.c];
        
        
    }//dfs
        
        
}//class


