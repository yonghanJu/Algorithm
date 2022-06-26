// 2022-06-26
// https://programmers.co.kr/learn/courses/30/lessons/42583 (다리를 지나는 트럭)

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0
        var curWeight = 0
        var index = 0
        var q = ArrayDeque<Pair<Int,Int>>()
        
        while(index < truck_weights.size){
            
            if(q.isEmpty().not() && answer-q.last().second==bridge_length){
                val pop = q.removeLast()
                curWeight-= truck_weights[pop.first]
            }

            if(curWeight+ truck_weights[index] <= weight){
                q.addFirst(Pair(index, answer))
                curWeight+= truck_weights[index] 
                index++
            }
            answer++
        }
        
        return answer+bridge_length
    }
}
