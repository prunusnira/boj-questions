import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    val arr = ArrayList<String>()
    for(i in 0 until n) {
        arr.add(br.readLine())
    }

    val result = sort(arr)

    for(s in result) {
        println(s)
    }
    bw.flush()
    bw.close()
    br.close()
}

fun sort(list: ArrayList<String>):ArrayList<String> {
    val nl = ArrayList<String>()
    val map = HashMap<Int, SortedSet<String>>() // 최종 length

    for(s in list) {
        // 1. 길이 판별
        val length = s.length
        if(map.containsKey(length)) {
            map[length]!!.add(s);
        }
        else {
            val newset = TreeSet<String>()
            newset.add(s)
            map[length] = newset
        }
    }

    val sortedKeys = map.keys.sorted()
    for(i in sortedKeys) {
        nl.addAll(map[i]!!.toList())
    }
    return nl
}