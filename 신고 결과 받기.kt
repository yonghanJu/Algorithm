// 2022-01-21
// https://programmers.co.kr/learn/courses/30/lessons/92334

import java.util.*;

class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer: IntArray = IntArray(id_list.size){0}
        var countArr: IntArray = IntArray(id_list.size){0}
        var rep: List<List<String>> = report.map{it-> it.split(" ")} // map() 함수 이용시 기본 List 생성
        var repMap = mutableMapOf<String, MutableSet<String>>()
        
        rep.forEach{ it-> // it[0] = value(신고자), it[1] = key(피신고자)
            var repSet = repMap.getOrDefault(it[1], mutableSetOf<String>())
            if(repSet.contains(it[0])) countArr[id_list.indexOf(it[1])]--
            repSet.add(it[0])
            repMap.put(it[1], repSet)
            
            countArr[id_list.indexOf(it[1])]++
        }
        
        countArr.forEachIndexed{index, it->
            if(it>=k) {
                repMap.get(id_list[index])!!.forEach{ value->
                    answer[id_list.indexOf(value)]++
                }
            }
        }
        
        return answer
    }
}
