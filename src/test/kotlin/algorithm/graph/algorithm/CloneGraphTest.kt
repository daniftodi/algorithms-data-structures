package algorithm.graph.algorithm

import algorithm.graph.BFS
import algorithm.graph.CloneGraph
import algorithm.graph.util.AdjacencyListReader
import algorithm.graph.util.Node
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.io.File
import java.util.*

internal class CloneGraphTest {

    @Test
    fun testClone() {
        val reader = AdjacencyListReader(File(this.javaClass.getResource("/graphs/graph1.txt").toURI()))
        val rootNode = reader.read<String>().find { it.data == "s" }

        val clonedGraphRoot = CloneGraph().clone(rootNode!!)

        assertThat(clonedGraphRoot === rootNode).isFalse
        assertThat(clonedGraphRoot.neighbours === rootNode.neighbours).isFalse
        assertThat(clonedGraphRoot.data).isEqualTo(rootNode.data)
        assertThat(BFS().traverse(clonedGraphRoot)).isEqualTo(BFS().traverse(rootNode))

        val visitedNodes = mutableListOf<Node<String>>()
        val stack = LinkedList<Node<String>>()

        stack.push(clonedGraphRoot)
        while (stack.isNotEmpty()) {
            val currentNode = stack.pop()
            if (!visitedNodes.contains(currentNode)) {
                visitedNodes.add(currentNode)
            }
            currentNode.neighbours.forEach {
                stack.push(it)
            }
        }
    }

    @Test
    fun testCloneFromVertexWithoutEdges() {
        val reader = AdjacencyListReader(File(this.javaClass.getResource("/graphs/graph2.txt").toURI()))
        val rootNode = reader.read<String>().find { it.data == "e" }

        val clonedGraph = CloneGraph().clone(rootNode!!)

        assertThat(clonedGraph === rootNode).isFalse
        assertThat(clonedGraph.neighbours === rootNode.neighbours).isFalse
        assertThat(clonedGraph.neighbours).hasSize(0)
        assertThat(clonedGraph.data).isEqualTo("e")
    }
}