// https://www.acmicpc.net/problem/1786
// 2023-06-01

fun main() {
    val s = Solution()
    s.solution(readln(), readln())
}

class Solution {

    fun solution(text: String, pattern: String): Int {
        val pDubList = IntArray(pattern.length)
        val answer = mutableListOf<Int>()

        var startIndex = 1
        var size = 0
        while (startIndex + size < pattern.length) {
            if (pattern[size] == pattern[startIndex + size]) {
                pDubList[startIndex + size] = size + 1
                size++
            } else {
                if (size == 0) {
                    startIndex++
                    continue
                } else {
                    startIndex += size - pDubList[size - 1]
                    size = pDubList[size - 1]
                }
            }
        }

        var index = 0
        var matched = 0
        while (index + matched < text.length) {
            if (text[index + matched] != pattern[matched]) {
                if (matched == 0) {
                    index++
                } else {
                    index += matched - pDubList[matched - 1]
                    matched = pDubList[matched - 1]
                }
                continue
            } else {
                matched++
            }
            if (matched == pattern.length) {
                answer.add(index + 1)
                index += matched - pDubList[matched - 1]
                matched = pDubList[matched - 1]
            }
        }

        println(answer.size)
        answer.forEach {
            print("$it ")
        }
        return answer.size
    }
}
