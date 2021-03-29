package com.hackerrank.interview.prepare.sock

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
	// Complete the sockMerchant function below.
	fun sockMerchant(n: Int, ar: Array<Int>): Int {
	    var numOfSocks = arrayListOf<Int>()
		var list = arrayListOf<Int>()
		list.addAll(ar)
	    Collections.sort(list)
	    
	    var current = list[0]
	    var idx:Int = 0
	    for(i in 0..n-1) {
	        if(current == list[i]) idx++
	        else {
	            numOfSocks.add(idx/2)
	            current = list[i]
				idx = 1
	        }
	    }
		numOfSocks.add(idx/2)
	
	    return numOfSocks.sum()
	}
	
	@JvmStatic
	fun main(args: Array<String>) {
	    val n = 100
	
	    val ar = "50 49 38 49 78 36 25 96 10 67 78 58 98 8 53 1 4 7 29 6 59 93 74 3 67 47 12 85 84 40 81 85 89 70 33 66 6 9 13 67 75 42 24 73 49 28 25 5 86 53 10 44 45 35 47 11 81 10 47 16 49 79 52 89 100 36 6 57 96 18 23 71 11 99 95 12 78 19 16 64 23 77 7 19 11 5 81 43 14 27 11 63 57 62 3 56 50 9 13 45".split(" ").map{ it.trim().toInt() }.toTypedArray()
	
	    val result = sockMerchant(n, ar)
	
	    println(result)
	}
}