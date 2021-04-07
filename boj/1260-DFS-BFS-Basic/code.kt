import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

val tree = HashMap<Int, SortedSet<Int>>()
var dfsvisit = ArrayList<Int>()
var bfsvisit = ArrayList<Int>()
var bfsqueue = LinkedList<Int>()

fun main() {
    val nmv = readLine()!!.split(' ').map(String::toInt)

    val n = nmv[0]
    val m = nmv[1]
    val v = nmv[2]

    for(i in 0 until m) {
        val fromTo = readLine()!!.split(' ').map(String::toInt)

        val from = fromTo[0]
        val to = fromTo[1]

        if(tree.containsKey(from)) {
            tree[from]!!.add(to)
        }
        else {
            tree[from] = TreeSet<Int>()
            tree[from]!!.add(to)
        }

        if(tree.containsKey(to)) {
            tree[to]!!.add(from)
        }
        else {
            tree[to] = TreeSet<Int>()
            tree[to]!!.add(from)
        }
    }

    DFS(v)
    printVisits(dfsvisit)

    BFS(v)
    printVisits(bfsvisit)
}

fun printVisits(visits: ArrayList<Int>) {
    var print = ""
    for(x in visits.indices) {
        print += visits[x].toString()
        if(x < visits.size-1) print += " "
    }
    println(print);
}

fun DFS(node: Int) {
    dfsvisit.add(node);

    if(tree.containsKey(node)) {
        val nextnodes = tree[node]
        for(x in nextnodes!!) {
            if(!dfsvisit.contains(x)) {
                DFS(x)
            }
        }
    }
}

fun BFS(node: Int) {
    bfsqueue.add(node);

    while(bfsqueue.size > 0) {
        val next = bfsqueue.poll()

        if(bfsvisit.contains(next)) {
            continue
        }
        bfsvisit.add(next)

        if(tree.containsKey(next)) {
            val nextnodes = tree[next]!!
            // 이미 방문한 노드가 아니면 queue에 다 집어넣음
            for(x in nextnodes) {
                if(!bfsvisit.contains(x)) {
                    bfsqueue.add(x)
                }
            }
        }
    }
}