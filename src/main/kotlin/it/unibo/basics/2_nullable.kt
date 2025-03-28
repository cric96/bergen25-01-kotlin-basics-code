package org.example.it.unibo.basics

var name: String = "Kotlin"
// fun nameToNull() = name = null // COMPILE ERROR

fun modifyNullable() {
    var nullableName: String? = "Kotlin"
    nullableName = null // It works!! Because nullableName is nullable
    println(nullableName)
}

fun length(name: String?): Int {
    return name?.length ?: 0 // Elvis operator!!
}

fun main() {
    println(length("Kotlin")) // 6
    println(length(null)) // 0
    val x: String? = "Attention!"
    println(x!!.length) // 10
    // use java code
    val date = java.util.Date()
    val instant = date.toInstant()?.nano // marked as ! and therefore I can use it as a nullable and not nullable
    val instant2 = date.toInstant().nano // marked as ! and therefore I can use it as a nullable and not nullable
    println(instant)
    println(instant2)
}