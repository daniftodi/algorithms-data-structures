package algorithm

import graph.AdjacencyListReader
import graph.Node
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.io.File

internal class DFSTest {

    @Test
    fun dfsTraversal() {
        val reader = AdjacencyListReader(File(this.javaClass.getResource("/graphs/graph1.txt").toURI()))
        val rootNode = reader.read().get("s")

        val traverseResult = DFS().traverse(rootNode!!)

        assertThat(traverseResult).flatExtracting(Node<String>::data)
            .containsExactly("s", "b", "d", "e", "c", "a")
    }

    @Test
    fun dfsTraversalExample2() {
        val reader = AdjacencyListReader(File(this.javaClass.getResource("/graphs/graph2.txt").toURI()))
        val rootNode = reader.read().get("f")

        val traverseResult = DFS().traverse(rootNode!!)

        assertThat(traverseResult).flatExtracting(Node<String>::data)
            .containsExactly("f", "d", "c", "b", "a")
    }
}