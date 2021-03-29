function arrayManipulation(n, queries) {
    const arr = new Array(n+1).fill(0);
    
    queries.forEach(qarr => {
        const s = qarr[0];
        const e = qarr[1];
        const v = qarr[2];
        arr[s-1] += v;
        arr[e] -= v;
    });
    
    let max = 0;
    let sum = 0;
    
    arr.map(v => {
        sum += v;
        if(max < sum) max = sum;
    });
    
    return max;
}