// 2021-01-05
// https://programmers.co.kr/learn/courses/30/lessons/42895

class Solution {
    fun solution(N: Int, number: Int): Int {
        var answer = 0
        sol.target = number
        sol.N = N
        sol.dfs(0,0) // prev, count
        return if(sol.answer>8) -1 else sol.answer
    }
    
    object sol{
        var target = 0 // target
        var answer = 9
        var N = 0 // N
        
        fun dfs(prev: Int, count: Int){
            if(count > 8) return
            else if(prev == target && count < answer){
                answer = count
                return
            }
            
            var p = N
            for(i in 0 until 8-count){
                if(p!= 0){
                    dfs(prev+p, count+i+1)
                    dfs(prev-p, count+i+1)
                    dfs(prev*p, count+i+1)
                    dfs(prev/p, count+i+1)
                }
                p = p*10 + N
            }
            
        }
    }
}
