// 2022-06-02
// https://www.acmicpc.net/problem/9184

import java.util.*

class Solution {
    fun solution(a:Int, b:Int, c:Int, w:Array<Array<IntArray>>):Int{
        if(a<=0 || b<=0 || c<= 0) return 1
        if(a>20 || b> 20 || c>20){
            if(w[20][20][20]==0) w[20][20][20] = solution(20,20,20,w)
            return w[20][20][20]
        }
        if(w[a][b][c]==0){
            if(b in (a + 1) until c){
                w[a][b][c] = solution(a,b,c-1,w) + solution(a,b-1,c-1,w) -solution(a,b-1,c,w)
            }else{
                w[a][b][c] = solution(a-1,b,c,w) + solution(a-1,b-1,c,w) + solution(a-1,b,c-1,w) - solution(a-1,b-1,c-1,w)
            }
        }
        return w[a][b][c]
    }
}

fun main() {
    var input = readLine()!!.split(' ').map{it.toInt()}
    val w = Array(21){Array(21){IntArray(21)} }
    while( input[0]!=-1 || input[1]!=-1 || input[2]!=-1 ){
        println("w(${input[0]}, ${input[1]}, ${input[2]}) = ${Solution().solution(input[0], input[1], input[2], w)}")
        input = readLine()!!.split(' ').map{it.toInt()}
    }
}
