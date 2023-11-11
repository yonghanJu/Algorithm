class Solution {
    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        var answer: Int = Int.MAX_VALUE
        
        val graph = List(n + 1) { IntArray(n + 1) { Int.MAX_VALUE } }
        for(i in 1..n) { graph[i][i] = 0 }
        fares.forEach {
            graph[it[0]][it[1]] = it[2]
            graph[it[1]][it[0]] = it[2]
        }
        
        for(i in 1..n) { // i = 경유지
            for(from in 1..n) {
                for(to in 1..n) { 
                    if(graph[from][to] > graph[from][i] + graph[i][to]) {
                        if(graph[from][i] == Int.MAX_VALUE || graph[i][to] == Int.MAX_VALUE) continue
                        graph[from][to] = graph[from][i] + graph[i][to]
                        graph[to][from] = graph[from][i] + graph[i][to]
                    }
                }
            }
        }
        
        for(i in 1..n) {
            answer = minOf(answer, graph[s][i] + graph[i][a] + graph[i][b])
        }
        
        return answer
    }
}
