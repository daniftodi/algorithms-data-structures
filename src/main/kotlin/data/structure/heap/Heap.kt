package data.structure.heap

interface Heap<T> {

    fun add(element: T)
    fun findMin(): T
    fun size(): Int
}
