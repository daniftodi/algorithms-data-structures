package algorithm.graph

import algorithm.graph.util.Node
import java.util.*

/*
    Algorithms IlluminatedPart 2:Graph Algorithms and Data Structures
    8.2 Breadth-First Search and Shortest Paths
 */

class BFS {
    fun <T> traverse(s: Node<T>) : List<Node<T>> {
        val traversalOrder = mutableListOf<Node<T>>()
        val visitedNodes = mutableListOf<Node<T>>()
        val queue = LinkedList<Node<T>>()
        queue.add(s)
        visitedNodes.add(s)

        while (queue.isNotEmpty()) {
            val currentNode = queue.poll()
            currentNode.neighbours.forEach {
                if (!visitedNodes.contains(it)) {
                    visitedNodes.add(it)
                    queue.add(it)
                }
            }
            traversalOrder.add(currentNode)
        }

        return traversalOrder
    }
}

