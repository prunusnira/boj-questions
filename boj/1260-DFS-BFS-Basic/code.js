// 답은 이게 맞는데...
// BOJ에서 입력 처리를 어떻게 해야할지 모르겠다
const fs = require('fs');
const inp = fs.readFileSync('/dev/stdin').toString().split('\n');

const tree = {};

let n = 0;
let m = 0;
let v = 0;

inp.map((v, i) => {
    const line = v.split(' ');
    if(i != 0) {
        const from = parseInt(line[0]);
        const to = parseInt(line[1]);

        if(tree[from] == undefined) {
            tree[from] = [];
        }
        tree[from].push(to);

        if(tree[to] == undefined) {
            tree[to] = [];
        }
        tree[to].push(from);
    }
    else {
        n = line[0];
        m = line[1];
        v = line[2];
    }
});

// tree 소트 수행
Object.keys(tree).map(v => {
    tree[v].sort();
});

const printVisits = (visits) => {
    let print = "";
    visits.map((v, i) => {
        print += v;
        if(i < visits.length - 1) {
            print += ' ';
        }
    });
    console.log(print);
}

const dfsvisit = [];
DFS = (node) => {
    dfsvisit.push(node);
    const nextnodes = tree[node];
    
    if(nextnodes != undefined) {
        nextnodes.map(v => {
            if(!dfsvisit.includes(v)) {
                DFS(v);
            }
        });
    }
}
DFS(v);
printVisits(dfsvisit);

const bfsvisit = [];
const bfsqueue = [];
BFS = (node) => {
    bfsqueue.push(node);

    while(bfsqueue.length > 0) {
        const next = bfsqueue.shift();

        if(bfsvisit.includes(next)) {
            continue;
        }
        bfsvisit.push(next);

        const nextnodes = tree[next];
        // 이미 방문한 노드가 아니면 queue에 다 집어넣음
        if(nextnodes != undefined) {
            nextnodes.map(v => {
                if(!bfsvisit.includes(v)) {
                    bfsqueue.push(v);
                }
            });
        }
    }
}
BFS(v);
printVisits(bfsvisit);