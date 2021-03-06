package com.hackerrank.linkedlist.reverse

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

class SinglyLinkedListNode(nodeData: Int) {
    public var data: Int
    public var next: SinglyLinkedListNode?

    init {
        data = nodeData
        next = null
    }
}

class SinglyLinkedList {
    public var head: SinglyLinkedListNode?
    public var tail: SinglyLinkedListNode?

    init {
        head = null
        tail = null
    }

    public fun insertNode(nodeData: Int) {
        var node = SinglyLinkedListNode(nodeData)

        if (head == null) {
            head = node
        } else {
            tail?.next = node
        }

        tail = node
    }

}

object Solution {
	fun printSinglyLinkedList(head: SinglyLinkedListNode?, sep: String) {
	    var node = head;
	
	    while (node != null) {
	        print(node?.data)
	        node = node?.next
	
	        if (node != null) {
	            print(sep)
	        }
	    }
	}
	
	// Complete the reverse function below.
	
	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode {
	 *     data: Int
	 *     next: SinglyLinkedListNode
	 * }
	 *
	 */
	fun reverse(head: SinglyLinkedListNode?): SinglyLinkedListNode? {
	    var prev:SinglyLinkedListNode? = null
		var next:SinglyLinkedListNode? = null
		var current = head
		while(current != null) {
			next = current.next
			current.next = prev
			prev = current
			current = next
	    }
		
		return prev
	}
	
	@JvmStatic
	fun main(args: Array<String>) {
	    val scan = Scanner(System.`in`)
	
	    val tests = 1
	
	    for (testsItr in 1..tests) {
	        val llistCount = 30
	        val llist = SinglyLinkedList()
	
	        for (i in 0 until llistCount) {
	            val llist_item = scan.nextLine().trim().toInt()
	            llist.insertNode(llist_item)
	        }
	
	        val llist1 = reverse(llist?.head)
	
	        printSinglyLinkedList(llist1, " ")
	    }
	}
}