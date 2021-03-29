import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.collections.ArrayList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map(String::toInt)
    val list = ArrayList<Int>()
    for(i in 1..n) {
        list.add(i)
    }

    generateArr(ArrayList<Int>(), m, n)

    bw.flush()
    bw.close()
    br.close()
}

fun generateArr(list: ArrayList<Int>, left: Int, n: Int) {
    if(left == 0) {
        for(i in list)
            print("$i ")
        println()
    }
    else {
        for(i in 1..n) {
            if(!list.contains(i)) {
                val new = ArrayList<Int>()
                new.addAll(list)
                new.add(i)
                generateArr(new, left-1, n)
            }
        }
    }
}