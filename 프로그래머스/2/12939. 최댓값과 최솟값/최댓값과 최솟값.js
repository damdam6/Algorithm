function solution(s) {
    var numbers = s.split(" ");
    var numType = [];
    
    numbers.forEach((n) => {
        numType.push(parseInt(n));
        console.log(n);
    })
    
    numType.sort((a, b) => a - b);
    
    var answer = numType[0]+' '+numType[numType.length - 1];
    return answer;
}