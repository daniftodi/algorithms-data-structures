import graph.algorithm.BFS
import graph.algorithm.DFS
import graph.util.Node

fun main(args: Array<String>) {
    println("Hello World!")

    val s = Node('s')
    val a = Node('a')
    val b = Node('b')
    val c = Node('c')
    val d = Node('d')
    val e = Node('e')

    s.addNeighbour(a, b)
    a.addNeighbour(c, d, s)
    b.addNeighbour(d, c, s)
    d.addNeighbour(e, a, b)
    c.addNeighbour(e, a, b)
    e.addNeighbour(d, c)

    BFS().traverse(s).forEach {
        print(it.data)
    }
    println()
    DFS().traverse(s).forEach {
        print(it.data)
    }
}
