// 2022-01-24
// https://www.acmicpc.net/problem/3273

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val hm:MutableSet<Int> = mutableSetOf()
    val arr = readLine().split(" ").map{it:String -> it.toInt()}
    val target = readLine().toInt()
    var answer =0
    arr.forEach{hm.add(it)}
    arr.forEach{if(hm.contains(target-it)) {
        answer++
    }}
    print(answer/2)
}
