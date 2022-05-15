// 2022-05-15
// https://www.acmicpc.net/problem/5648

import java.util.*

data class Data(val n:String):Comparable<Data> {
    override fun compareTo(other: Data): Int {
        if(this.n.length != other.n.length){
            return this.n.length - other.n.length
        }else{
            return if(this.n < other.n) -1 else 0
        }
    }
}

class Solution{
    fun solution(array:Array<Data>){
        array.sorted().forEach { println(it.n) }
    }
}

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    Solution().solution( Array(n){ Data(sc.next().trimEnd('0').reversed())})
}
