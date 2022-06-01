// 2022-06-01
// https://www.acmicpc.net/problem/2294

import java.util.*

class Solution {
    fun solution(k:Int, coins:IntArray) {
        val answer = IntArray(k+1){10001}
        coins.forEach{
            if(it in 0..k) answer[it]=1
        }
        for(i in 0..k){
            for(coin in coins){
                if(i-coin in 0..k){
                    // 주의 사항
                    // 초기 배열을 Int.MAX_VALUE로 설정시, answer[n]+1 => 음수로 항상 min 값을 가짐
                    answer[i] = minOf(answer[i-coin]+1, answer[i])
                }
            }
        }

        print(if(answer[k] >=10001) -1 else answer[k])
    }
}

fun main() {
    val (n,k)= readLine()!!.split(' ')
    Solution().solution( k.toInt(),  Array(n.toInt()){readLine()!!.toInt()}.sorted().toIntArray() )
}
