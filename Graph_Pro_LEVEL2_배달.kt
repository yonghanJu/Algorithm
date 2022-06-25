// 2022-06-25
// https://programmers.co.kr/learn/courses/30/lessons/12978 (배달)

class Solution {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        var answer = 0
        val table = Array(N+1){ IntArray(N+1){Int.MAX_VALUE} }
        repeat(N){table[it+1][it+1]=0}
        
        // table에 그래프 정보 입력
        road.forEach{
            table[it[0]][it[1]]=minOf(it[2],table[it[0]][it[1]])
            table[it[1]][it[0]]=table[it[0]][it[1]]
        }
        
        // 최단거리 정보 변경이 없는 경우
        var isChanged = true
        outer@while(isChanged){
            isChanged = false
            for(i in 1..N){
                for(j in 1 .. N){
                    for(k in 1..N){
                        if(table[i][k]!=Int.MAX_VALUE && table[k][j]!=Int.MAX_VALUE &&
                                (table[i][j] > table[i][k]+table[k][j])){
                            table[i][j] = table[i][k]+table[k][j]
                            table[j][i] = table[i][j]
                            isChanged = true
                            continue@outer
                        }
                    }
                }
            }
        }
        
        for(i in 1..N){
            if(table[1][i]<=k) answer++
        }
        
        return answer
    }
}
