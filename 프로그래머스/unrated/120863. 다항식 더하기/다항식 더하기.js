function solution(polynomial) {

    const arr = polynomial.split(" ");
    //console.log(arr);
    
    var x = 0;
    var num = 0;
    
    arr.forEach( (e) => {
        var numX =  parseInt(e.split('x')[0]);
        if(e.includes('x')){
            if(isNaN(numX)){
                x += 1;
            }else{
                x += numX;
            }
            
        }else if(!isNaN(numX)){
            num += numX;
        }
    })
    
     var answer = '';
    if(x !== 0 && num !== 0){
        if(x === 1){
            answer += 'x + '+num;
        }else{
            answer += x+'x + '+num;
        }
        
    }else if(num === 0 ){
            if(x === 1){
            answer += 'x';
        }else{
            answer += x+'x';
        }
    }else if(x === 0){
        answer += num;
    }
   
    return answer;
}