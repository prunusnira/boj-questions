const fs = require('fs');
const inp = fs.readFileSync('/dev/stdin').toString().split('\n');
const array = new Array(21);

function initArr() {
    for(let i = 0; i < 21; i++) {
        array[i] = new Array(21);
        for(let j = 0; j < 21; j++) {
            array[i][j] = new Array(21).fill(0);
        }
    }
    array[0][0][0] = 1;
}

function w(a, b, c) {
    if(array[0][0][0] !== 1) initArr();
    
    if(a <= 0 || b <= 0 || c <= 0) {
        return 1;
    }
    else if(a > 20 || b > 20 || c > 20) {
        return w(20, 20, 20);
    }
    else if(array[a][b][c] !== 1 && array[a][b][c] !== 0) {
        return array[a][b][c];
    }
    else if(a < b && b < c) {
        array[a][b][c] = w(a, b, c-1) + w(a, b-1, b-1) - w(a, b-1, c);
        return array[a][b][c];
    }
    else { // a >= b || b >= c
        array[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        return array[a][b][c];
    }
}

initArr();

for(let s in inp) {
    const params = s.split(' ');
    if(params[0] === -1 && params[1] === -1 && params[2] === -1) break;
    console.log('w('+params[0]+', '+params[1]+', '+params[2]+') = '+w(params[0], params[1], params[2])+'\n');
}