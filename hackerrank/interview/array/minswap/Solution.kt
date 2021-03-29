package com.hackerrank.interview.array.minswap

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
	// Complete the minimumSwaps function below.
	fun minimumSwaps(arr: Array<Int>): Int {
		// swap �Ǵ��ϱ�
		var cnt = 0
		
		// ������ ������ �����ؾ� �ϴ°�?
		// 1. ���ڸ��� �ִ� ���� ���� �������� ���ؼ�
		// 2. ���� ���� ���� �� ��ġ�� �ִ� ���� �����Ѵ�
		// 3. ���� �� ���� ���� ���¸� üũ�Ѵ�
		// 4. �ݺ�
		
		// TRIAL 1
		/*for(i in 0..arr.size-1) {
			if(i+1 != arr[i]) {
				var temp = arr[arr.indexOf(i+1)]
				arr[arr.indexOf(i+1)] = arr[i]
				arr[i] = temp
				cnt++
			}
		}*/
		// ����� �˾����� timeout�� ���ֺ��� (9, 10, 11, 12, 14)
		
		// TRIAL 2
		// ������ ���ں��� ã�ƺ���...
		/*for(i in 0..arr.size-1) {
			if(arr.indexOf(i+1) != i) {
				var temp = arr[arr.indexOf(i+1)]
				arr[arr.indexOf(i+1)] = arr[i]
				arr[i] = temp
				cnt++
			}
		}*/
		// �̰� �ϴ� 13�� Timeout�� ��
		
		// TRIAL 3
		// ã���� ���ڸ� �ٷιٷ� �ٲٱ�
		/*for(i in 0..arr.size-1) {
			if(arr[i] != i+1) {
				var temp = arr.indexOf(i+1)
				arr[temp] = arr[i]
				arr[i] = i+1
				cnt++
			}
		}*/
		// 10, 11, 12, 14�� timeout�� ��
		
		// TRIAL 4
		// ����� index�� ���󰡼� �ٷ� �����ϱ�
		// ������ 1���� swap�� �Ѵٸ� �ᱹ �� �����ؾ� �ϹǷ� ���󰡸鼭 ���� �ٲٴ°� ������
		/*var visited = arrayListOf<Int>()
		var cidx = 0
		var temp = -1
		while(visited.size < arr.size) {
			if(visited.contains(cidx)) {
				// �̹����� ��ȸ�� �Ϸ��
				if(temp == -1) {
					cidx++
					continue
				}
				else {
					cnt-- // �ּ� 2�ε� �ϳ��� ���ߵ�
					cidx++
					temp = -1
					if(cidx > arr.size-1) break
					else continue	
				}
			}
			else {
				// ���� ��ȸ�� ������ �ʾ���
				if(temp == -1) {
 					// ó���� �ʿ䰡 ���ٸ�
					if(arr[cidx] == cidx+1) {
						visited.add(cidx)
						cidx++
						continue
					}
					// ���ʰ�
					temp = cidx
				}
				// �� �� ����
				visited.add(cidx)
				var prevcidx = cidx
				cidx = arr[cidx] - 1
				arr[prevcidx] = prevcidx + 1
				cnt++
			}
		}
		if(temp != -1) cnt--*/
		// 10~14 timeout
		
		// TRIAL 5
		// �ٸ� �������
		/*var startpos = 0
		var cpos = 0
		var justOneTrial = true
		var passed = Array<Int>(arr.size, {i->0})
		while(passed.contains(0)) {
			if(passed[cpos] == 1) {
				if(startpos == cpos) {
					cpos++
					startpos++
					if(passed[cpos] != 1) cnt--
				}
				else {
					cpos++
				}
			}
			else {
				if(arr[cpos] == cpos+1) {
					passed[cpos] = 1
					cpos++
					startpos++
					justOneTrial = false
				}
				else {
					var next = arr[cpos]
					arr[cpos] = cpos+1
					passed[cpos] = 1
					cpos = next - 1
					cnt++
				}
			}
		}
		if(justOneTrial) cnt--*/
		// Ÿ�Ӿƿ��� ���� �ȸ���
		
		// TRIAL 6 - Answer
		// step 1 : check if each array index is filled is current value .
		// (So, arr[i] ==i+1, since, index start from 0 , so need for increment of 1 as value is from 1 to n).
		// step 2 : for the element not at its actual position.
		// we simply replace the ith element with value at the (arr[i]-1)th position, as index is from 0.
		// and increase the count.
		// And again decreasing the i of loop to check if again the value at ith position is (i+1) or not .
		// (i+1�� �ƴ� i�� ���ϱ� ����)
		var i = 0
		while(i < arr.size) {
			// ���� ��ġ�� �ش��ϴ� ���� ������
			if(arr[i] != i+1) {
				// �� �տ� �ִ� ���� ������ ��ȯ
				var temp = arr[arr[i] - 1]
				arr[arr[i] - 1] = arr[i]
				arr[i] = temp
				cnt++
				i-- // index�� ���� ���� ������ �ٽ� ����
			}
			// ��ġ�ϴ� ���� ������ index ����
			i++
		}
		
		// TRIAL 7 - Another Answer
		for(i in 0..arr.size-1) {
			if(arr[i] != i+1) {
				arr[arr.indexOf(i+1)] = arr[i]
				cnt++
			}
		}
		
		return cnt
	}
	
	@JvmStatic
	fun main(args: Array<String>) {
	    val n = 4
	
	    val arr = "4 3 1 2".split(" ").map{ it.trim().toInt() }.toTypedArray()
		
		//val n = 5
	
	    //val arr = "5 4 3 2 1".split(" ").map{ it.trim().toInt() }.toTypedArray()
		
		//val n = 5
	
	    //val arr = "2 3 4 1 5".split(" ").map{ it.trim().toInt() }.toTypedArray()
		
		//val n = 7
	
	    //val arr = "1 3 5 2 4 6 7".split(" ").map{ it.trim().toInt() }.toTypedArray()
	
	    val res = minimumSwaps(arr)
	
	    println(res)
	}
}