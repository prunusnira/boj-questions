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
		// swap 판단하기
		var cnt = 0
		
		// 무엇과 무엇을 스왑해야 하는가?
		// 1. 제자리에 있는 숫자 빼고 나머지에 대해서
		// 2. 가장 낮은 수와 그 위치에 있는 값을 스왑한다
		// 3. 스왑 후 현재 정렬 상태를 체크한다
		// 4. 반복
		
		// TRIAL 1
		/*for(i in 0..arr.size-1) {
			if(i+1 != arr[i]) {
				var temp = arr[arr.indexOf(i+1)]
				arr[arr.indexOf(i+1)] = arr[i]
				arr[i] = temp
				cnt++
			}
		}*/
		// 방법을 알았으니 timeout을 없애보자 (9, 10, 11, 12, 14)
		
		// TRIAL 2
		// 역으로 숫자부터 찾아보자...
		/*for(i in 0..arr.size-1) {
			if(arr.indexOf(i+1) != i) {
				var temp = arr[arr.indexOf(i+1)]
				arr[arr.indexOf(i+1)] = arr[i]
				arr[i] = temp
				cnt++
			}
		}*/
		// 이걸 하니 13도 Timeout이 됨
		
		// TRIAL 3
		// 찾아진 숫자를 바로바로 바꾸기
		/*for(i in 0..arr.size-1) {
			if(arr[i] != i+1) {
				var temp = arr.indexOf(i+1)
				arr[temp] = arr[i]
				arr[i] = i+1
				cnt++
			}
		}*/
		// 10, 11, 12, 14가 timeout이 됨
		
		// TRIAL 4
		// 변경된 index를 따라가서 바로 변경하기
		// 어차피 1번씩 swap을 한다면 결국 다 변경해야 하므로 따라가면서 값을 바꾸는게 빠르다
		/*var visited = arrayListOf<Int>()
		var cidx = 0
		var temp = -1
		while(visited.size < arr.size) {
			if(visited.contains(cidx)) {
				// 이번턴의 순회가 완료됨
				if(temp == -1) {
					cidx++
					continue
				}
				else {
					cnt-- // 최소 2인데 하나는 빼야됨
					cidx++
					temp = -1
					if(cidx > arr.size-1) break
					else continue	
				}
			}
			else {
				// 아직 순회가 끝나지 않았음
				if(temp == -1) {
 					// 처리할 필요가 없다면
					if(arr[cidx] == cidx+1) {
						visited.add(cidx)
						cidx++
						continue
					}
					// 최초값
					temp = cidx
				}
				// 각 값 변경
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
		// 다른 방식으로
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
		// 타임아웃에 값도 안맞음
		
		// TRIAL 6 - Answer
		// step 1 : check if each array index is filled is current value .
		// (So, arr[i] ==i+1, since, index start from 0 , so need for increment of 1 as value is from 1 to n).
		// step 2 : for the element not at its actual position.
		// we simply replace the ith element with value at the (arr[i]-1)th position, as index is from 0.
		// and increase the count.
		// And again decreasing the i of loop to check if again the value at ith position is (i+1) or not .
		// (i+1이 아닌 i로 비교하기 위함)
		var i = 0
		while(i < arr.size) {
			// 현재 위치에 해당하는 값이 없으면
			if(arr[i] != i+1) {
				// 맨 앞에 있는 값과 무조건 교환
				var temp = arr[arr[i] - 1]
				arr[arr[i] - 1] = arr[i]
				arr[i] = temp
				cnt++
				i-- // index를 빼서 현재 값으로 다시 조정
			}
			// 위치하는 값이 있으면 index 증가
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