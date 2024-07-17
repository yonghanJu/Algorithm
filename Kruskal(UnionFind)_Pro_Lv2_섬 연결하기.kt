class Solution {
    fun solution(n: Int, costs: Array<IntArray>): Int {
        var answer = 0
        val unionList = IntArray(n) { it }
        
        costs.sortedBy { it[2] }.forEach { (start, end, cost) ->
            if(find(start, unionList) != find(end, unionList)) {
                union(start, end, unionList)
                answer += cost
            }
        }
        
        return answer
    }
    
    fun find(x: Int, u: IntArray): Int {
        if(x == u[x]) return x
        return find(u[x], u)
    }
    
    fun union(x: Int, y: Int, u: IntArray) {
        val xParent = find(x, u)
        val yParent = find(y, u)
        if (xParent <= yParent) {
            u[yParent] = x
        } else {
            u[xParent] = y
        }
    }
}
