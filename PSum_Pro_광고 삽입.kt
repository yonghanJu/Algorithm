import java.util.*

class Solution {
    fun solution(play_time: String, adv_time: String, logs: Array<String>): String {
        val playTime = play_time.toTime()
        val advTime = adv_time.toTime()
        val pq = PriorityQueue(compareBy<Pair<Boolean, Int>> { it.second })
        logs.forEach {
            val (start, end) = it.split('-').map{ it.toTime() }
            pq.add(Pair(true, start))
            pq.add(Pair(false, end))
        }
        
        val psum1 = IntArray(playTime + 1)
        for(i in 0..psum1.lastIndex) {
            if(i > 0) psum1[i] = psum1[i - 1]
            while(pq.isNotEmpty() && pq.peek().second == i) {
                val isOn = pq.poll().first
                psum1[i] += if(isOn) 1 else -1
            }
        }
        val psum2 = LongArray(playTime + 1)
        psum2[0] = psum1[0].toLong()
        for(i in 1..psum2.lastIndex) {
            psum2[i] = psum2[i-1] + psum1[i]
        }
        var maxIndex = 0
        var max = psum2[advTime - 1]
        for(i in 1..(playTime - advTime)) {
            val cur = psum2[i+advTime - 1] - psum2[i-1]
            if(max < cur) {
                max = cur
                maxIndex = i
            }
        }
        
        
        var startTime = maxIndex
        val answerList = IntArray(3)
        answerList[2] = startTime % 60
        startTime /= 60
        answerList[1] = startTime % 60
        startTime /= 60
        answerList[0] = startTime
        return answerList.map{ "%02d".format(it) }.joinToString(":")
    }
    
}

fun String.toTime(): Int {
    val (h, m, s) = this.split(":").map{ it.toInt() }
    return s + m * 60 + h * 60 * 60
}
