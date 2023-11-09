import java.util.*

class Solution {
    fun solution(stones: IntArray, k: Int): Int {
        var min = 0
        var max = 200000000
        var mid = (min + max) / 2
        var answer = 0
        while(min <= max) {
            mid = (min + max) / 2
            if(canGo(mid, k, stones)) {
                answer = maxOf(answer, mid)
                min = mid + 1
            } else {
                max = mid - 1
            }
        }
        return answer
    }
    
    private fun canGo(num: Int, k: Int, stonse: IntArray): Boolean {
        var count = 0
        stonse.forEach {
            if(it < num) {
                count++ 
                if(count >= k) return false
            } else {
                count = 0
            }
        }
        return true
    }
}
