// 2022-06-28
// https://programmers.co.kr/learn/courses/30/lessons/87377 (교점에 별 만들기)

// 주의 사항!
// 자료형의 범위를 잘 생각해서 overflow가 일어나지 않도록 하자!

class Solution {
    fun solution(line: Array<IntArray>): Array<String> {
        var answerList = mutableSetOf<Pair<Int,Int>>()
        for(i in line.indices){
            for(j in i+1 .. line.lastIndex){
                if(line[i][0]*line[j][1]==line[i][1]*line[j][0]) continue
                val x = ((line[i][1].toLong()*line[j][2]-line[i][2]*line[j][1]).toDouble())/(line[i][0]*line[j][1]-line[i][1]*line[j][0].toLong()).toDouble()
                if(x != x.toInt().toDouble()) continue
                val y = ((line[i][2]*line[j][0].toLong()-line[i][0]*line[j][2]).toDouble())/(line[i][0]*line[j][1]-line[i][1]*line[j][0].toLong()).toDouble()
                if(y != y.toInt().toDouble()) continue
                answerList.add(Pair(y.toInt(), x.toInt()))
            }
        }
        var maxX = Int.MIN_VALUE
        var minX = Int.MAX_VALUE
        var maxY = Int.MIN_VALUE
        var minY = Int.MAX_VALUE
        for(p in answerList){
            maxX =  maxOf(maxX, p.first)
            minX =  minOf(minX, p.first)
            maxY =  maxOf(maxY, p.second)
            minY =  minOf(minY, p.second)
        }
        
        var answer = Array(maxX-minX+1){CharArray(maxY-minY+1){'.'}}
        
        for(p in answerList){
            answer[maxX-p.first][p.second-minY]='*'
        }
        
        return Array(answer.size){ String(answer[it])}
    }
}
