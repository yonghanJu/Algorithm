// 2022-04-15
// https://www.acmicpc.net/problem/14891

import java.io.*
import java.lang.Math.abs
import java.util.*
import kotlin.math.pow

var k =0
var answer =0
lateinit var list:Array<LinkedList<Char>>
fun main():Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    list = Array(4){LinkedList(readLine().toCharArray().toList())}
    k = readLine().toInt()

    repeat(k){
        var (w, n) = readLine().split(' ').map{it.toInt()}
        val isMove = BooleanArray(4)
        isMove[w-1]=true
        for(i in w-2 downTo 0){
            if(list[i+1][6] == list[i][2]) break
            isMove[i]=true
        }
        for(i in w..3){
            if(list[i][6] == list[i-1][2]) break
            isMove[i]=true
        }

        for(i in 0..3){
            if(isMove[i].not()) continue
            var c = n
            repeat(kotlin.math.abs(w-i-1)){ c *=-1 }
            if(c>0){
                repeat(kotlin.math.abs(n)){
                    list[i].addFirst(list[i].removeLast())
                }
            }else{
                repeat(kotlin.math.abs(n)){
                    list[i].addLast(list[i].removeFirst())
                }
            }
        }

    }
    for(i in 0..3){
        if(list[i][0]=='1'){
            answer += 2.0.pow(i).toInt()
        }
    }
    println(answer)
}
