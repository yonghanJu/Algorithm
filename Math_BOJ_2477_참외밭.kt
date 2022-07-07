// 2022-07-07
// https://www.acmicpc.net/problem/2477

class Solution {
    fun solution(n:Int, array:Array<String>):Int{
        var answer = 1
        val list = Array(5){mutableListOf<Int>()}

        array.forEach{
            val sp = it.split(' ')
            list[sp[0].toInt()].add(sp[1].toInt())
        }

        list.forEach{
            if(it.size==1) answer *=it[0]
        }

        var index = 0
        var count = 0
        var small = 1
        while(list[array[index].split(' ')[0].toInt()].size!=1) index++
        while(count<3){
            if(index>5) index-=6
            val sp = array[index].split(' ')
            if(list[sp[0].toInt()].size==2){
                if(count == 0) count++
                else{
                    count++
                    small*=sp[1].toInt()
                }
            }
            index++
        }
        return (answer - small) * n
    }
}

fun main() {
    println(Solution().solution(readLine()!!.toInt(), Array(6){readLine()!!}))
}
