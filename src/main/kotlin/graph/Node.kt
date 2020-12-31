package graph
data class Node<T> (val data:T) {

    var neighbours : MutableList<Node<T>> = mutableListOf()

    constructor(data: T, neighbours: List<Node<T>>) : this(data) {
        this.neighbours.addAll(neighbours)
    }

    fun addNeighbour(vararg neighbour : Node<T>) {
        this.neighbours.addAll(neighbour)
    }

    override fun equals(other: Any?): Boolean {
        if (other == null || !(other is Node<*>)) {
            return false
        }
        return data == other.data
    }

    override fun hashCode(): Int {
        return data.hashCode()
    }
}