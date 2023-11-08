class Solution {
    fun solution(record: Array<String>): Array<String> {
        val nickMap = mutableMapOf<String, String>()
        var answer = mutableListOf<Pair<String, String>>()
        record.forEach {
            val history = it.split(' ')
            if(history[0] == "Change" || history[0] == "Enter") {
                nickMap[history[1]] = history[2]!!
            }
            if(history[0] == "Enter") {
                answer.add(Pair(history[1], "Enter"))
            } else if(history[0] == "Leave") {
                answer.add(Pair(history[1], "Leave"))
            }
        }
        
        return answer.map { (uid, action) -> "${nickMap[uid]}님이 ${if(action == "Enter") "들어왔습니다" else "나갔습니다"}." }.toTypedArray()
    }
}
