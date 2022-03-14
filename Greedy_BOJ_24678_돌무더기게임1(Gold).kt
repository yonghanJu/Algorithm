// 2022-03-14
// https://www.acmicpc.net/problem/24678

import java.io.*
import java.util.*


var answer =0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val sb = StringBuilder()
    val n = readLine().toInt()
    repeat(n){
        answer =0
        val tmp= readLine().split(' ')
        var a = tmp[0].toInt()
        var b = tmp[1].toInt()
        var c = tmp[2].toInt()
        if(b>0 && c>0){
            if(a%2==0) {
                a =2
                answer += a-2
            }
            else {
                a =1
                answer += a-1
            }
        }
        if(a>0 && c>0){
            if(b%2==0) {
                b =2
                answer += b-2
            }
            else {
                b =1
                answer += b-1
            }
        }
        if(a>0 && b>0){
            if(c%2==0) {
                c =2
                answer += c-2
            }
            else {
                c =1
                answer += c-1
            }
        }
        re(a,b,c,answer)
        sb.append(if(answer %2 ==0) 'R' else 'B').append('\n')
    }
    println(sb)
}

fun re(a:Int, b:Int, c:Int, f:Int){
    var flag =false
    if(a!=0 && b!=0){
        flag=true
        re(a-1, b-1,c+1,f+1)
    }
    if(a!=0 && c!=0){
        flag=true
        re(a-1, b+1,c-1,f+1)
    }
    if(c!=0 && b!=0){
        flag=true
        re(a+1, b-1,c-1,f+1)
    }
    if(flag.not()) answer = maxOf(answer, f)
}
