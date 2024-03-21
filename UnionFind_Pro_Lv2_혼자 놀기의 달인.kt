class Solution {
    fun solution(cards: IntArray): Int {
        var answer: Int = 0
        val isVisited = BooleanArray(cards.size + 1)
        val parList = mutableListOf<Int>()
        parList.add(-1)
        cards.forEach { parList.add(it) }
        for (i in 1..cards.size) {
            dfs(i, parList, isVisited)
        }
        parList.groupBy { it }.values.map { it.size }.sortedBy { -it }.also {
            answer = if(it.size == 2) 0 else it[0] * it[1]
        }
        return answer
    }
    
    fun dfs(num: Int, parList: MutableList<Int>, isVisited: BooleanArray): Int {
        if(num == parList[num]) return num
        if(isVisited[num]) return num
        isVisited[num] = true
        parList[num] = dfs(parList[num], parList, isVisited)
        return parList[num]
    }
}
