package graph.algorithm

import graph.util.Node
import java.util.*

class DFS {
    fun <T> traverse(s : Node<T>) : List<Node<T>> {
        val traversalOrder = mutableListOf<Node<T>>()
        val visitedNodes = mutableListOf<Node<T>>()
        val stack = LinkedList<Node<T>>()

        stack.push(s)
        visitedNodes.add(s)

        while (stack.isNotEmpty()) {
            val currentNode = stack.pop()
            currentNode.neighbours.forEach {
                if (!visitedNodes.contains(it)) {
                    visitedNodes.add(it)
                    stack.push(it)
                }
            }
            traversalOrder.add(currentNode)
        }

        return traversalOrder;
    }
}
