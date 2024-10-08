class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[][] network = computers;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(network[i][j] == 1){
                    network = dfs(network, i,j);
                    answer++;
                }
            }
        }
        return answer;
    }
    
    int[][] dfs(int[][] map,  int x, int y){
        
        int pre = x;
        int now = y;
        map[x][y] = 3;
        map[y][x] = 3;
        
        for(int k=0; k<map.length; k++){
            if(map[now][k] == 1){
                dfs(map, now, k);
            }
        }
        
        return map;
    }
}