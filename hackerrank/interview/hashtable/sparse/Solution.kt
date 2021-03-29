package com.hackerrank.interview.hashtable.sparse

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
	// Complete the matchingStrings function below.
	fun matchingStrings(strings: Array<String>, queries: Array<String>): Array<Int> {
		val list = arrayListOf<String>()
		val qlist = queries.toList()
		val qleng = Array<Int>(qlist.size, {0})
		
		list.addAll(strings)
		val removal = mutableSetOf<String>()
		
		for(i in 0..qlist.size-1) {
			for(s in list) {
				if(qlist[i].equals(s)) {
					removal.add(s)
					qleng[i]++
				}
			}
			//list.removeAll(removal)
		}
		return qleng
	}
	
	@JvmStatic
	fun main(args: Array<String>) {
	    /*val scan = Scanner(System.`in`)
	
	    val stringsCount = scan.nextLine().trim().toInt()
	
	    val strings = Array<String>(stringsCount, { "" })
	    for (i in 0 until stringsCount) {
	        val stringsItem = scan.nextLine()
	        strings[i] = stringsItem
	    }
	
	    val queriesCount = scan.nextLine().trim().toInt()
	
	    val queries = Array<String>(queriesCount, { "" })
	    for (i in 0 until queriesCount) {
	        val queriesItem = scan.nextLine()
	        queries[i] = queriesItem
	    }*/
		
		val strings = arrayOf<String>(
"lekgdisnsbfdzpqlkg",
"eagemhdygyv",
"jwvwwnrhuai",
"urcadmrwlqe",
"mpgqsvxrijpombyv",
"mpgqsvxrijpombyv",
"urcadmrwlqe",
"mpgqsvxrijpombyv",
"eagemhdygyv",
"eagemhdygyv",
"jwvwwnrhuai",
"urcadmrwlqe",
"jwvwwnrhuai",
"kvugevicpsdf",
"kvugevicpsdf",
"mpgqsvxrijpombyv",
"urcadmrwlqe",
"mpgqsvxrijpombyv",
"exdafbnobg",
			"lekgdisnsbfdzpqlkg",
"eagemhdygyv",
"jwvwwnrhuai",
"urcadmrwlqe",
"mpgqsvxrijpombyv",
"mpgqsvxrijpombyv",
"urcadmrwlqe",
"mpgqsvxrijpombyv",
"eagemhdygyv",
"eagemhdygyv",
"jwvwwnrhuai",
"urcadmrwlqe",
"jwvwwnrhuai",
"kvugevicpsdf",
"kvugevicpsdf",
"mpgqsvxrijpombyv",
"urcadmrwlqe",
"mpgqsvxrijpombyv",
"exdafbnobg",
			"lekgdisnsbfdzpqlkg",
"eagemhdygyv",
"jwvwwnrhuai",
"urcadmrwlqe",
"mpgqsvxrijpombyv",
"mpgqsvxrijpombyv",
"urcadmrwlqe",
"mpgqsvxrijpombyv",
"eagemhdygyv",
"eagemhdygyv",
"jwvwwnrhuai",
"urcadmrwlqe",
"jwvwwnrhuai",
"kvugevicpsdf",
"kvugevicpsdf",
"mpgqsvxrijpombyv",
"urcadmrwlqe",
"mpgqsvxrijpombyv",
"exdafbnobg",
			"lekgdisnsbfdzpqlkg",
"eagemhdygyv",
"jwvwwnrhuai",
"urcadmrwlqe",
"mpgqsvxrijpombyv",
"mpgqsvxrijpombyv",
"urcadmrwlqe",
"mpgqsvxrijpombyv",
"eagemhdygyv",
"eagemhdygyv",
"jwvwwnrhuai",
"urcadmrwlqe",
"jwvwwnrhuai",
"kvugevicpsdf",
"kvugevicpsdf",
"mpgqsvxrijpombyv",
"urcadmrwlqe",
"mpgqsvxrijpombyv",
"exdafbnobg",
			"lekgdisnsbfdzpqlkg",
"eagemhdygyv",
"jwvwwnrhuai",
"urcadmrwlqe",
"mpgqsvxrijpombyv",
"mpgqsvxrijpombyv",
"urcadmrwlqe",
"mpgqsvxrijpombyv",
"eagemhdygyv",
"eagemhdygyv",
"jwvwwnrhuai",
"urcadmrwlqe",
"jwvwwnrhuai",
"kvugevicpsdf",
"kvugevicpsdf",
"mpgqsvxrijpombyv",
"urcadmrwlqe",
"mpgqsvxrijpombyv",
"exdafbnobg"
		)
		val queries = arrayOf<String>(
		"lekgdisnsbfdzpqlkg",
"eagemhdygyv",
"jwvwwnrhuai",
"urcadmrwlqe",
"mpgqsvxrijpombyv",
"mpgqsvxrijpombyv",
"urcadmrwlqe",
"mpgqsvxrijpombyv",
"eagemhdygyv",
"eagemhdygyv",
"jwvwwnrhuai",
"urcadmrwlqe",
"jwvwwnrhuai",
"kvugevicpsdf",
"kvugevicpsdf",
"mpgqsvxrijpombyv",
"urcadmrwlqe",
"mpgqsvxrijpombyv",
"exdafbnobg"
		)
	
	    val res = matchingStrings(strings, queries)
	
	    print(res.joinToString("\n"))
	}
}