// 2022-06-30
// https://programmers.co.kr/learn/courses/30/lessons/12945 (피보나치 수)

class Solution {
    fun solution(n: Int): Int {
        val pib = IntArray(n+1)
        pib[1]=1
        
        for(i in 2..n){
            pib[i] = (pib[i-1]+pib[i-2])%1234567
        }
        
        return pib[n]
    }
}
