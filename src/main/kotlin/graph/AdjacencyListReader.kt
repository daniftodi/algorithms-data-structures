package graph

import java.io.File

class AdjacencyListReader(val file : File) {

    fun read() : Map<String, Node<String>> {
        val nodes = mutableMapOf<String, Node<String>>()
        val fileLines = file.readLines()

        fileLines.forEach {
            val elements = it.split(" ")

            var node = Node(elements[0])
            if (!nodes.containsKey(node.data)) {
                nodes.put(node.data, node)
            } else {
                node = nodes.get(node.data)!!
            }

            elements.stream().skip(1).forEach {
                var cNode = Node(it)
                if (!nodes.containsKey(cNode.data)) {
                    nodes.put(cNode.data, cNode)
                } else {
                    cNode = nodes.get(cNode.data)!!
                }
                node.addNeighbour(cNode)
            }
        }

        return nodes
    }
}