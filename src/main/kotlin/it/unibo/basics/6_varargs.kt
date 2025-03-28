package org.example.it.unibo.basics

fun printAll(vararg values: Int) {
    for (value in values) { // for just with in
        print("$value ")
    }
    println()
}

fun mixedVarsAndValues(vararg vars: String, final: Int) {
    for (v in vars) {
        print("$v ")
    }
    println("final: $final")
    println()
}

fun main() {
    printAll(1, 2, 3, 4, 5)
    mixedVarsAndValues("a", "b", "c", final = 10)
    mixedVarsAndValues(final = 10)
}