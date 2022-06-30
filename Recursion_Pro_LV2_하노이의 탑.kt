// 2022-06-30
// https://programmers.co.kr/learn/courses/30/lessons/12946 (하노이의 탑)

class Solution {
    fun solution(n: Int): Array<IntArray> {
        var answer = mutableListOf<IntArray>()
        
        dfs(1,2,3,n,answer)
        
        return Array(answer.size){answer[it]}
    }
    
    fun dfs(from:Int, tmp:Int, to:Int, n:Int, arr:MutableList<IntArray>){
        if(n==1){
            arr.add(intArrayOf(from, to))
            return
        }
        dfs(from, to, tmp, n-1,arr)
        dfs(from,tmp,to,1,arr)
        dfs(tmp,from,to,n-1,arr)
    }
}
