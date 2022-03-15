// 2022-03-15
// https://www.acmicpc.net/problem/1629

import java.io.*
import java.math.BigInteger

var A=0L
var C=0L
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (a,b,c) = readLine().split(' ').map{it.toInt()}
    A=a.toLong()
    C=c.toLong()
    print(re(b))
}
fun re(b:Int):Long {
    if(b==1) return (A%C)
    val tmp = re(b/2)
    return if(b%2==0) (tmp%C)*(tmp%C)%C else ((((tmp%C)*(A%C))%C)%C)*(tmp%C)%C
}
