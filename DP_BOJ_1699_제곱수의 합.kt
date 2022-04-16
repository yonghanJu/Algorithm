// 2022-04-16
// https://www.acmicpc.net/problem/1699

import java.io.*
import java.util.*
import kotlin.math.*


class Solution{
    fun solution(n:Int):Int{
        val list = IntArray(n+1){it}
        for(i in 1..n){
            var j = 1
            while(j*j<=i){
                if(list[i-j*j]+1 < list[i]){
                    list[i]=list[i-j*j]+1
                }
                j++
            }
        }
        return list[n]
    }
}



fun main():Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    print(Solution().solution(readLine().toInt()))
}
