package com.hackerrank.impl.birdmigration

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
	// Complete the migratoryBirds function below.
	fun migratoryBirds(arr: Array<Int>): Int {
		var cnt = Array<Int>(5, {0})
	    for(i in arr) {
			cnt[i-1] += 1
		}
	
	    var max = cnt[0]
	    var idx = 1
	    for(i in 1..4) {
	        if(cnt[i] > max) {
	            max = cnt[i]
	            idx = i+1
	        }
	    }
	    return idx
	}
	
	@JvmStatic
	fun main(args: Array<String>) {
	    val arrCount = readLine()!!.trim().toInt()
	
	    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
	
	    val result = migratoryBirds(arr)
	
	    println(result)
	}

}