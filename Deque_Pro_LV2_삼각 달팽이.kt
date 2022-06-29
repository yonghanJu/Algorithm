// 2022-06-29
// https://programmers.co.kr/learn/courses/30/lessons/68645 (삼각 달팽이)

class Solution {
    fun solution(n: Int): IntArray {
        var answer = mutableListOf<Int>()
        val qList = List(n){ arrayOf(ArrayDeque<Int>(), ArrayDeque<Int>())}
        
        var dir = 0
        var number = 1
        var h = 0
        for(len in n downTo 1){
            for(i in 1..len){
                when(dir){
                    0->{
                        qList[h][0].addLast(number)
                        if(i!=len) h++
                    }
                    1->{
                        qList[h][0].addLast(number)
                        if(i==len) h--
                    }
                    2->{
                        qList[h][1].addFirst(number)
                        if(i!=len) h--
                        else h++
                    }
                }
                number++
            }
            dir++
            dir%=3
        }
        for(i in 0 until n){
            qList[i][0].forEach{
                answer.add(it)
            }
            qList[i][1].forEach{
                answer.add(it)
            }
        }
        return answer.toIntArray()
    }
}
