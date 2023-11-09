function solution(dots) {
    var answer = 0;
    
    var g1x = 0;
    var g1y = 0;
    var g2x = 0;
    var g2y = 0;
    
    const arr = [];
    for(let i = 1; i<4;i++){
        arr.push(new Array(4).fill(0));
        arr[i-1][0] = 1;
        arr[i-1][i] = 1;
    }
    
    arr.forEach((subArr) =>{
        
        for(let i = 0 ; i < 4; i++){
            if(subArr[i] == 1){
                
                if(g1x == 0){
                    g1x += dots[i][0];
                    g1y += dots[i][1];
                }else{
                    g1x -= dots[i][0];
                    g1y -= dots[i][1];
                }
                
            }else{
                if(g2x == 0){
                    g2x += dots[i][0];
                    g2y += dots[i][1];
                }else{
                    g2x -= dots[i][0];
                    g2y -= dots[i][1];
                }
                
            }
        if((g1x / g1y) === (g2x / g2y) ){
                answer = 1;
                break;
            }else if( (g1x / g1y) === (g2x / g2y)*(-1)){
                answer = 1;
                break;
        }
        }
        
    })
    
    return answer;
}