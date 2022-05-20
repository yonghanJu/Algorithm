// 2022-05-19
// https://www.acmicpc.net/problem/18808

import java.util.*

class Solution {
    lateinit var table:Array<BooleanArray>
    var answer = 0

    fun solution(n:Int, m:Int, stickers:Array<Array<IntArray>>) {
        table = Array(n){BooleanArray(m)}

        outer@for(sticker in stickers){
            var s = sticker
            for(r in 0..3){
                if(r!=0) s = rotate(s)
                val xLen=s.size
                val jLen =s[0].size
                for(i in 0 until n-xLen+1){
                    for(j in 0 until m-jLen+1){
                        if(match(s,i,j)) continue@outer
                    }
                }
            }
        }
        print(answer)
    }

    fun match(s:Array<IntArray>, x:Int, y:Int):Boolean{
        for(i in s.indices){
            for(j in s[0].indices){
                if(s[i][j]==1 && table[x+i][y+j]) return false
            }
        }
        for(i in s.indices){
            for(j in s[0].indices){
                if(s[i][j]==1){
                    table[x+i][y+j]=true
                    answer++
                }
            }
        }
        return true
    }

    fun rotate(s:Array<IntArray>):Array<IntArray>{
        val ns = Array(s[0].size){IntArray(s.size)}
        val xLen =s.size
        for(i in s.indices){
            for(j in s[0].indices){
                ns[j][xLen-1-i]=s[i][j]
            }
        }
        return ns
    }
}

fun main() {
    val (N, M, K) = readLine()!!.split(' ')
    Solution().solution(N.toInt(),M.toInt(),Array( K.toInt() ){
        val (x,y) = readLine()!!.split(' ')
        Array(x.toInt()){ readLine()!!.split(' ').map{it.toInt()}.toIntArray() }
    })
}
