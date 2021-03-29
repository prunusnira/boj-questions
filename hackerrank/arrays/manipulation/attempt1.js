function arrayManipulation(n, queries) {
    const arr = new Array(n).fill(0);
    queries.forEach(qarr => {
        const start = qarr[0];
        const end = qarr[1];
        const v = qarr[2];
        for(let i = start; i < end+1; i++) {
            arr[i-1] += v;
        }
    });
    
    return Math.max(...arr);
}