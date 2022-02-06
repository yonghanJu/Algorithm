// 2022-02-05
// https://www.acmicpc.net/problem/1644

import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val target = readLine().toInt()
    if(target==1) print(0).run{return}
    val checkArr = BooleanArray(target+1)
    val primeList = ArrayList<Int>()

    var start=0
    var end=0
    var sum =0
    var answer =0
    var size = 0

    for(i in 2..target){
        if(checkArr[i]) continue
        primeList.add(i)
        var j = 2
        while(i*j<=target){
            checkArr[i*j]=true
            j++
        }
    }

    size = primeList.size
    sum = primeList[0]
    while(start<size-1 && end<size-1){
        if(sum<target){
            if(end != size-1){
                end++
                sum +=primeList[end]
            }
        }else if(sum>target){
            if(start != size-1){
                sum -=primeList[start]
                start++
            }
        }else if(start == end){
            answer++
            break
        }else{
            answer++
            if(end != size-1){
                end++
                sum +=primeList[end]
            }
        }
    }
    if(end==size-1 && primeList[end]==target) answer++
    print(answer)
}
