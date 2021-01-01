package graph.algorithm

import graph.util.AdjacencyListReader
import graph.util.Node
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.io.File

internal class DFSTest {

    @Test
    fun dfsTraversal() {
        val reader = AdjacencyListReader(File(this.javaClass.getResource("/graphs/graph1.txt").toURI()))
        val rootNode = reader.read<String>().find { it.data == "s" }

        val traverseResult = DFS().traverse(rootNode!!)

        assertThat(traverseResult).flatExtracting(Node<String>::data)
            .containsExactly("s", "b", "d", "e", "c", "a")
    }

    @Test
    fun dfsTraversalExample2() {
        val reader = AdjacencyListReader(File(this.javaClass.getResource("/graphs/graph2.txt").toURI()))
        val rootNode = reader.read<String>().find { it.data == "f" }

        val traverseResult = DFS().traverse(rootNode!!)

        assertThat(traverseResult).flatExtracting(Node<String>::data)
            .containsExactly("f", "d", "c", "b", "a")
    }
}