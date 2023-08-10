// 2023-08-10 등산코스 정하기
// https://school.programmers.co.kr/learn/courses/30/lessons/118669

import java.util.*

class Solution {
    var min = Int.MAX_VALUE
    fun solution(n: Int, paths: Array<IntArray>, gates: IntArray, summits: IntArray): IntArray {
        var answer: IntArray = intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE)
        val gateMap = mutableMapOf<Int, Boolean>()
        val summitMap= mutableMapOf<Int, Boolean>()
        gates.forEach {
            gateMap.put(it, true)
        }
        summits.forEach {
            summitMap.put(it, true)
        }
        
        val edges = List( n+1 ) { mutableListOf<Pair<Int, Int>>() }.apply{
            paths.forEach { (a, b, intensity) ->
                if(min > intensity) min = intensity
                if(gateMap[a] == null && summitMap[b] == null)get(a).add(Pair(b, intensity)) // a가 gate면 안됨, b가 서밋이면 안됨
                if(gateMap[b] == null && summitMap[a] == null)get(b).add(Pair(a, intensity)) // b가 gate면 안됨, a가 서밋이면 안됨

            }
        }
        
        summitMap.keys.sortedBy{ it }.forEach {
            val intensity = dijk(it, edges, gateMap, n)
            if(answer[1] > intensity){
                answer[0] = it
                answer[1] = intensity
                if(answer[1] == min) return answer
            }
        }
        return answer
    }
    
    fun dijk(start: Int, edges: List<List<Pair<Int, Int>>>, gateMap: MutableMap<Int, Boolean>, n: Int): Int {
        val pq = PriorityQueue(compareBy<Pair<Int, Int>>{ it.second })
        val m = IntArray(n + 1){ Int.MAX_VALUE }
        val isVisited = BooleanArray(n + 1)
        m[start] = 0
        isVisited[start] = true
        edges[start].forEach { (to, intensity) ->
            m[to] = intensity
            pq.add(Pair(to, intensity))
        }
        
        while(pq.isEmpty().not()) {
            val cur = pq.poll()
            isVisited[cur.first] = true
            gateMap[cur.first]?.let{
                return m[cur.first]
            }
            
            if(m[cur.first] < cur.second) continue
            
            edges[cur.first].forEach { edge ->
                if(isVisited[edge.first].not() && m[edge.first] > maxOf(cur.second, edge.second)) {
                    m[edge.first] = maxOf(cur.second, edge.second)
                    pq.add(Pair(edge.first, m[edge.first]))
                }
            }
        }
        
        return Int.MAX_VALUE
    }
}
