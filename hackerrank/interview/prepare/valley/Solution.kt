package com.hackerrank.interview.prepare.valley

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
	// Complete the countingValleys function below.
	fun countingValleys(n: Int, s: String): Int {
		var level = 0
	    var valley = 0
	    var isInValley = false
	    for(i in 0..s.length-1) {
	        if(s[i] == 'U') {
	            level++
	            if(level == 0 && isInValley) {
	                valley++
	                isInValley = false
	            }
	        }
	        else if(s[i] == 'D') {
	            level--
	            if(level == -1 && !isInValley) {
	                isInValley = true
	            }
	        }
	    }
	    return valley
	}
	
	@JvmStatic
	fun main(args: Array<String>) {
	    val n = 8
	
	    val s = "UDDDUDUU"
	
	    val result = countingValleys(n, s)
	
	    println(result)
	}
}