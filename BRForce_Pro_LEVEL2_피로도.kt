// 2022-06-25
// https://programmers.co.kr/learn/courses/30/lessons/87946(피로도)

class Solution {
    var answer: Int = 0
    lateinit var isVisited:BooleanArray
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        isVisited = BooleanArray(dungeons.size)
        dfs(k, dungeons, 0)
        return answer
    }
    
    fun dfs(k:Int,d:Array<IntArray>, depth:Int){
        for(i in d.indices){
            if(isVisited[i]) continue
            if(k < d[i][0]) continue
            isVisited[i]=true
            dfs(k-d[i][1], d, depth+1)
            isVisited[i]=false
        }
        answer = maxOf(answer, depth)
    }
}
