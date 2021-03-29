package com.hackerrank.interview.prepare.repeat

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
	// Complete the repeatedString function below.
	fun repeatedString(s: String, n: Long): Long {
	    var cnt = 0

	    // 1 문장에서 몇개가 있는지 확인
	    for(i in 0..s.length-1) {
	        if(s[i.toInt()] == 'a') cnt++
	    }
	
	    val nums = n/s.length
	    val additional = n%s.length
	
	    var total = cnt*nums
	
	    for(i in 0..additional-1) {
	        if(s[i.toInt()] == 'a') total++
	    }
	
	    return total
	}
	
	@JvmStatic
	fun main(args: Array<String>) {
	    val s = "a"
	
	    val n = 1000000000000
	
	    val result = repeatedString(s, n)
	
	    println(result)
	}
}