// 2022-01-21
// https://programmers.co.kr/learn/courses/30/lessons/92334

import java.util.*;

class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray =
    report.map { it.split(" ") }    // report를 신고자와 피신고자로 나눔
        .groupBy { it[1] }          // 피신고자가 key, report들의 배열이 value인 Map 생성
        .map { it.value.distinct() }// value(같은 유저를 신고한 report 배열) 의 중복신고를 제거
        .filter { it.size >= k }    // 중복을 제거하고 일정 신고건 이상의 배열만 남음
        .flatten() //컬렉션 안에 컬렉션이 들어있는 중첩 컬렉션을 펼처서 하나의 컬렉션으로 만들어줍니다.
        .map { it[0] }
        .groupingBy { it }
        .eachCount()
        .run { id_list.map { getOrDefault(it, 0) }.toIntArray() }
}
