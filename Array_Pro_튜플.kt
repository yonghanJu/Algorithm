// 2022-01-10
// https://programmers.co.kr/learn/courses/30/lessons/64065

import java.util.*;

class Solution {
    fun solution(s: String): IntArray {
        val answer = ArrayList<Int>()
        
        // 문자열을 나누기, 주의!!! MutableList로 변환해줘야 직접 가공 가능
        var stringArr: MutableList<String> = s.split("},{").toMutableList()
        stringArr[0] = stringArr[0].replace("{","")
        stringArr[stringArr.size-1] = stringArr[stringArr.size-1].replace("}","")
        
        // 나눠진 문자열 속 ',' 개수를 세어 배열에 담기
        var countArr = stringArr.map{s->s.filter { it == ',' }.count()}
        
        for( i in 0..countArr.size-1){
            stringArr[countArr.indexOf(i)].split(",").forEach{s->
                val num = s.toInt()
                if(num!= null && !answer.contains(num)) answer.add(num)
            }
        }
        
        
        // ArrayList를 IntArray형으로 변환
        return answer.toIntArray()
    }
}
