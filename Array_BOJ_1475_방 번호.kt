// 2022-01-24
// https://www.acmicpc.net/problem/1475

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var arr = IntArray(10)
    var answer =0
    val n = readLine().forEach{arr[it.toString().toInt()]++}
    arr.forEachIndexed{index, it->if((index!=6 && index !=9) && answer<it) answer =it}
    val a2 = if((arr[6]+arr[9])%2==0) (arr[6]+arr[9])/2 else (arr[6]+arr[9])/2+1
    print(maxOf(answer, a2))
}
