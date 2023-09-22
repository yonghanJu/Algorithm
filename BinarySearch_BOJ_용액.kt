// https://www.acmicpc.net/problem/2467
// 2023-09-22

fun main() {
    val n = readln().toInt()
    val input = readln().split(' ').map { it.toInt() }

    var min = Int.MAX_VALUE
    var index1 = 0
    var index2 = 0

    for (i in input.indices) {
        var start = i + 1
        var end = input.lastIndex
        var mid = 0
        while (start <= end) {
            mid = (start + end) / 2
            if (input[i] + input[mid] == 0) {
                println("${input[i]} ${input[mid]}")
                return
            }
            if (min > Math.abs(input[i] + input[mid])) {
                min = Math.abs(input[i] + input[mid])
                index1 = i
                index2 = mid
            }
            if (input[i] + input[mid] > 0) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }
    }
    println("${input[index1]} ${input[index2]}")
}
