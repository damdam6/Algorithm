function solution(n) {
    var answer = [];
    for (let i = 0; i < n; i++) {
        answer.push(new Array(n).fill(0)); 
    }
    var x = 0;
    var y = -1;
    var idx = 3;

    var num = 1;
    while(num <= n*n){
         var nx = x + dx[idx];
         var ny = y + dy[idx];
        if(nx < 0 || nx >= n || ny < 0 || ny >= n || answer[nx][ny] !== 0){
        idx = (idx+1)%4;
            continue;
        }
        answer[nx][ny] = num;
        x = nx;
        y = ny;
        num += 1;
    }
    
    return answer;
}
var N;
const dx = [1,0,-1,0];
const dy = [0,-1,0,1];
