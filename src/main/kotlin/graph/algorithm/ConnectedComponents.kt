package graph.algorithm

import graph.algorithm.util.Node
import java.util.*

class ConnectedComponents {

    fun <T> connectedComponents(adjacencyList: List<Node<T>>): Set<Set<Node<T>>> {
        val visitedNodes = mutableListOf<Node<T>>()
        val connectedComponentsList = mutableSetOf<Set<Node<T>>>()
        adjacencyList.forEach {
            val connectedComponents = bfs(it, visitedNodes)
            if (connectedComponents.isNotEmpty()) {
                connectedComponentsList.add(connectedComponents.toSet())
            }

        }

        return connectedComponentsList
    }

    fun <T> connectedComponentsRoots(adjacencyList: List<Node<T>>): Set<Node<T>> {
        val visitedNodes = mutableListOf<Node<T>>()
        val connectedComponentsRoots = mutableSetOf<Node<T>>()
        adjacencyList.forEach {
            val connectedComponents = bfs(it, visitedNodes)
            if (connectedComponents.isNotEmpty()) {
                connectedComponentsRoots.add(connectedComponents.first())
            }

        }

        return connectedComponentsRoots
    }

    private fun <T> bfs(rootNode: Node<T>, visitedNodes: MutableList<Node<T>>): List<Node<T>> {
        val queue = LinkedList<Node<T>>()
        queue.add(rootNode)
        val connectedComponents = mutableListOf<Node<T>>()
        while (queue.isNotEmpty()) {
            val currentNode = queue.poll()

            if (!visitedNodes.contains(currentNode)) {
                visitedNodes.add(currentNode)
                if (!connectedComponents.contains(currentNode)) {
                    connectedComponents.add(currentNode)
                }

                currentNode.neighbours.forEach {
                    if (!visitedNodes.contains(it)) {
                        connectedComponents.add(it)
                        queue.add(it)
                    }
                }
            }
        }

        return connectedComponents
    }

}