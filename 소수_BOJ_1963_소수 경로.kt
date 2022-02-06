// 2022-02-06
// https://www.acmicpc.net/problem/1963

import java.io.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

lateinit var checkArr:BooleanArray
lateinit var primeList:LinkedList<String>
lateinit var primeMap:HashMap<String,Int>

fun bfs(start:String,target:String):String{

    val map = HashMap<String,Int>()
    val queue:Queue<Pair<String,Int>> = LinkedList()

    queue.add(Pair(start,0))

    while(!queue.isEmpty()){
        val cur = queue.poll()

        if(cur.first==target) return cur.second.toString()
        map[cur.first]=1

        for(index in 0..3){
            for(n in 0..9){
                var tmp = cur.first.toCharArray()
                tmp[index] = '0'+n
                
                val ns = String(tmp)
                if( primeMap.getOrDefault(ns,-1) == -1 || map.getOrDefault(ns,0)==1) continue
                queue.add(Pair(ns,cur.second+1))
            }
        }
    }
    return "Impossible"
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val n = readLine().toInt()
    val answer = MutableList(n){""}
    checkArr = BooleanArray(10001)
    primeList = LinkedList<String>()
    primeMap = HashMap()

    for(i in 2..9999){
        if(checkArr[i]) continue
        if(i>1000){
            primeList.add(i.toString())
            primeMap[i.toString()] = primeList.size-1
        }
        var j =2
        while(i*j<=9999){
            checkArr[i*j] = true
            j++
        }
    }

    repeat(n){
        val str = readLine().split(' ')
        answer[it] = bfs(str[0],str[1])
    }
    repeat(n){
        println(answer[it])
    }
}
