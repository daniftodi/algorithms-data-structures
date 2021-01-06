package algorithm.graph

import algorithm.graph.util.Node
import java.util.*

/*
    Algorithms IlluminatedPart 2:Graph Algorithms and Data Structures
    8.2 Breadth-First Search and Shortest Paths
 */

class ShortestPath {

    fun <T> compute(root : Node<T>, destination : Node<T>) : Int {
        if (root == destination) {
            return 0
        }

        val distances = mutableMapOf<Node<T>, Int>()
        distances[root] = 0

        val visitedNodes = mutableListOf<Node<T>>()

        val queue = LinkedList<Node<T>>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val currentNode = queue.poll()
            if (!visitedNodes.contains(currentNode)) {
                visitedNodes.add(currentNode)
                currentNode.neighbours.forEach {
                    queue.add(it)
                    distances.putIfAbsent(it, distances.get(currentNode)!! + 1)
                }
            }
        }

        return if (distances[destination] != null)  distances[destination]!! else Int.MAX_VALUE;
    }

}