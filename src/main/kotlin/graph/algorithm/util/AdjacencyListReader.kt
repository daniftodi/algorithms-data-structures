package graph.algorithm.util

import java.io.File

class AdjacencyListReader(val file : File) {

    fun <T> read() : List<Node<T>> {
        val nodes = mutableMapOf<T, Node<T>>()
        val fileLines = file.readLines()

        fileLines.forEach {
            val elements = it.split(" ")

            var node = elementProvider<T>(elements[0])
            if (!nodes.containsKey(node.data)) {
                nodes.put(node.data, node)
            } else {
                node = nodes.get(node.data)!!
            }

            elements.stream().skip(1).forEach {
                var cNode = elementProvider<T>(it)
                if (!nodes.containsKey(cNode.data)) {
                    nodes.put(cNode.data, cNode)
                } else {
                    cNode = nodes.get(cNode.data)!!
                }
                node.addNeighbour(cNode)
            }
        }

        return nodes.values.toList()
    }

    private fun <T> elementProvider(data : String) = Node(data as T)
}