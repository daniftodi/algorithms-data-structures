package algorithm.sort

object QuickSort : SortAlgorithm {

    override fun <T : Comparable<T>> sort(array: Array<out T>) {
        array.shuffle()
        quickSort(array, 0, array.size - 1)
    }

    private fun <T : Comparable<T>> quickSort(array: Array<out T>, lo: Int, hi: Int) {
        if (lo >= hi) return
        val j = partition(array, lo, hi)
        quickSort(array, lo, j)
        quickSort(array, j + 1, hi)
    }

    private fun <T : Comparable<T>> partition(array: Array<out T>, lo: Int, hi: Int): Int {
        if (lo >= hi) return lo
        var i = lo
        var j = hi - 1
        while (true) {
            while (array[i] < array[hi]) {
                i++
                if (i >= hi) break
            }
            while (array[j] > array[hi]) {
                j--
                if (j <= lo) break
            }
            if (i >= j) break
            swap(array, i, j)
        }
        swap(array, hi, i)
        return j
    }

    private fun <T : Comparable<T>> swap(array: Array<T>, i: Int, j: Int) {
        val temp = array[j]
        array[j] = array[i]
        array[i] = temp
    }
}