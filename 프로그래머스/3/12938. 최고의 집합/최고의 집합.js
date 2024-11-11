function solution(n, s) {
    if(s < n)return [-1];
    let a = Math.floor(s/n);
    
    let arr = [];
    for(let i=0; i< n ; i++){
        arr.push(a);
    }
    let d = s - n*a;
    let idx = arr.length -1;

    while(d > 0){
        arr[idx--]++;
        d--
    }
    
    // console.log(arr)
    
    return arr;
}