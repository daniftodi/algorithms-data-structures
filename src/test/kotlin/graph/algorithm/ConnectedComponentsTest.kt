package graph.algorithm

import graph.util.AdjacencyListReader
import graph.util.Node
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.io.File

internal class ConnectedComponentsTest {

    @Test
    fun connectedComponentsGraph1() {
        val reader = AdjacencyListReader(File(this.javaClass.getResource("/graphs/graph1.txt").toURI()))
        val adjacencyList = reader.read<String>()
        val connectedComponents = ConnectedComponents().connectedComponents(adjacencyList)

        assertThat(connectedComponents).hasSize(1)
        assertThat(findRootFor(connectedComponents, Node("s")))
            .flatExtracting(Node<String>::data)
            .containsExactlyInAnyOrder("s", "a", "b", "c", "d", "e")
    }

    @Test
    fun connectedComponentsRootsGraph1() {
        val reader = AdjacencyListReader(File(this.javaClass.getResource("/graphs/graph1.txt").toURI()))
        val adjacencyList = reader.read<String>()
        val connectedComponents = ConnectedComponents().connectedComponentsRoots(adjacencyList)

        assertThat(connectedComponents).hasSize(1)
        assertThat(connectedComponents).flatExtracting(Node<String>::data).containsExactly("s")
    }

    @Test
    fun connectedComponentsTwoDistinctGraphs() {
        val reader = AdjacencyListReader(File(this.javaClass.getResource("/graphs/graph2.txt").toURI()))
        val adjacencyList = reader.read<String>()
        val connectedComponents = ConnectedComponents().connectedComponents(adjacencyList)

        assertThat(connectedComponents).hasSize(2)
        assertThat(findRootFor(connectedComponents, Node("f")))
            .flatExtracting(Node<String>::data)
            .containsExactlyInAnyOrder("f", "a", "b", "c", "d")

        assertThat(findRootFor(connectedComponents, Node("e")))
            .flatExtracting(Node<String>::data)
            .containsExactlyInAnyOrder("e")
    }

    @Test
    fun connectedComponentsRoots() {
        val reader = AdjacencyListReader(File(this.javaClass.getResource("/graphs/graph2.txt").toURI()))
        val adjacencyList = reader.read<String>()
        val connectedComponents = ConnectedComponents().connectedComponentsRoots(adjacencyList)

        assertThat(connectedComponents).hasSize(2)
        assertThat(connectedComponents).flatExtracting(Node<String>::data).containsExactly("f", "e")
    }

    @Test
    fun connectedComponentsGraph4() {
        val reader = AdjacencyListReader(File(this.javaClass.getResource("/graphs/graph4.txt").toURI()))
        val adjacencyList = reader.read<Int>{
            Node(Integer.valueOf(it))
        }

        val connectedComponents = ConnectedComponents().connectedComponentsRoots(adjacencyList)

        assertThat(connectedComponents).hasSize(3)
        assertThat(connectedComponents).flatExtracting(Node<Int>::data).containsExactly(1, 2, 8)
    }

    private fun findRootFor(connectedComponents: Set<Set<Node<String>>>, elementToFind: Node<String>) =
        connectedComponents.filter {
            it.stream().filter { it == elementToFind }
                .findFirst().isPresent
        }.first()
}