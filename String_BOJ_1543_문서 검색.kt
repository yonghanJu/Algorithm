// 2022-05-28
// https://www.acmicpc.net/problem/1543

import java.util.*

class Solution {
    fun solution(str:String, target:String) {
        var answer = 0

        var i =0
        outer@while(i <= str.length-target.length){
            var j = i
            var t = 0
            for(f in j until j+target.length){
                if(str[f] != target[t]) {
                    i++
                    continue@outer
                }
                t++
            }
            i+=target.length
            answer++
        }

        print(answer)
    }
}

fun main() {
    Solution().solution(readLine()!!, readLine()!!)
}
