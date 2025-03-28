package org.example.it.unibo.basics

fun ifExpression() {
    val a = 10
    val b = 20
    val max = if (a > b) { // it is an expression!!
        println("a is larger than b.")
        a
    } else {
        println("b is larger than a.")
        b
    }
    println("max is $max")
    val max2 = if (a > b) a else b // ternary operator
    println("max2 is $max2")
}

fun whileExpression() {
    var x = 10
    while (x > 0) {
        println(x)
        x--
    }
    do {
        println(x)
        x++
    } while (x < 10)
}

fun forExpression() {
    val numbers = listOf(1, 2, 3, 4, 5)
    for (number in numbers) {
        println(number)
    }
    for (i in 1..10) {
        println(i)
    }
    for (i in 1 until 10) {
        println(i)
    }
    for (i in 10 downTo 1) {
        println(i)
    }
    for (i in 1..10 step 2) {
        println(i)
    }
}

fun whenExpression(obj: Any) {
    when (obj) {
        1 -> println("One")
        "Hello" -> println("Greeting")
        is Long -> println("Long")
        !is String -> println("Not a string")
        else -> println("Unknown")
    }
}

fun main() {
    println("--- Control Flow ---")
    println("-- if expression --")
    ifExpression()
    println("-- while expression --")
    whileExpression()
    println("-- for expression --")
    forExpression()
    println("-- when expression --")
    whenExpression(1)
    whenExpression("Hello")
    whenExpression(1000L)
    whenExpression(1000)
    whenExpression("1000")
}