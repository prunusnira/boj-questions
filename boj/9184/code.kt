val memo = Array(21) {
    _ -> Array(21) {
        _ -> Array(21) {
            _ -> 0
        }
    }
}

fun main() {
    memo[0][0][0] = 1

    while(true) {
        val n = readLine()!!.split(" ").map(String::toInt)
        if(n[0] == -1 && n[1] == -1 && n[2] == -1) break;
        println("w("+n[0]+", "+n[1]+", "+n[2]+") = "+w(n[0], n[1], n[2]));
    }
}

fun w(a: Int, b: Int, c: Int): Int {
    if(a <= 0 || b <= 0 || c <= 0) {
        return 1;
    }
    else if(a > 20 || b > 20 || c > 20) {
        return w(20, 20, 20);
    }
    else if(memo[a][b][c] != 1 && memo[a][b][c] != 0) {
        return memo[a][b][c];
    }
    else if(a < b && b < c) {
        memo[a][b][c] = w(a, b, c-1) + w(a, b-1, b-1) - w(a, b-1, c);
        return memo[a][b][c];
    }
    else { // a >= b || b >= c
        memo[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        return memo[a][b][c];
    }
}