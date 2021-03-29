package com.hackerrank.interview.prepare.cloud

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
	// Complete the jumpingOnClouds function below.
	fun jumpingOnClouds(c: Array<Int>): Int {
	    var idx = 0
	    var jump = 0
	    var finish = false
	    while(!finish) {
	        if(idx == c.size-1) {
				finish = true
	            break
	        }
	        else {
	            if(idx+2 < c.size && c[idx+2] == 0) {
	                // 2Ä­ Á¡ÇÁ
	                idx = idx+2
	                jump++
	            }
	            else if(c[idx+1] == 0) {
	                idx++
	                jump++
	            }
	        }
	    }
	    return jump
	}
	
	@JvmStatic
	fun main(args: Array<String>) {
	    val n = 7
	
	    val c = "0 0 1 0 0 1 0".split(" ").map{ it.trim().toInt() }.toTypedArray()
	
	    val result = jumpingOnClouds(c)
	
	    println(result)
	}
}