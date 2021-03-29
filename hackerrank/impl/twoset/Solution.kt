package com.hackerrank.impl.twoset

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
	 * Complete the 'getTotalX' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 *  1. INTEGER_ARRAY a
	 *  2. INTEGER_ARRAY b
	 */
	
	fun getTotalX(a: Array<Int>, b: Array<Int>): Int {
	    var factors = Array<HashMap<Int, Int>>(a.size, {HashMap<Int, Int>()})
		
		// 각 숫자 인수분해
		for(i in 0..a.size-1) {
			getFactorize(a[i], factors[i])
		}
		
		// 최소공배수 구하기
		var lcm = HashMap<Int, Int>()
		for(f in factors) {
			var keys = f.keys
			for(k in keys) {
				if(lcm.containsKey(k)) {
					if(f[k]!! > lcm[k]!!) {
						lcm[k] = f[k]!!
					}
				}
				else {
					lcm.put(k, f[k]!!)
				}
			}
		}
		
		var lcmval = 1
		var lcmkey = lcm.keys
		for(k in lcmkey) {
			for(i in 0..lcm[k]!!-1)
				lcmval *= k
		}
		
		// a의 공배수 중 b로 나눠지는 모든 값 찾기
		// 일단은 모든 b의 원소가 lcm값으로 나누어져야 하며 그 값의 lcm의 지수 개수 합이 정답
		// b의 최대공약수에서 lcm을 나눈 뒤 인수분해하여 그 인수로 구함
		var dvFactors = Array<HashMap<Int, Int>>(b.size, {HashMap<Int, Int>()})
		var available = true
		for(i in 0..b.size-1) {
			if(b[i] % lcmval == 0) {
				getFactorize(b[i], dvFactors[i]) 
			}
			else {
				available = false
			}
		}
		
		var removeCandidate = mutableSetOf<Int>()
		// 최대공약수 구하기
		if(available) {
			var dvGcm = HashMap<Int, Int>()
			for(f in dvFactors) {
				// 비어있으면 일단 다 넣음
				if(dvGcm.isEmpty()) {
					dvGcm.putAll(f);
				}
				else {
					var dkey = dvGcm.keys
					var keys = f.keys
					for(k in keys) {
						if(dvGcm.containsKey(k)) {
							if(f[k]!! < dvGcm[k]!!) {
								dvGcm[k] = f[k]!!
							}
						}
					}
					for(k in dkey) {
						if(!keys.contains(k)) {
							removeCandidate.add(k)
						}
					}
				}
			}
			
			for(i in removeCandidate) {
				dvGcm.remove(i)
			}
			
			// 최대공약수를 lcm으로 나눈 뒤 인수계산
			
			for(k in dvGcm.keys) {
				if(lcm.containsKey(k))
					dvGcm[k] = dvGcm[k]!! - lcm[k]!!
			}
			
			var rst = 1
			for(i in dvGcm.values) {
				rst *= (i+1)
			}
			return rst
		}
		else return 0
	}
	
	fun getFactorize(number: Int, factor:HashMap<Int, Int>) {
		for(i in 2..number) {
			if(number % i == 0) {
				if(factor.containsKey(i)) {
					factor.put(i, factor[i]!!.plus(1))
				}
				else {
					factor.put(i, 1)
				}
				getFactorize(number / i, factor)
				break
			}
		}
	}
	
	@JvmStatic
	fun main(args: Array<String>) {
	    val first_multiple_input = readLine()!!.trimEnd().split(" ")
	
	    val n = first_multiple_input[0].toInt()
	
	    val m = first_multiple_input[1].toInt()
	
	    val arr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
	
	    val brr = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
	
	    val total = getTotalX(arr, brr)
	
	    println(total)
	}
}