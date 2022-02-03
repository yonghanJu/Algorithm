// 2022-02-03
// https://www.acmicpc.net/problem/6588

import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var max = 0
    val arr = ArrayList<Int>()
    val primeList = ArrayList<Int>()
    val sb = StringBuilder()

    while(true){
        val num  = readLine().toInt()
        if(num==0) break else arr.add(num)
        max = if(max>num) max else num
    }

    val primeB = BooleanArray(max+1)

    for(i in 2..max){
        if(primeB[i]) continue
        primeList.add(i)
        var j =2
        while(i*j <= max){
            primeB[i*j] =true
            j++
        }
    }

    outer@for(target in arr){
        val table = BooleanArray(target+1)
        for(i in primeList){
            if(i >= target) break
            table[target-i]=true
        }

        for(it in primeList)  {
            if(table[it]){
                sb.append("$target = $it + ${target-it}\n")
                break
            }
        }
    }

    print(sb)

}
