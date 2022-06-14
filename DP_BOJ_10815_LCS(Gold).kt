// 2022-06-14
// https://www.acmicpc.net/problem/10815

import java.util.*

class Solution {
    fun solution(str1:String, str2:String){
        val lcs = Array(str1.length+1){IntArray(str2.length+1)}
        for(i in 1 .. str1.lastIndex+1){
            for(j in 1.. str2.lastIndex+1){
                if(str1[i-1]==str2[j-1]) lcs[i][j]=lcs[i-1][j-1]+1
                else lcs[i][j] = maxOf(lcs[i-1][j], lcs[i][j-1])
            }
        }
        println(lcs.last().last())
    }
}

fun main() {
    Solution().solution(readLine()!!, readLine()!!)
}
