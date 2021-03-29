package com.hackerrank.interview.array.hourglass

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
	// Complete the hourglassSum function below.
	fun hourglassSum(arr: Array<Array<Int>>): Int {
		// 16가지의 모래시계 형태를 뽑아내어 계산하기
		var sum = Array<Int>(16, {i->0})
		
		var idx = 0
		for(i in 0..3) {
			for(j in 0..3) {
				sum[idx] = arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]+arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2]
				idx++
			}
		}
		
		return sum.max()!!
	}
	
	@JvmStatic
	fun main(args: Array<String>) {
	    var arr = arrayOf(arrayOf(1, 1, 1, 0, 0, 0),
						  arrayOf(0, 1, 0, 0, 0, 0),
						  arrayOf(1, 1, 1, 0, 0, 0),
						  arrayOf(0, 0, 2, 4, 4, 0),
						  arrayOf(0, 0, 0, 2, 0, 0),
						  arrayOf(0, 0, 1, 2, 4, 0))
	
	    //val arr = Array<Array<Int>>(6, { Array<Int>(6, { 0 }) })
	
	    /*for (i in 0 until 6) {
	        arr[i] = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
	    }*/
	
	    val result = hourglassSum(arr)
	
	    println(result)
	}
}