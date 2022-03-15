// 2022-03-15
// https://www.acmicpc.net/problem/1914

import java.io.*
import java.math.BigInteger
import java.util.*
import kotlin.math.pow

lateinit var bw:BufferedWriter
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    bw = BufferedWriter(OutputStreamWriter(System.`out`))
    if(n>20){
        var num =BigInteger("1")
        for(i in 1..n){
            num = num.multiply(BigInteger("2"))
        }
        num = num.minus(BigInteger("1"))
        bw.write("$num\n")
    }else{
        bw.write("${2.toDouble().pow(n).toInt()-1}\n")
        re(n,'1','2','3')
    }
    bw.flush()
    bw.close()
}

fun re(n:Int, from:Char, middle:Char, to:Char){
    if(n==1){
        bw.write("$from $to\n")
    }else{
        re(n-1, from, to, middle)
        re(1,from,middle,to)
        re(n-1,middle,from,to)
    }
}
