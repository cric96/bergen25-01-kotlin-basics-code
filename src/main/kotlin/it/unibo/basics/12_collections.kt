package org.example.it.unibo.basics

fun main() {
    // List Demonstrations
    println("--- List Demonstrations ---")
    // Mutable list
    val list1 = mutableListOf("apple", "banana")
    list1.add("cherry")
    println("Mutable List: $list1")

    // Immutable list
    val list2 = listOf("apple", "banana", "cherry")
    println("Immutable List: $list2")

    // Set Demonstrations
    println("\n--- Set Demonstrations ---")
    // Mutable set
    val set1 = mutableSetOf("red", "green")
    set1.add("blue")
    println("Mutable Set: $set1")

    // Immutable set
    val set2 = setOf("red", "green", "blue")
    println("Immutable Set: $set2")

    // Map Demonstrations
    println("\n--- Map Demonstrations ---")
    // Mutable map
    val map1 = mutableMapOf("a" to 1, "b" to 2)
    map1["c"] = 3
    println("Mutable Map: $map1")

    // Immutable map
    val map2 = mapOf("a" to 1, "b" to 2, "c" to 3)
    println("Immutable Map: $map2")

    // Stream and Functional Manipulations
    println("\n--- Collection Manipulations ---")
    val fruits = listOf("apple", "banana", "cherry", "date")

    // Filtering
    val longFruits = fruits.filter { it.length > 5 }
    println("Fruits longer than 5 chars: $longFruits")

    // Mapping
    val fruitLengths = fruits.map { it.length }
    println("Fruit lengths: $fruitLengths")

    // Sorting
    val sortedFruits = fruits.sorted()
    println("Sorted fruits: $sortedFruits")

    // Sequence demonstration (lazy evaluation)
    println("\n--- Sequence Demonstration ---")
    val numbers = sequenceOf(1, 2, 3, 4, 5)
    for (number in numbers) {
        println(number)
    }
}