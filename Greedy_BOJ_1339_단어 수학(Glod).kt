import kotlin.math.pow

// 2022-11-10
// https://www.acmicpc.net/problem/1339

class Solution {
    fun solution(array: Array<String>){
        var answer = 0
        val score = mutableMapOf<Char, Double>()
        var digit = 0
        while(true){
            var flag = true
            for(str in array) {
                if(digit < str.length) {
                    flag = false
                    score[str[digit]] = 10.0.pow((str.length - digit).toDouble()) + (score[str[digit]] ?: 0.0)
                }
            }
            digit++
            if(flag) break
        }
        var num = 9
        score.entries.sortedBy { -it.value }.forEach { mutableEntry ->
            array.forEach { str ->
                str.forEachIndexed { idx, c ->
                    if(c == mutableEntry.key) answer += num * (10.0.pow(str.length - idx - 1)).toInt()
                }
            }
            num--
        }
        println(answer)
    }
}

fun main() {
        Solution().solution(Array(readLine()!!.toInt()){ readLine()!! })

}
