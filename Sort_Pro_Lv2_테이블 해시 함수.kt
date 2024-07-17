class Solution {
    fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
        var answer: Int = 0
        val sortedData = data.sortedWith(compareBy<IntArray>{ it[col - 1] }.thenBy { -it[0] })
        
        for(r in row_begin - 1..row_end - 1) {
            var sum = 0
            sortedData[r].forEach { sum += it % (r + 1) }
            answer = answer.xor(sum)
        }
        
        return answer
    }
}
