// 2022-03-12
// https://www.acmicpc.net/problem/1062

import java.io.*
import java.util.*

var answer =0
var K=0
var N =0
lateinit var cList:BooleanArray
lateinit var l:List<Char>
lateinit var list:Array<String>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n,k)=readLine().split(' ').map{it.toInt()}

    K=k
    N=n
    list = Array(n){val tmp = readLine()
        tmp.substring(4, tmp.length-4) }

    cList = BooleanArray(26).apply {
        set(0,true)
        set('n'-'a',true)
        set('t'-'a',true)
        set('i'-'a',true)
        set('c'-'a',true)
    }

    var bfSet = sortedSetOf(compareBy<Char>{it})

    list.forEach {
        for(c in it) if(cList[c-'a'].not()) bfSet.add(c)
    }

    if(k<5) return println(0)
    if(bfSet.size==0 || k==5) {
        var cnt = n
        list.forEach { str->
            for(c in str) {
                if(cList[c-'a'].not()) {
                    cnt--
                    break
                }
            }
        }
        return println(cnt)
    }
    l = bfSet.toList()
    l.forEachIndexed {index,_-> bf(index,1) }
    print(answer)
}

fun bf(index:Int, depth:Int){
    cList[l[index]-'a']=true

    if(depth==K-5 || index==l.lastIndex){
        sol()
        cList[l[index]-'a']=false
        return

    }
    cList[l[index]-'a']=true

    for(i in index+1..l.lastIndex){
        bf(i,depth+1)
    }

    cList[l[index]-'a']=false
}

fun sol(){
    var cnt =N
    list.forEach { str->
        for( c in str){
            if(cList[c-'a'].not()){
                cnt--
                break
            }
        }
    }
    answer = maxOf(answer, cnt)
}
