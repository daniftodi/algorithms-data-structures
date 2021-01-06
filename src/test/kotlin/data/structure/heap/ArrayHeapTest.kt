package data.structure.heap

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class ArrayHeapTest {

    @Test
    fun testMinHeap() {
        val minHeap = ArrayHeap<Int> { a, b -> (a - b).compareTo(0) }

        minHeap.add(0)
        minHeap.add(3)
        minHeap.add(2)
        minHeap.add(1)

        assertThat(minHeap.findMin()).isEqualTo(0)
        assertThat(minHeap.findMin()).isEqualTo(1)
        assertThat(minHeap.findMin()).isEqualTo(2)
        assertThat(minHeap.findMin()).isEqualTo(3)
    }

    @Test
    fun testMaxHeap() {
        val minHeap = ArrayHeap<Int> { a, b -> (b - a).compareTo(0) }

        minHeap.add(0)
        minHeap.add(3)
        minHeap.add(2)
        minHeap.add(1)

        assertThat(minHeap.findMin()).isEqualTo(3)
        assertThat(minHeap.findMin()).isEqualTo(2)
        assertThat(minHeap.findMin()).isEqualTo(1)
        assertThat(minHeap.findMin()).isEqualTo(0)
    }
}