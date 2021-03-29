function arrayManipulation(n, queries) {
    const map = new Map();
    
    queries.forEach(qarr => {
        const start = qarr[0];
        const end = qarr[1];
        const v = qarr[2];
        for(let i = start; i <= end; i++) {
            if(map.has(i)) {
                map.set(i, map.get(i) + v);
            }
            else {
                map.set(i, v);
            }
        }
    });
    
    return Math.max(...map.values());
}