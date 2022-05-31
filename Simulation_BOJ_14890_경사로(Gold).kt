// 2022-05-31
// https://www.acmicpc.net/problem/14890

import java.util.*

class Solution {
    fun solution(l:Int, table:Array<IntArray>) {
        var answer = table.size*2
        outer@for( i in table.indices){
            var upCnt = l
            var downCnt = 0
            var cur = table[i][0]
            for(j in table[0].indices){
                if(table[i][j]==cur) {
                    if(upCnt > 0) upCnt--
                    if(downCnt>0) downCnt--
                    continue
                }
                else if(cur+1 == table[i][j]){
                    if(upCnt != 0){
                        answer--
                        continue@outer
                    }
                    cur = table[i][j]
                    upCnt=l-1
                }
                else if(cur-1 == table[i][j]){
                    if(downCnt != 0){
                        answer--
                        continue@outer
                    }
                    cur = table[i][j]

                    downCnt=l-1
                    upCnt = 2*l-1
                }
                else {
                    answer--
                    continue@outer
                }
            }
            if(downCnt !=0) answer --
        }

        outer@for( j in table.indices){
            var upCnt = l
            var downCnt = 0
            var cur = table[0][j]
            for(i in table[0].indices){
                if(table[i][j]==cur) {
                    if(upCnt > 0) upCnt--
                    if(downCnt>0) downCnt--
                    continue
                }
                else if(cur+1 == table[i][j]){
                    if(upCnt != 0){
                        answer--
                        continue@outer
                    }
                    cur = table[i][j]
                    upCnt= l-1
                }
                else if(cur-1 == table[i][j]){
                    if(downCnt != 0){
                        answer--
                        continue@outer
                    }
                    cur = table[i][j]
                    downCnt = l-1
                    upCnt = 2*l-1
                }
                else {
                    answer--
                    continue@outer
                }
            }
            if(downCnt !=0) answer --
        }

        print(answer)

    }
}

fun main() {
    val (n,l)= readLine()!!.split(' ')
    Solution().solution( l.toInt(), Array(n.toInt()){readLine()!!.split(' ').map{it.toInt()}.toIntArray()} )
}
