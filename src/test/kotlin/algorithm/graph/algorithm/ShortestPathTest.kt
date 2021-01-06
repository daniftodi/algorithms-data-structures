package algorithm.graph.algorithm

import algorithm.graph.ShortestPath
import algorithm.graph.util.AdjacencyListReader
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.io.File

internal class ShortestPathTest {

    @Test
    fun compute() {
        val reader = AdjacencyListReader(File(this.javaClass.getResource("/graphs/graph1.txt").toURI()))
        val rootNode = reader.read<String>().find { it.data == "s"}
        val destination = reader.read<String>().find { it.data == "e" }

        val distance = ShortestPath().compute(rootNode!!, destination!!)

        assertThat(distance).isEqualTo(3)
    }

    @Test
    fun computeDistanceToTheSameNode() {
        val reader = AdjacencyListReader(File(this.javaClass.getResource("/graphs/graph1.txt").toURI()))
        val rootNode = reader.read<String>().find { it.data == "s"}
        val destination = reader.read<String>().find { it.data == "s" }

        val distance = ShortestPath().compute(rootNode!!, destination!!)

        assertThat(distance).isEqualTo(0)
    }

    @Test
    fun computePathDoesNotExist() {
        val reader = AdjacencyListReader(File(this.javaClass.getResource("/graphs/graph2.txt").toURI()))
        val rootNode = reader.read<String>().find { it.data == "f" }
        val destination = reader.read<String>().find { it.data == "e"}

        val distance = ShortestPath().compute(rootNode!!, destination!!)

        assertThat(distance).isEqualTo(Int.MAX_VALUE)
    }
}