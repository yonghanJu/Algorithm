class Solution {
    fun solution(k: Long, room_number: LongArray): LongArray {
        val answer = mutableListOf<Long>()
        val map = mutableMapOf<Long, Long>()

        room_number.forEach { num ->
            val index = find(map, num)
            answer.add(index)
            map[index] = index + 1
        }

        return answer.toLongArray()
    }

    private fun find(map: MutableMap<Long, Long>, target: Long): Long {
        return if (map[target] == null) {
            target
        } else {
            map[target] = find(map, map[target]!!)
            map[target]!!
        }
    }
}
