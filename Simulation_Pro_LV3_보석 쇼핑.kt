// 2022-07-02
// https://programmers.co.kr/learn/courses/30/lessons/67258 (보석쇼핑)

class Solution {
    fun solution(gems: Array<String>): IntArray {
        var answer = intArrayOf()
        val map = mutableMapOf<String,Int>()
        
        var size = 0
        var minSize = Int.MAX_VALUE
        var answerStart = 1
        var answerEnd = 1
        gems.forEach{
            map[it]=0
        }
        
        var start = 0
        var end = 0
        var moveEnd = true
        while(end <= gems.lastIndex && start<= end){       
            if(moveEnd){
                if(map[gems[end]]==0) size++
                map[gems[end]] = map[gems[end]]!! +1
            }else{
                if(map[gems[start-1]]==1) size--
                map[gems[start-1]] = map[gems[start-1]]!! -1
            }
            if(size==map.size && end-start < minSize){
                answerStart = start+1
                answerEnd = end+1
                minSize= end-start
            }
            if(size<map.size){
                end++
                moveEnd=true
            }else{
                start++
                moveEnd=false
            }
        }
        
        return intArrayOf(answerStart,answerEnd)
    }
}
