import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val n = br.readLine().toInt()
    var arr = ArrayList<Int>()
    for(i in 0 until n) {
        arr.add(br.readLine().toInt())
    }

    var l = arr.toList()
    //l = insertionSort(arr)
    //l = bubbleSort(arr)
    l = mergeSort(l)
    //l.sort()

    for(a in l) {
        bw.write(a.toString() + "\n")
    }

    bw.flush()
    br.close()
    bw.close()
}

fun insertionSort(l: ArrayList<Int>): ArrayList<Int> {
    val size = l.size

    for(i in 0 until size) {
        var minPos = i
        var min = l[i]
        for(j in i+1 until size) {
            if(min > l[j]) {
                minPos = j
                min = l[j]
            }
        }
        l.removeAt(minPos)
        l.add(i, min)
    }

    return l
}

fun bubbleSort(l: ArrayList<Int>): ArrayList<Int> {
    val size = l.size

    for(i in 0 until size-1) {
        for(j in 0 until size-1) {
            if(l[j] > l[j+1]){
                val temp = l[j]
                l[j] = l[j+1]
                l[j+1] = temp
            }
        }
    }

    return l
}

fun quickSort(l: List<Int>): List<Int> {
    
}

fun mergeSort(l: List<Int>): List<Int> {
    if(l.size < 2) return l
    val center = l.size / 2
    val left = l.subList(0, center)
    val right = l.subList(center, l.size)
    return merge(mergeSort(left), mergeSort(right))
}

fun merge(left: List<Int>, right: List<Int>): List<Int> {
    val merged = ArrayList<Int>()
    var lidx = 0
    var ridx = 0

    while (lidx < left.size && ridx < right.size) {
        if (left[lidx] > right[ridx]) {
            merged.add(right[ridx])
            ridx++
        } else {
            merged.add(left[lidx])
            lidx++
        }
    }

    if (lidx < left.size) {
        for (i in lidx until left.size)
            merged.add(left[i])
    }
    if (ridx < right.size) {
        for (i in ridx until right.size)
            merged.add(right[i])
    }
    return merged
}