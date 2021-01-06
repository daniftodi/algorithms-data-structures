package algorithm.graph.algorithm

import algorithm.graph.TopologicalSort
import algorithm.graph.util.AdjacencyListReader
import algorithm.graph.util.Node
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.io.File

internal class TopologicalSortTest {

    @Test
    fun sortGraph6() {
        val reader = AdjacencyListReader(File(this.javaClass.getResource("/graphs/graph6.txt").toURI()))
        val adjacencyList = reader.read<String>()

        val topologicalOrder = TopologicalSort().sort(adjacencyList)

        assertThat(topologicalOrder).flatExtracting(Node<String>::data)
            .containsExactly("e", "c", "d", "a", "b", "s")
    }

    @Test
    fun sortGraph5() {
        val reader = AdjacencyListReader(File(this.javaClass.getResource("/graphs/graph5.txt").toURI()))
        val adjacencyList = reader.read<Int> {
            Node(Integer.valueOf(it))
        }

        val topologicalOrder = TopologicalSort().sort(adjacencyList)

        assertThat(topologicalOrder).flatExtracting(Node<Int>::data)
            .containsExactly(2, 9, 10, 11, 5, 8, 7, 3)
    }
}