package data.structure.heap

interface Heap<T> {

    fun add(element: T)
    fun findFirst(): T
    fun size(): Int
}
