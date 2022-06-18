// 2022-06-18
// https://www.acmicpc.net/problem/17140

import java.util.*

class Solution {
    fun solution(rck:List<Int>, table:Array<List<Int>>){
        val board = Array(100){IntArray(100)}
        for(i in 0..2){
            for(j in 0..2){
                board[i][j]=table[i][j]
            }
        }
        var answer =0
        var rSize = 3
        var cSize = 3
        while(board[rck[0]-1][rck[1]-1] != rck[2] && answer<=100){
            answer++
            // c 연산
            if(rSize < cSize){
                var newSize = 0
                var tmp = 0

                for(c in 0 until 100){
                    if(c>= cSize) break
                    val map = hashMapOf<Int,Int>()
                    for(r in 0 until 100){
                        if(r >= rSize) break
                        if(board[r][c]==0) continue
                        map[board[r][c]] = map.getOrDefault(board[r][c], 0) + 1
                    }

                    // 아래 형태 (compareBy) 꼭 외우기
                    val sortedList = map.entries.sortedWith( compareBy<MutableMap.MutableEntry<Int, Int>> { it.value }.thenBy{it.key} )
                    newSize =0
                    for(i in 0 until 50 ){
                        if(i in sortedList.indices){
                            newSize+=2
                            board[i*2][c]= sortedList[i].key
                            board[i*2+1][c]= sortedList[i].value
                        }else {
                            for(j in i*2 until 100){
                                board[j][c]=0
                            }
                            break
                        }
                    }
                    tmp = maxOf(tmp, newSize)
                }

                rSize = maxOf(rSize, tmp)
            }
            // r 연산
            else{
                var newSize = 0
                var tmp = 0

                for(r in 0 until 100){
                    if(r>= rSize) break
                    val map = hashMapOf<Int,Int>()
                    for(c in 0 until 100){
                        if(c >= cSize) break
                        if(board[r][c]==0) continue
                        map[board[r][c]] = map.getOrDefault(board[r][c], 0) + 1
                    }

                    // 아래 형태 (compareBy) 꼭 외우기
                    val sortedList = map.entries.sortedWith( compareBy<MutableMap.MutableEntry<Int, Int>> { it.value }.thenBy{it.key} )
                    newSize =0
                    for(i in 0 until 50 ){
                        if(i in sortedList.indices){
                            newSize+=2
                            board[r][i*2]= sortedList[i].key
                            board[r][i*2+1]= sortedList[i].value
                        }else {
                            for(j in i*2 until 100){
                                board[r][j]=0
                            }
                            break
                        }
                    }
                    tmp = maxOf(tmp, newSize)
                }
                cSize = maxOf(cSize, tmp)
            }
        }
        println(if(answer==101) -1 else answer)
    }
}

fun main() {
    Solution().solution(readLine()!!.split(' ').map{it.toInt()}, Array(3){readLine()!!.split(' ').map{it.toInt()}})
}
