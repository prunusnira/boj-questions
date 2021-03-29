package com.hackerrank.interview.array.newyear

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
	// Complete the minimumBribes function below.
	fun minimumBribes(q: Array<Int>): Unit {
		// 거리가 현재 위치에서 뒤에 있는 경우는 앞에서 당겨서 뒤로 밀려난 것이므로 상관없음
		// 본래 위치보다 앞에 위치하는데 그 범위가 3 이상인 경우는 현재 위치보다 더 이동한 것임을 알 수 있음
		// (뒤로 가는 경우 = 뒷 숫자가 앞으로 가기 위해 바꿔서 뒤로 가진것)
		// (앞으로 가는 경우 = 뒤에서 앞으로 갔기 때문에 앞으로 가지는 것)
		
		// 규칙: 순서대로 읽을 때 자신보다 더 낮은 숫자가 뒤에 있는 수 만큼을 더하면 됨
		// 그 중에 본래 위치보다 3 이상 떨어진 것이 있으면 Too chaotic
		
		var count = 0
		for(i in 0..q.size-1) {
			// 현재 위치의 값이 본래 위치 값이랑 얼마나 멀리 떨어져있는지 확인
			if(q[i] - (i + 1) > 2) {
				println("Too chaotic")
				return
			}
			
			// 0과 q[i]-2 사이에 최대값을 시작으로 검사: q[i]-2가 0보다 크면 그 이하 값을 검사할 필요는 없음
			// q[i]보다 큰 값이 있다면 - i-1까지의 index 이내에서 더 큰 값이 앞에 있음 (이미 범위 벗어나는지는 앞에서 검사했으니 문제없음)
			for(j in Math.max(0, q[i]-2)..i-1) {
				if(q[j] > q[i]) {
			// 맨 처음에 생각했던것... 뒤를 검사해서 처리해야 할 양이 더 많음
			// 이렇게 하면 6~9번 테스트 케이스가 타임아웃이 걸림
			/*for(j in i+1..q.size-1) {
				if(q[i] > q[j]) {*/
					count++
				}
			}
		}
		println(count)
		return
	}
	
	@JvmStatic
	fun main(args: Array<String>) {
		val t = 1
	
	    for (tItr in 1..t) {
	        val n = 8
	
	        val q = "1 2 5 3 7 8 6 4".split(" ").map{ it.trim().toInt() }.toTypedArray()
	
	        minimumBribes(q)
	    }
	}
}