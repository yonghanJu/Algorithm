// 2022-06-25
// https://programmers.co.kr/learn/courses/30/lessons/42578 (위장)

class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        val map = mutableMapOf<String, MutableList<String>>()
        clothes.forEach{
            if(map[it[1]]==null) map[it[1]]=mutableListOf<String>()
            map[it[1]]?.add(it[0])
        }
        
        map.values.forEach{ v->
            answer*= v.size +1
        }
        
        return answer-1
    }
}
