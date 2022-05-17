// 2022-05-17
// https://www.acmicpc.net/problem/1766

import java.util.*

class Solution {
    fun solution(n:Int, array: Array<List<Int>>) {
        val aList = Array(n+1){mutableListOf<Int>()}
        val map = HashMap<Int,HashMap<Int,Boolean>>()
        val q = PriorityQueue<Int>()
        val isAdded = BooleanArray(n+1)
        val sb = StringBuilder()

        for(a in array){
            aList[a[0]].add(a[1])
            if(map[a[1]]==null) map[a[1]]= hashMapOf()
            map[a[1]]!![a[0]]=true
        }

        for(i in 1..n){
            if(map[i]==null) {
                q.add(i)
                isAdded[i]=true
            }
        }

        while(q.isEmpty().not()){
            val pop = q.poll()
            sb.append(pop).append(' ')

            aList[pop].forEach { //pop = 3, it=1
                if(map[it]!=null && map[it]!!.size>0){
                    map[it]!!.remove(pop)
                    if(map[it]!!.size==0) q.add(it)
                }
            }
        }
        print(sb)
    }
}

fun main() {
    val (N, M) = readLine()!!.split(' ')
    Solution().solution(N.toInt(), Array(M.toInt()){readLine()!!.split(' ').map{it.toInt()}})
}
