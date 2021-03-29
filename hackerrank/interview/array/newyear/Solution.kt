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
		// �Ÿ��� ���� ��ġ���� �ڿ� �ִ� ���� �տ��� ��ܼ� �ڷ� �з��� ���̹Ƿ� �������
		// ���� ��ġ���� �տ� ��ġ�ϴµ� �� ������ 3 �̻��� ���� ���� ��ġ���� �� �̵��� ������ �� �� ����
		// (�ڷ� ���� ��� = �� ���ڰ� ������ ���� ���� �ٲ㼭 �ڷ� ������)
		// (������ ���� ��� = �ڿ��� ������ ���� ������ ������ ������ ��)
		
		// ��Ģ: ������� ���� �� �ڽź��� �� ���� ���ڰ� �ڿ� �ִ� �� ��ŭ�� ���ϸ� ��
		// �� �߿� ���� ��ġ���� 3 �̻� ������ ���� ������ Too chaotic
		
		var count = 0
		for(i in 0..q.size-1) {
			// ���� ��ġ�� ���� ���� ��ġ ���̶� �󸶳� �ָ� �������ִ��� Ȯ��
			if(q[i] - (i + 1) > 2) {
				println("Too chaotic")
				return
			}
			
			// 0�� q[i]-2 ���̿� �ִ밪�� �������� �˻�: q[i]-2�� 0���� ũ�� �� ���� ���� �˻��� �ʿ�� ����
			// q[i]���� ū ���� �ִٸ� - i-1������ index �̳����� �� ū ���� �տ� ���� (�̹� ���� ��������� �տ��� �˻������� ��������)
			for(j in Math.max(0, q[i]-2)..i-1) {
				if(q[j] > q[i]) {
			// �� ó���� �����ߴ���... �ڸ� �˻��ؼ� ó���ؾ� �� ���� �� ����
			// �̷��� �ϸ� 6~9�� �׽�Ʈ ���̽��� Ÿ�Ӿƿ��� �ɸ�
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