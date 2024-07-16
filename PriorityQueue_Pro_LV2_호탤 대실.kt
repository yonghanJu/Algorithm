import java.util.*

class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        var answer: Int = 0
        
        val bookTime = book_time.map { list -> 
            List(2) { 
                val split = list[it].split(":") 
                split[0].toInt() * 60 + split[1].toInt() + if (it == 1) 10 else 0
            } 
        }.sortedBy { it[0] }
        
        val bookQueue = PriorityQueue<List<Int>>( compareBy { it[1] })
        
        bookTime.forEach {
            if (bookQueue.size == 0) bookQueue.add(it)
            else if (bookQueue.peek()[1] <= it[0]) {
                bookQueue.poll()
                bookQueue.add(it)
            } else bookQueue.add(it)
            answer = maxOf(bookQueue.size)
        }
        
        return answer
    }
}
