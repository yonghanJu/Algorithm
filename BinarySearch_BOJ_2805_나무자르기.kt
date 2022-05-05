// 2022-05-05
// https://www.acmicpc.net/problem/2805

import java.util.*

class Solution{
    fun solution(n:Int, m: Int, list:List<Int>):Int{
        var start =0
        var end = list.maxOf{it}
        var answer =0

        while(start<=end){
            var sum =0L
            var mid = (start+end)/2
            list.forEach{
                sum+=maxOf(0,it-mid)
            }
            if(sum < m){
                end = mid-1
            }else{
                start = mid+1
                answer = mid
            }
        }
        return answer
    }
}

fun main() {
    val nk = readLine()!!.split(' ')
    val list=  readLine()!!.split(' ').map{it.toInt()}
    println(Solution().solution(nk[0].toInt(), nk[1].toInt(),list))
}
