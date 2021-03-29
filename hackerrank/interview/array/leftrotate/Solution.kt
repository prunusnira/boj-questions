package com.hackerrank.interview.array.leftrotate

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
	// Complete the rotLeft function below.
	fun rotLeft(a: Array<Int>, d: Int, n: Int): Array<Int> {
		var rotation = d%n
		var startpos = rotation
		// 알고리즘 문제에서는 연산 횟수를 최대한 줄이는 것이 중요하다
		
		var arr = arrayListOf<Int>()
		
		for(i in 0..n-1) {
			if(startpos == n) startpos = 0
			arr.add(a[startpos])
			startpos++
		}
		
		return arr.toTypedArray()
	}
	
	@JvmStatic
	fun main(args: Array<String>) {
	    val n = 5
	
	    val d = 4
	
	    val a = "1 2 3 4 5".split(" ").map{ it.trim().toInt() }.toTypedArray()
	
	    val result = rotLeft(a, d, n)
	
	    println(result.joinToString(" "))
	}
}