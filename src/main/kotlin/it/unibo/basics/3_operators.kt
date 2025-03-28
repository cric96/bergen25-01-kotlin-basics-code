package org.example.it.unibo.basics

fun booleans() {
    val isTrue: Boolean = true
    val isFalse: Boolean = false

    // Boolean operators
    val andResult = isTrue && isFalse  // false
    val orResult = isTrue || isFalse   // true
    val notResult = !isTrue            // false
    println("andResult: $andResult, orResult: $orResult, notResult: $notResult")
}

fun numbers() {
    val x: Int = 10
    val y: Long = x.toLong()
    // val z: Double = 30 Illegal!!
    val z: Double = x.toDouble() // explicit conversion!
    println("x: $x, y: $y, z: $z")
    // Literals
    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val hex = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010
    println("oneMillion: $oneMillion, creditCardNumber: $creditCardNumber, hex: $hex, bytes: $bytes")
}

fun strings() {
    val name = "Kotlin"
    val combined = "Hello, $name"
    val rawString = """
        |Hello, $name
        |Welcome to Kotlin
    """.trimMargin()

    val extensions = "${Double.NaN}".repeat(5) + " batman"
    println("combined: $combined, rawString: $rawString, extensions: $extensions")
}

fun main() {
    println("--- Operators ---")
    println("-- booleans --")
    booleans()
    println("-- numbers --")
    numbers()
    println("-- strings --")
    strings()
}