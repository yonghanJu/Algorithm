// 2022-06-18
// https://www.acmicpc.net/problem/1213

import java.util.*

class Solution {
    fun solution(str:String){
        val arr = IntArray(26)
        val sb = StringBuilder()
        str.forEach{
            arr[it-'A']++
        }
        if(arr.count { it%2!=0 }>1) {
            println("I'm Sorry Hansoo")
            return
        }
        for(i in arr.indices){
            if(arr[i]>0){
                repeat(arr[i]/2){
                    sb.append('A'+i)
                }
            }
        }
        for(i in arr.indices){
            if(arr[i]%2!=0){
                sb.append('A'+i)
                break
            }
        }
        for(i in arr.lastIndex downTo 0){
            if(arr[i]>0){
                repeat(arr[i]/2){
                    sb.append('A'+i)
                }
            }
        }
        println(sb)
    }
}

fun main() {
    Solution().solution(readLine()!!)
}
