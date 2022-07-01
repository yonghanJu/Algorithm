// 2022-07-01
// https://programmers.co.kr/learn/courses/30/lessons/42628 (이중우선순위큐)

import java.util.PriorityQueue

class Solution {
    fun solution(operations: Array<String>): IntArray {
        var qSize =0
        
        val pq1 = PriorityQueue<Int>()
        val pq2 = PriorityQueue<Int>( compareBy<Int>{-it})
        val map = mutableMapOf<Int,Int>()
        
        for(op in operations){
            when(op){
                "D 1"->{
                    if(qSize >0) {
                        val r = pq2.poll()
                        pq1.remove(r)
                        qSize--
                    }
                }
                "D -1"->{
                    if(qSize>0){
                        val r = pq1.poll()
                        pq2.remove(r)
                        qSize--
                    }
                }
                else ->{
                    qSize++
                    val num = op.split(' ')[1].toInt()
                    pq1.add(num)
                    pq2.add(num)
                }
            }
        }
        return if(qSize==0) intArrayOf(0,0) else intArrayOf(pq2.peek(), pq1.peek())
    }
}
