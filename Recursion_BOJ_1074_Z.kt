// 2022-03-16
// https://www.acmicpc.net/problem/1074

import java.io.*
import java.math.BigInteger
import kotlin.math.pow

var R=0
var C=0
var answer =0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n,r,c) = readLine().split(' ').map{it.toInt()}
    R=r
    C=c
    re(n,(0 until 2.0.pow(n).toInt()),(0 until 2.0.pow(n).toInt()))
}

fun re(n:Int, xR:IntRange, yR:IntRange){
    if(xR.first==xR.last) {
        if(R==xR.last && C==yR.first) println(answer)
        return
    }
    val p = 2.0.pow(n-1).toInt()
    if(R in xR.first until xR.first+p && C in yR.first until yR.first+p){
        re(n-1, xR.first until xR.first+p , yR.first until yR.first+p)
    }
    else if(R in xR.first until xR.first+p  && C in yR.first+p .. yR.last){
        answer += p*p
        re(n-1,  xR.first until xR.first+p  ,yR.first+p .. yR.last)
    }else if(R in xR.first+p .. xR.last && C in yR.first until yR.first+p){
        answer +=  p*p*2
        re(n-1,  xR.first+p .. xR.last ,yR.first until yR.first+p)
    }else if(R in  xR.first+p .. xR.last && C in  yR.first+p .. yR.last){
        answer +=  p*p*3
        re(n-1,   xR.first+p .. xR.last, yR.first+p .. yR.last)
    }
}
