package algorithm.graph.algorithm

import algorithm.graph.BFS
import algorithm.graph.util.AdjacencyListReader
import algorithm.graph.util.Node
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.io.File

internal class BFSTest {

    @Test
    fun bfsTraversal() {
        val reader = AdjacencyListReader(File(this.javaClass.getResource("/graphs/graph1.txt").toURI()))
        val rootNode = reader.read<String>().find { it.data == "s" }

        val traverseResult = BFS().traverse(rootNode!!)
        assertThat(traverseResult).flatExtracting(Node<String>::data)
            .containsExactly("s", "a", "b", "c", "d", "e");
    }

    @Test
    fun bfsTraversalExample2() {
        val reader = AdjacencyListReader(File(this.javaClass.getResource("/graphs/graph2.txt").toURI()))
        val rootNode = reader.read<String>().find { it.data == "f" }

        val traverseResult = BFS().traverse(rootNode!!)
        assertThat(traverseResult).flatExtracting(Node<String>::data)
            .containsExactly("f", "a", "b", "c", "d");
    }
}