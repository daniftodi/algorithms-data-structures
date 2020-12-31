package algorithm

import graph.AdjacencyListReader
import graph.Node
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.io.File

internal class BFSTest {

    @Test
    fun bfsTraversal() {
        val reader = AdjacencyListReader(File(this.javaClass.getResource("/graphs/graph1.txt").toURI()))
        val rootNode = reader.read().get("s")

        val traverseResult = BFS().traverse(rootNode!!)
        assertThat(traverseResult).flatExtracting(Node<String>::data)
                .containsExactly("s", "a", "b", "c", "d", "e");
    }

    @Test
    fun bfsTraversalExample2() {
        val reader = AdjacencyListReader(File(this.javaClass.getResource("/graphs/graph2.txt").toURI()))
        val rootNode = reader.read().get("f")

        val traverseResult = BFS().traverse(rootNode!!)
        assertThat(traverseResult).flatExtracting(Node<String>::data)
            .containsExactly("f", "a", "b", "c", "d");
    }
}