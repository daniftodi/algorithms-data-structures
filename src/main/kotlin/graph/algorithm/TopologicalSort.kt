package graph.algorithm

import graph.util.Node

/*
    Does not check if graph is acyclic, does not work for cyclic graphs
    https://en.wikipedia.org/wiki/Topological_sorting

    Algorithms IlluminatedPart 2:Graph Algorithms and Data Structures
    8.5 Topological Sort
 */

class TopologicalSort {

    fun <T> sort(adjacencyList: List<Node<T>>): List<Node<T>> {

        val visitedNodes = mutableListOf<Node<T>>()
        val topologicalOrder = mutableListOf<Node<T>>()

        adjacencyList.forEach {
            if (!visitedNodes.contains(it)) {
                dfsTopological(it, visitedNodes, topologicalOrder)
                topologicalOrder.add(it)
            }
        }

        return topologicalOrder
    }

    private fun <T> dfsTopological(
        rootNode: Node<T>,
        visitedNodes: MutableList<Node<T>>,
        topologicalOrder: MutableList<Node<T>>
    ) {
        rootNode.neighbours.forEach {
            if (!visitedNodes.contains(it)) {
                visitedNodes.add(it)
                dfsTopological(it, visitedNodes, topologicalOrder)
                topologicalOrder.add(it)
            }
        }
    }
}