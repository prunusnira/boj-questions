package com.hackerrank.dynamic.fibomodi

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
import java.lang.StringBuilder

object fibomodi {
	// 값이 64bit의 범위를 넘어갈 수 있어 BigInteger를 사용해야 함
	fun fibonacciModified(t1: Int, t2: Int, n: Int): BigInteger {
		val fibo = Array<BigInteger>(n, {i->BigInteger.ZERO})
		fibo[0] = t1.toBigInteger()
		fibo[1] = t2.toBigInteger()
	    for(i in 2..n-1) {
			fibo[i] = fibo[i-2] + fibo[i-1]*fibo[i-1]
	    }
		return fibo[n-1]
	}
	
	@JvmStatic
	fun main(args: Array<String>) {
	    val t1 = 0
	    val t2 = 1
	    val n = 10
	
	    val result = fibonacciModified(t1, t2, n)
	    println(result)
	}
}