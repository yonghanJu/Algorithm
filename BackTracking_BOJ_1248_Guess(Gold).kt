// 2022-04-05
// https://www.acmicpc.net/problem/1248

import java.io.*
import java.util.*

var n =0
lateinit var sumList:IntArray
lateinit var matrix:Array<CharArray>
lateinit var stack:Stack<Int>
fun main():Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    n = readLine().toInt()
    sumList = IntArray(n)
    stack = Stack()
    matrix = Array(n){CharArray(n)}
    val str = readLine()
    var d=0
    for(i in 0 until n){
        for(j in 0 until n){
            if(j<i) {
                matrix[i][j] = 'N'
            } else {
                matrix[i][j] = str[d]
                d++
            }
        }
    }
    dfs(0)
}

fun dfs(size:Int) : Boolean{
    if(size == n){
        stack.forEach{
            print("$it ")
        }
        return true
    }

    outer@for(j in 10 downTo -10){
        for(i in 0 .. size){
            if(((sumList[i]+j > 0 && matrix[i][size]=='+') || (sumList[i]+j < 0 && matrix[i][size]=='-') || (sumList[i]+j == 0 && matrix[i][size]=='0')).not())
                continue@outer
        }

        for(i in 0 .. size) sumList[i] += j
        stack.add(j)
        if(dfs(size+1)) return true
        stack.pop()
        for(i in 0 .. size) sumList[i] -= j
    }

    return false
}
