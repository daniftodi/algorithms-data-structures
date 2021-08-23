package algorithm.sort

interface SortAlgorithm {

    fun <T : Comparable<T>> sort(array: Array<out T>);
}