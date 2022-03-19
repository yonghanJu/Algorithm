// 2022-03-19
// https://www.acmicpc.net/problem/14956

import java.io.*
import java.math.BigInteger
import kotlin.math.pow

var cur = 0
var n =0
var target =0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    readLine().let{
        val tmp = it.split(' ')
        n= tmp[0].toInt()
        target = tmp[1].toInt()
    }

    re(0,0, n, 1)

}

fun re(x:Int, y:Int, size:Int, dir:Int){
    if(size == 1){
        println("${x+1} ${y+1}")
        return
    }
    for(i in 1..4){
        if(cur+(size*size)/4 < target) cur+=(size*size)/4
        else{
            when(dir){
                1->{ // 현재 위를 보고 있음
                    when(i){
                        1 -> re(x,y,size/2, 2)
                        2 -> re(x,y+size/2,size/2,1)
                        3 -> re(x+size/2,y+size/2, size/2,1)
                        4 -> re(x+size-1,y+size/2-1, size/2,4)
                    }
                }
                2->{ // 현재 오른쪽
                    when(i){
                        1 -> re(x,y,size/2, 1)
                        2 -> re(x+size/2,y,size/2,2)
                        3 -> re(x+size/2,y+size/2, size/2,2)
                        4 -> re(x+size/2-1,y+size-1, size/2,3)
                    }
                }
                3->{ //현재 아래
                    when(i){
                        1 -> re(x,y,size/2, 4)
                        2 -> re(x,y-size/2,size/2,3)
                        3 -> re(x-size/2,y-size/2, size/2,3)
                        4 -> re(x-size+1,y-size/2+1, size/2,2)
                    }
                }
                4->{ // 현재 왼쪽
                    when(i){
                        1 -> re(x,y,size/2, 3)
                        2 -> re(x-size/2,y,size/2,4)
                        3 -> re(x-size/2,y-size/2, size/2,4)
                        4 -> re(x-size/2+1,y-size+1, size/2,1)
                    }
                }
            }
            break
        }
    }
}
