// 2022-11-19
// https://www.acmicpc.net/problem/5373

class Solution {
    fun solution(num: Int, opList: List<OP>) {
        val diceMap = mutableMapOf<Char, DiceDimension>().apply {
            set('U', DiceDimension('w'))
            set('D', DiceDimension('y'))
            set('F', DiceDimension('r'))
            set('B', DiceDimension('o'))
            set('L', DiceDimension('g'))
            set('R', DiceDimension('b'))
        }

        repeat(num) {
            rotate(opList[it].dimension, opList[it].direction, diceMap)
        }

        print(diceMap['U']!!.colorList[trans(diceMap['U']!!.status, 1)])
        print(diceMap['U']!!.colorList[trans(diceMap['U']!!.status, 2)])
        print(diceMap['U']!!.colorList[trans(diceMap['U']!!.status, 3)])
        println()
        print(diceMap['U']!!.colorList[trans(diceMap['U']!!.status, 4)])
        print(diceMap['U']!!.colorList[trans(diceMap['U']!!.status, 5)])
        print(diceMap['U']!!.colorList[trans(diceMap['U']!!.status, 6)])
        println()
        print(diceMap['U']!!.colorList[trans(diceMap['U']!!.status, 7)])
        print(diceMap['U']!!.colorList[trans(diceMap['U']!!.status, 8)])
        print(diceMap['U']!!.colorList[trans(diceMap['U']!!.status, 9)])
        println()
    }
}

fun main() {
    repeat(readLine()!!.toInt()) {
        Solution().solution(readLine()!!.toInt(), readLine()!!.split(" ").map { OP(it[0], it[1]) })
    }
}

data class OP(val dimension: Char, val direction: Char)

data class DiceDimension(
    private val initColor: Char,
    val colorList: MutableList<Char> = List(10) { initColor }.toMutableList(),
    var status: Int = 0
)

fun rotate(dimension: Char, direction: Char, diceMap: Map<Char, DiceDimension>) {
    val (dimList, rotateIndexList) = getSideDimensions(dimension) // dimension  시계 방향으로 각 4개의 면


    val tmp = listOf(
        diceMap[dimList[0]]!!.colorList[trans(diceMap[dimList[0]]!!.status, rotateIndexList[0][0])],
        diceMap[dimList[0]]!!.colorList[trans(diceMap[dimList[0]]!!.status, rotateIndexList[0][1])],
        diceMap[dimList[0]]!!.colorList[trans(diceMap[dimList[0]]!!.status, rotateIndexList[0][2])]
    )
    if (direction == '+') {

        diceMap[dimList[0]]!!.colorList[trans(diceMap[dimList[0]]!!.status, rotateIndexList[0][0])] = diceMap[dimList[3]]!!.colorList[trans(diceMap[dimList[3]]!!.status, rotateIndexList[3][0])]
        diceMap[dimList[0]]!!.colorList[trans(diceMap[dimList[0]]!!.status, rotateIndexList[0][1])] = diceMap[dimList[3]]!!.colorList[trans(diceMap[dimList[3]]!!.status, rotateIndexList[3][1])]
        diceMap[dimList[0]]!!.colorList[trans(diceMap[dimList[0]]!!.status, rotateIndexList[0][2])] = diceMap[dimList[3]]!!.colorList[trans(diceMap[dimList[3]]!!.status, rotateIndexList[3][2])]


        diceMap[dimList[3]]!!.colorList[trans(diceMap[dimList[3]]!!.status, rotateIndexList[3][0])] = diceMap[dimList[2]]!!.colorList[trans(diceMap[dimList[2]]!!.status, rotateIndexList[2][0])]
        diceMap[dimList[3]]!!.colorList[trans(diceMap[dimList[3]]!!.status, rotateIndexList[3][1])] = diceMap[dimList[2]]!!.colorList[trans(diceMap[dimList[2]]!!.status, rotateIndexList[2][1])]
        diceMap[dimList[3]]!!.colorList[trans(diceMap[dimList[3]]!!.status, rotateIndexList[3][2])] = diceMap[dimList[2]]!!.colorList[trans(diceMap[dimList[2]]!!.status, rotateIndexList[2][2])]


        diceMap[dimList[2]]!!.colorList[trans(diceMap[dimList[2]]!!.status, rotateIndexList[2][0])] = diceMap[dimList[1]]!!.colorList[trans(diceMap[dimList[1]]!!.status, rotateIndexList[1][0])]
        diceMap[dimList[2]]!!.colorList[trans(diceMap[dimList[2]]!!.status, rotateIndexList[2][1])] = diceMap[dimList[1]]!!.colorList[trans(diceMap[dimList[1]]!!.status, rotateIndexList[1][1])]
        diceMap[dimList[2]]!!.colorList[trans(diceMap[dimList[2]]!!.status, rotateIndexList[2][2])] = diceMap[dimList[1]]!!.colorList[trans(diceMap[dimList[1]]!!.status, rotateIndexList[1][2])]


        diceMap[dimList[1]]!!.colorList[trans(diceMap[dimList[1]]!!.status, rotateIndexList[1][0])] = tmp[0]
        diceMap[dimList[1]]!!.colorList[trans(diceMap[dimList[1]]!!.status, rotateIndexList[1][1])] = tmp[1]
        diceMap[dimList[1]]!!.colorList[trans(diceMap[dimList[1]]!!.status, rotateIndexList[1][2])] = tmp[2]

    } else {

        diceMap[dimList[0]]!!.colorList[trans(diceMap[dimList[0]]!!.status, rotateIndexList[0][0])] = diceMap[dimList[1]]!!.colorList[trans(diceMap[dimList[1]]!!.status, rotateIndexList[1][0])]
        diceMap[dimList[0]]!!.colorList[trans(diceMap[dimList[0]]!!.status, rotateIndexList[0][1])] = diceMap[dimList[1]]!!.colorList[trans(diceMap[dimList[1]]!!.status, rotateIndexList[1][1])]
        diceMap[dimList[0]]!!.colorList[trans(diceMap[dimList[0]]!!.status, rotateIndexList[0][2])] = diceMap[dimList[1]]!!.colorList[trans(diceMap[dimList[1]]!!.status, rotateIndexList[1][2])]


        diceMap[dimList[1]]!!.colorList[trans(diceMap[dimList[1]]!!.status, rotateIndexList[1][0])] = diceMap[dimList[2]]!!.colorList[trans(diceMap[dimList[2]]!!.status, rotateIndexList[2][0])]
        diceMap[dimList[1]]!!.colorList[trans(diceMap[dimList[1]]!!.status, rotateIndexList[1][1])] = diceMap[dimList[2]]!!.colorList[trans(diceMap[dimList[2]]!!.status, rotateIndexList[2][1])]
        diceMap[dimList[1]]!!.colorList[trans(diceMap[dimList[1]]!!.status, rotateIndexList[1][2])] = diceMap[dimList[2]]!!.colorList[trans(diceMap[dimList[2]]!!.status, rotateIndexList[2][2])]


        diceMap[dimList[2]]!!.colorList[trans(diceMap[dimList[2]]!!.status, rotateIndexList[2][0])] = diceMap[dimList[3]]!!.colorList[trans(diceMap[dimList[3]]!!.status, rotateIndexList[3][0])]
        diceMap[dimList[2]]!!.colorList[trans(diceMap[dimList[2]]!!.status, rotateIndexList[2][1])] = diceMap[dimList[3]]!!.colorList[trans(diceMap[dimList[3]]!!.status, rotateIndexList[3][1])]
        diceMap[dimList[2]]!!.colorList[trans(diceMap[dimList[2]]!!.status, rotateIndexList[2][2])] = diceMap[dimList[3]]!!.colorList[trans(diceMap[dimList[3]]!!.status, rotateIndexList[3][2])]


        diceMap[dimList[3]]!!.colorList[trans(diceMap[dimList[3]]!!.status, rotateIndexList[3][0])] = tmp[0]
        diceMap[dimList[3]]!!.colorList[trans(diceMap[dimList[3]]!!.status, rotateIndexList[3][1])] = tmp[1]
        diceMap[dimList[3]]!!.colorList[trans(diceMap[dimList[3]]!!.status, rotateIndexList[3][2])] = tmp[2]
    }

    diceMap[dimension]!!.status += if (direction == '+') 5 else 3
    diceMap[dimension]!!.status %= 4
}

fun getSideDimensions(dimension: Char): Pair<List<Char>, List<List<Int>>> { // 바라봤을 때 12시부터 시작해서 시계방향으로
    return when (dimension) {
        'U' -> Pair(
            listOf('B', 'R', 'F', 'L'),
            listOf(listOf(7, 8, 9), listOf(3,2,1), listOf(3,2,1), listOf(3,2,1))
        )
        'D' -> Pair(
            listOf('F', 'R', 'B', 'L'),
            listOf(listOf(7, 8, 9), listOf(7, 8, 9), listOf(3,2,1), listOf(7,8,9))
        )
        'F' -> Pair(
            listOf('U', 'R', 'D', 'L'),
            listOf(listOf(7, 8, 9), listOf(1, 4, 7), listOf(3,2,1), listOf(9,6,3))
        )
        'B' -> Pair(
            listOf('U', 'L', 'D', 'R'),
            listOf(listOf(3, 2, 1), listOf(1, 4, 7), listOf(7, 8, 9), listOf(9,6,3))
        )
        'L' -> Pair(
            listOf('U', 'F', 'D', 'B'),
            listOf(listOf(1, 4, 7), listOf(1, 4, 7), listOf(1, 4, 7), listOf(1, 4, 7))
        )
        'R' -> Pair(
            listOf('U', 'B', 'D', 'F'),
            listOf(listOf(3, 6, 9), listOf(3, 6, 9), listOf(3, 6, 9), listOf(3, 6, 9))
        )
        else -> Pair(listOf(), listOf())
    }
}

fun trans(status: Int, index: Int): Int {
    when (status) {
        1 -> {
            return when (index) {
                1 -> 7
                2 -> 4
                3 -> 1
                4 -> 8
                5 -> 5
                6 -> 2
                7 -> 9
                8 -> 6
                else -> 3
            }
        }
        2 -> {
            return when (index) {
                1 -> 9
                2 -> 8
                3 -> 7
                4 -> 6
                5 -> 5
                6 -> 4
                7 -> 3
                8 -> 2
                else -> 1
            }
        }
        3 -> {
            return when (index) {
                1 -> 3
                2 -> 6
                3 -> 9
                4 -> 2
                5 -> 5
                6 -> 8
                7 -> 1
                8 -> 4
                else -> 7
            }
        }
        0 -> return index
    }
    return -1
}
