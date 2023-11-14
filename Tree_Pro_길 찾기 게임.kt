import java.util.*

class Solution {
    var size = 2
    fun solution(nodeinfo: Array<IntArray>): Array<IntArray> {
        val sorted = nodeinfo.toList().mapIndexed{ idx, it ->
            it + listOf(idx + 1) }.sortedBy { it[0] }
        var rNode = Node(sorted[0][2], sorted[0][0], sorted[0][1])
        var rootNode = rNode
        for(i in 1..sorted.lastIndex) {
            val newNode = Node(sorted[i][2], sorted[i][0], sorted[i][1])
            if(rNode.y > newNode.y) {
                newNode.parent = rNode
                rNode.right = newNode
                rNode = newNode
            } else {
                while(rNode?.parent != null && rNode.y < newNode.y) {
                    rNode = rNode.parent!!
                }
                if(rNode.parent == null && rNode.y < newNode.y) {
                    newNode.left = rNode
                    rNode.parent = newNode
                    rNode = newNode
                    rootNode = newNode
                } else {
                    newNode.parent = rNode
                    newNode.left = rNode.right
                    rNode.right = newNode
                    rNode = newNode
                }
            }
        }
        
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()
        preOrder(rootNode, list1)
        postOrder(rootNode, list2)
        var answer = arrayOf<IntArray>(list1.toIntArray(), list2.toIntArray())
        return answer
    }
    
    fun preOrder(node: Node, list: MutableList<Int>) {
        list.add(node.num)
        node.left?.let { preOrder(it, list) }
        node.right?.let { preOrder(it, list) }
    }
    
    fun postOrder(node: Node, list: MutableList<Int>) {
        node.left?.let { postOrder(it, list) }
        node.right?.let { postOrder(it, list) }
        list.add(node.num)
    }
}

data class Node(
    val num: Int,
    val x: Int,
    val y: Int,
    var parent: Node? = null,
    var right: Node? = null,
    var left: Node? = null,
)
