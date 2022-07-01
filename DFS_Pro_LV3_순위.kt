// 2022-07-01
// https://programmers.co.kr/learn/courses/30/lessons/49191 (순위)

class Solution {
    lateinit var score: Array<IntArray>
    lateinit var graph: Array<MutableList<Int>>
    lateinit var isVisited:BooleanArray
    fun solution(n: Int, results: Array<IntArray>): Int {
        var answer = 0
        score = Array(n+1){IntArray(2)}
        isVisited = BooleanArray(n+1)
        graph = Array(n+1){mutableListOf()}
        
        for(r in results){
            graph[r[0]].add(r[1])
        }
        
        for(i in 1..n){
            isVisited = BooleanArray(n+1)
            isVisited[i]=true
            dfs(i,i)
        }
        
        for(i in 1..n){
            if(score[i][0]+score[i][1] == n-1 ) answer++
        }
        
        return answer
    }
    
    fun dfs(now:Int, root:Int){
        if(now != root){
            score[now][1]++
            score[root][0]++
        }
        
        for(i in graph[now]){
            if(isVisited[i]) continue
            isVisited[i]=true
            dfs(i,root)
        }
    }
}
