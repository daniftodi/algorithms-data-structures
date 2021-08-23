package algorithm.sort

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class QuickSortTest {

    @Test
    fun testElementsAreOrderedAfterSorting() {
        val inputArray = arrayOf(1, 0, 3, 2, 5, 1, -5, -8, 0, 2)
        QuickSort.sort(inputArray);
        assertThat(inputArray).isSorted
    }

    @Test
    fun testObjectsImplementingComparableAreSorted() {
        data class CustomElement(val value: Float) : Comparable<CustomElement> {
            override fun compareTo(other: CustomElement): Int {
                return this.value.compareTo(other.value)
            }
        }

        val inputArray = arrayOf(CustomElement(10.0f), CustomElement(13.2f), CustomElement(0.1f), CustomElement(15.5f))
        QuickSort.sort(inputArray)
        assertThat(inputArray).isSorted
    }

    @Test
    fun testSortingACharArray() {
        val inputArray = arrayOf('x', 'b', 'e', 'd', 'c')
        QuickSort.sort(inputArray);
        assertThat(inputArray).isSorted
    }

    @Test
    fun testWithEmptyArray() {
        val emptyArray = emptyArray<Int>()
        QuickSort.sort(emptyArray);
        assertThat(emptyArray).isSorted
    }

    @Test
    fun testWithOnlyNegativeElements() {
        val inputArrayWithNegativeOnly = arrayOf(-1, -5, -15, -100, -200, -2)
        QuickSort.sort(inputArrayWithNegativeOnly)
        assertThat(inputArrayWithNegativeOnly).isSorted
    }
}