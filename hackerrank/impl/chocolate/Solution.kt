package com.hackerrank.impl.chocolate

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
	// Complete the birthday function below.
	fun birthday(s: Array<Int>, d: Int, m: Int): Int {
		var methods = 0
        for(i in 0..s.size-m-1) {
            var sum = 0
            for(j in 0..m-1) {
                sum += s[i+j]
            }
            if(sum == d) methods++
        }
	    return methods
	}
	
	@JvmStatic
	fun main(args: Array<String>) {
	    val n = readLine()!!.trim().toInt()
	
	    val s = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
	
	    val dm = readLine()!!.trimEnd().split(" ")
	
	    val d = dm[0].toInt()
	
	    val m = dm[1].toInt()
	
	    val result = birthday(s, d, m)
	
	    println(result)
	}
}