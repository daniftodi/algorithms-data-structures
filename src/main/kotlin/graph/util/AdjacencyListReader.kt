package graph.util

import java.io.File

class AdjacencyListReader(val file : File) {

    fun <T> read(elementReader : (String) -> Node<T> = { it -> Node(it as T) }) : List<Node<T>> {
        val nodes = mutableMapOf<T, Node<T>>()
        val fileLines = file.readLines()

        fileLines.forEach {
            val elements = it.split(" ")

            var node = elementReader(elements[0])
            if (!nodes.containsKey(node.data)) {
                nodes.put(node.data, node)
            } else {
                node = nodes.get(node.data)!!
            }

            elements.stream().skip(1).forEach {
                var cNode = elementReader(it)
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
}