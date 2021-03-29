package com.hackerrank.interview.array.manipulation

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
	// Complete the arrayManipulation function below.
	fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
		// �ִ��� ��ġ�� ���� ���� ã�´�
		var sum = Array<Long>(n, {i->0})
		
		// TRIAL 2
		// ���� ����� ���غ������� ���� ����
		/*var min = -1
		var max = -1
		for(q in queries) {
			if(min == -1) min = q[0]
			if(max == -1) max = q[1]
			
			if(q[0] < min) min = q[0]
			if(q[1] > max) max = q[1]
		}*/
		
		// TRIAL 1
		// ������ �� �� �غ���
		/*for(q in queries) {
			for(i in min..max-1) {
				if(i >= q[0] && i <= q[1])
					sum[i] += q[2].toLong()
			}
		}*/
		
		// TRIAL 3
		var total = 0L
		for(q in queries) {
			total += q[2].toLong()
		}
		
		//if()
		
		return sum.max()!!
	}
	
	fun main(args: Array<String>) {
	    val scan = Scanner(System.`in`)
	
	    val nm = scan.nextLine().split(" ")
	
	    val n = nm[0].trim().toInt()
	
	    val m = nm[1].trim().toInt()
	
	    val queries = Array<Array<Int>>(m, { Array<Int>(3, { 0 }) })
	
	    for (i in 0 until m) {
	        queries[i] = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
	    }
	
	    val result = arrayManipulation(n, queries)
	
	    println(result)
	}
}