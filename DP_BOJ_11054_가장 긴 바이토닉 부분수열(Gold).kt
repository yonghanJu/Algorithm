// 2022-06-12
// https://www.acmicpc.net/problem/11054

import java.util.*

class Solution {
    fun solution(arr:IntArray){
        val up = IntArray(arr.size){1}
        for(i in 1..arr.lastIndex){
            for(j in 0 until i){
                if(arr[j] < arr[i]){
                    up[i] = maxOf(up[i], up[j]+1)
                }
            }
        }

        val down = IntArray(arr.size){1}
        for(i in arr.lastIndex-1  downTo 0){
            for(j in i+1 .. arr.lastIndex){
                if(arr[i] > arr[j]){
                    down[i] = maxOf(down[i], down[j]+1)
                }
            }
        }
        var sum = 0
        for(i in arr.indices){
            sum = maxOf(sum, up[i]+down[i]-1)
        }
        println(sum)
    }
}

fun main() {
    readLine()
    Solution().solution(readLine()!!.split(' ').map{it.toInt()}.toIntArray())
}
