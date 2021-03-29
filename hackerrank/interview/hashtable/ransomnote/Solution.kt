package com.hackerrank.interview.hashtable.ransomnote

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
	// Complete the checkMagazine function below.
	fun checkMagazine(magazine: Array<String>, note: Array<String>): Unit {
		// note�� ��ȸ�ϸ鼭 magazine�� ����ִ��� Ȯ��, case sensitive�̹Ƿ� �׳��ص� ��
		var hash = HashMap<String, Int>()
		for(m in magazine) {
			if(hash.containsKey(m)) {
				hash.set(m, hash[m]!!.plus(1))
			}
			else {
				hash.set(m, 1)
			}
		}
		
		var isOk = true
		for(n in note) {
			if(hash.containsKey(n)) {
				// ���� �ܾ� �߽߰� ����
				if(hash[n]!! > 1)
					hash.set(n, hash[n]!!-1)
				else if(hash[n]!! == 1)
					hash.remove(n)
			}
			else {
				isOk = false
				break
			}
		}
		
		if(isOk) print("Yes")
		else print("No")
	}
	
	@JvmStatic
	fun main(args: Array<String>) {
	    //val scan = Scanner(System.`in`)
	
	    //val mn = scan.nextLine().split(" ")
	
	    val m = 4//mn[0].trim().toInt()
	
	    val n = 5//mn[1].trim().toInt()
	
	    val magazine = "ab ab ab ab".split(" ").toTypedArray()
	
	    val note = "ab ab ab ab ab".split(" ").toTypedArray()
	
	    checkMagazine(magazine, note)
	}
}