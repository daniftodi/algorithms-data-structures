package graph.algorithm

import graph.algorithm.util.Node
import java.util.*

class CloneGraph {

    fun <T> clone(root: Node<T>): Node<T> {
        val adjacencyList = mutableListOf<Node<T>>()

        val queue = LinkedList<Node<T>>()
        queue.add(root)

        val visitedNodes = mutableListOf<Node<T>>()

        while (queue.isNotEmpty()) {
            val currentNode = queue.poll()
            var newNode = Node(currentNode.data)

            if (!adjacencyList.contains(newNode)) {
                adjacencyList.add(newNode)
            } else {
                newNode = adjacencyList.find { it == newNode }!!
            }

            if (!visitedNodes.contains(currentNode)) {
                visitedNodes.add(currentNode)
                currentNode.neighbours.forEach {
                    val edgeTo = Node(it.data)

                    if (!adjacencyList.contains(edgeTo)) {
                        adjacencyList.add(edgeTo)
                    }

                    newNode.addNeighbour(edgeTo)
                    queue.add(it)
                }
            }
        }

        return adjacencyList.find { it.data == root.data }!!
    }
}