class Solution {
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        val map = mutableMapOf<Set<String>, List<List<String>>>()
        val answer = IntArray(query.size)
        val infos = info.map { it.split(" ") }.sortedBy { it.last().toInt() }
        query.map { it.split(" ").filter { it != "and" } }.forEachIndexed { idx, it ->
            if (map[setOf(it[0], it[1], it[2], it[3])] == null) {
                var input: List<List<String>> = infos
                for (i in 0..3) {
                    input = input.filter { list -> if (it[i] == "-") true else it[i] == list[i] }
                }
                map[setOf(it[0], it[1], it[2], it[3])] = input
            }

            val i = map[setOf(it[0], it[1], it[2], it[3])]!!
            val size = i.size
            answer[idx] += size - lowerBound(0, size, it.last().toIntOrNull() ?: 0, i)
        }
        return answer
    }

    fun lowerBound(start: Int, end: Int, target: Int, list: List<List<String>>): Int {
        if (start >= end) {
            return start
        }
        val mid = (start + end) / 2

        if (list[mid].last().toInt() >= target) {
            return lowerBound(start, mid, target, list)
        } else {
            return lowerBound(mid + 1, end, target, list)
        }
    }
}
