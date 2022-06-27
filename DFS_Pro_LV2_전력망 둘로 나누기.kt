// 2022-06-27
// https://programmers.co.kr/learn/courses/30/lessons/86971(전역망을 둘로 나누기)

class Solution {
    var count =0
    lateinit var chTable:IntArray
    lateinit var isVisited:BooleanArray
    
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer: Int = Int.MAX_VALUE
        chTable = IntArray(n+1)
        isVisited = BooleanArray(n+1)
        val table = Array(n+1){mutableListOf<Int>()}
        
        wires.forEach{
            table[it[0]].add(it[1])
            table[it[1]].add(it[0])
        }
        
        dfs(1, table)
        
        chTable.forEach{
            answer = minOf(answer, if(n-2*it < 0) 2*it-n else n-2*it )
        }
        
        return answer
    }
    
    fun dfs(start:Int, table:Array<MutableList<Int>>):Int{
        var d = 1
        isVisited[start] = true
        
        for(i in table[start]){
            if(isVisited[i]) continue
            d+=dfs(i, table)
            
        }
        
        chTable[start] = d
        return d
    }
}
