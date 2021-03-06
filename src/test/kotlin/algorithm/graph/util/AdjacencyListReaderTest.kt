package algorithm.graph.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.io.File

internal class AdjacencyListReaderTest {

    @Test
    fun testReadFromFileExample1() {
        val reader = AdjacencyListReader(File(this.javaClass.getResource("/graphs/graph1.txt").toURI()))
        val rootNode = reader.read<String>()

        assertThat(rootNode).isNotNull
        assertThat(rootNode.find { it.data == "s" }?.neighbours).hasSize(2)
        assertThat(rootNode.find { it.data == "s" }?.neighbours)
            .flatExtracting(Node<String>::data)
            .containsExactlyInAnyOrder("a", "b")
        assertThat(rootNode.find { it.data == "a" }?.neighbours)
            .flatExtracting(Node<String>::data)
            .containsExactlyInAnyOrder("s", "c", "d")
    }

    @Test
    fun testReadFromFileExample2() {
        val reader = AdjacencyListReader(File(this.javaClass.getResource("/graphs/graph2.txt").toURI()))
        val rootNode = reader.read<String>()

        assertThat(rootNode).isNotNull
        assertThat(rootNode.find { it.data == "f" }?.neighbours).hasSize(4)
        assertThat(rootNode.find { it.data == "f" }?.neighbours).flatExtracting(Node<String>::data)
            .containsExactlyInAnyOrder("a", "b", "c", "d")
    }

    @Test
    fun testReadFromFileEmptyGraph() {
        val reader = AdjacencyListReader(File(this.javaClass.getResource("/graphs/graph3.txt").toURI()))
        val rootNode = reader.read<String>()

        assertThat(rootNode).isEmpty()
    }

    @Test
    fun testReadWithIntVertexValues() {
        val reader = AdjacencyListReader(File(this.javaClass.getResource("/graphs/graph4.txt").toURI()))
        val adjacencyList = reader.read<Int>{
            Node(Integer.valueOf(it))
        }

        assertThat(adjacencyList).isNotNull
        assertThat(adjacencyList.find { it.data == 1 }?.neighbours).hasSize(2)
        assertThat(adjacencyList.find { it.data == 1 }?.neighbours).flatExtracting(Node<Int>::data)
            .containsExactlyInAnyOrder(3, 5)
    }

}