package com.hackerrank.arrays.dynamic

import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

object Solution {
	/*
	 * Complete the 'dynamicArray' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY.
	 * The function accepts following parameters:
	 *  1. INTEGER n
	 *  2. 2D_INTEGER_ARRAY queries
	 */
	
	fun dynamicArray(n: Int, queries: Array<Array<Int>>) {//: Array<Int> {
	    // Write your code here
		var seqList = Array<ArrayList<Int>>(n, {arrayListOf<Int>()})
		var lastAnswer = 0
		
		for(q in queries) {
			if(q[0] == 1) {
				seqList[(q[1] xor lastAnswer) % n].add(q[2])
			}
			else if(q[0] == 2) {
				val seq = (q[1] xor lastAnswer) % n
				lastAnswer = seqList[seq][q[2] % seqList[seq].size]
				println(lastAnswer)
			}
		}
	}
	
	@JvmStatic
	fun main(args: Array<String>) {
	    /*val first_multiple_input = readLine()!!.trimEnd().split(" ")
	
	    val n = first_multiple_input[0].toInt()
	
	    val q = first_multiple_input[1].toInt()*/
		
		val n = 2
		val q = 5
		
	    val queries = Array<Array<Int>>(q, { Array<Int>(3, { 0 }) })
	    
		queries[0] = "1 0 5".split(" ").map{ it.toInt() }.toTypedArray()
		queries[1] = "1 1 7".split(" ").map{ it.toInt() }.toTypedArray()
		queries[2] = "1 0 3".split(" ").map{ it.toInt() }.toTypedArray()
		queries[3] = "2 1 0".split(" ").map{ it.toInt() }.toTypedArray()
		queries[4] = "2 1 1".split(" ").map{ it.toInt() }.toTypedArray()
		
	    /*for (i in 0 until q) {
	        queries[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
	    }*/
	
	    /*val result = */dynamicArray(n, queries)
	
	    //println(result.joinToString("\n"))
	}
}