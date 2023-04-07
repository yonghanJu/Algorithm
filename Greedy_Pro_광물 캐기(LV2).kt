// 2023-04-08
// https://school.programmers.co.kr/learn/courses/30/lessons/172927

class Solution {
    fun solution(picks: IntArray, minerals: Array<String>): Int {
        var answer: Int = 0
        val mineralList = mutableListOf<IntArray>()
        for(i in minerals.indices) {
            if(i % 5 == 0) mineralList.add(IntArray(3))
            if(picks.sum() < mineralList.size) { // 핵심
                mineralList.removeLast()
                break
            }
            val index = when(minerals[i]) {
                "diamond" -> 0
                "iron" -> 1
                "stone" -> 2
                else -> throw Exception()
            }
            mineralList.last()[index]++
        }
        
        mineralList.sortWith( compareBy<IntArray> { -it[0] }.thenBy{-it[1]}.thenBy{-it[2]})
        
        var idx = 0
        while(picks.sum() > 0 && idx < mineralList.size) {
            if(picks[0] > 0) {
                picks[0]--
                answer += mineralList[idx].sum()
            } else if(picks[1] > 0) {
                picks[1]--
                answer += (mineralList[idx][0]) * 5 + mineralList[idx][1] + mineralList[idx][2]

            } else if(picks[2] > 0) {
                picks[2]--
                answer += mineralList[idx][0] * 25 + mineralList[idx][1] * 5 + mineralList[idx][2]
            }
            idx++
        }
        
        return answer
    }
}
