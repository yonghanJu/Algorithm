import kotlin.math.*

class Solution {
    fun solution(n: Int, k: Int): Int {
        var answer: Int = 0
        
        var kNum = ""
        var cur = n
        while(cur > 0) {
            kNum = "${cur%k}$kNum"
            cur /= k
        }
        
        kNum.split("0").filter { it.length > 0 }.forEach {
            answer += isPrime(it.toLong())
        }
        return answer
    }
    
    private fun isPrime(n: Long): Int {
        if(n == 1L) return 0
        var i = 2L
        while(i <= sqrt(n.toDouble())) {
            if(n % i == 0L) return 0
            i++
        }
        return 1
    }
}
