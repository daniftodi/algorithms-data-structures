package data.structure.heap

class ArrayHeap<T : Comparable<T>>(private val comparator: Comparator<T>) : Heap<T> {
    private val list = ArrayList<T>()

    override fun add(element: T) {
        list.add(element)
        bubbleUp(list)
    }

    private fun bubbleUp(list: java.util.ArrayList<T>) {
        var currentElement = list.size - 1


        while (currentElement > 0 && comparator.compare(list[currentElement], list[currentElement / 2]) < 0) {
            val currentRoot = currentElement / 2
            val temp = list[currentElement]
            list[currentElement] = list[currentRoot]
            list[currentRoot] = temp

            currentElement = currentRoot
        }
    }

    override fun findMin(): T {
        val element = list[0]
        list[0] = list[list.size - 1]
        list.removeAt(list.size - 1)

        sink(list)

        return element
    }

    private fun sink(list: java.util.ArrayList<T>) {
        var currentElement = 1

        while (currentElement < list.size) {
            val leftNode = (2 * currentElement - 1) - 1
            val rightNode = (2 * currentElement) - 1
            if (comparator.compare(list[currentElement - 1], list[leftNode]) > 0) {
                val temp = list[currentElement - 1]
                list[currentElement - 1] = list[leftNode]
                list[leftNode] = temp

                currentElement = leftNode
            } else if (comparator.compare(list[currentElement - 1], list[rightNode]) > 0) {
                val temp = list[currentElement - 1]
                list[currentElement - 1] = list[rightNode]
                list[rightNode] = temp

                currentElement = rightNode
            } else {
                break
            }
        }
    }

    override fun size(): Int {
        return list.size
    }
}