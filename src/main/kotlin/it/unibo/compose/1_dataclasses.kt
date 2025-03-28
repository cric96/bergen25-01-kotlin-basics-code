package org.example.it.unibo.compose

data class Person(val name: String, val age: Int)

fun main() {
    val p1 = Person("Alice", 29)
    println(p1)
    val p2 = Person("Bob", 31)
    println(p2)
    println(p1 == p2)
    val p3 = p1.copy(name = "Alice2")
    println(p3)
    println(p1 == p3)
    println(p1.hashCode())
    println(p3.hashCode())
    println(p1.toString())
    println(p3.toString())
    val (name, age) = p1
    when(p1) {
        Person("Alice", 29) -> println("Alice is 29")
    }

}