package graph

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.io.File

internal class AdjacencyListReaderTest {

    @Test
    fun testReadFromFileExample1() {
        val reader = AdjacencyListReader(File(this.javaClass.getResource("/graphs/graph1.txt").toURI()))
        val rootNode = reader.read()

        assertThat(rootNode).isNotNull
        assertThat(rootNode.get("s")?.neighbours).hasSize(2)
        assertThat(rootNode.get("s")?.neighbours)
            .flatExtracting(Node<String>::data)
            .containsExactlyInAnyOrder("a", "b")
        assertThat(rootNode.get("a")?.neighbours)
            .flatExtracting(Node<String>::data)
            .containsExactlyInAnyOrder("s", "c", "d")
    }

    @Test
    fun testReadFromFileExample2() {
        val reader = AdjacencyListReader(File(this.javaClass.getResource("/graphs/graph2.txt").toURI()))
        val rootNode = reader.read()

        assertThat(rootNode).isNotNull
        assertThat(rootNode.get("f")?.neighbours).hasSize(4)
        assertThat(rootNode.get("f")?.neighbours).flatExtracting(Node<String>::data)
            .containsExactlyInAnyOrder("a", "b", "c", "d")
    }

    @Test
    fun testReadFromFileEmptyGraph() {
        val reader = AdjacencyListReader(File(this.javaClass.getResource("/graphs/graph3.txt").toURI()))
        val rootNode = reader.read()

        assertThat(rootNode).isEmpty()
    }

}