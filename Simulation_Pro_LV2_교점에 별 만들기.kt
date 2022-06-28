// 2022-06-28
// https://programmers.co.kr/learn/courses/30/lessons/87377 (교점에 별 만들기)

// 주의 사항
// 자료형의 범위를 살펴 overflow 방지!

class Solution {
    fun solution(line: Array<IntArray>): Array<String> {
        var answerList = mutableSetOf<Pair<Int,Int>>()
        for(i in line.indices){
            for(j in i+1 .. line.lastIndex){
                val (a,b,e) = line[i].map{it.toLong()}
                val (c,d,f) = line[j].map{it.toLong()}
                val adbc = a*d-b*c
                val bfed = b*f-e*d
                val ecaf = e*c-a*f
                if(adbc == 0L) continue
                if(bfed%adbc!=0L || ecaf%adbc!=0L) continue
                answerList.add(Pair((ecaf/adbc).toInt(), (bfed/adbc).toInt()))
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
