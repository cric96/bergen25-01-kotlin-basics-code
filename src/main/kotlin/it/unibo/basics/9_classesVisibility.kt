package org.example.it.unibo.basics

import java.util.*

open class Base
class Derived : Base()
// class Derived2 : Derived NO!! Derived is final
class Visibility(
    private val a: Int, // restricted to the class
    protected val b: Int, // restricted to the class and its subclasses
    internal val c: Int, // restricted to the module
    val d: Int // public
) {
    var e: Int = 0
        private set // private setter, public getter
}

fun visibilityExamples() {
    val v = Visibility(1, 2, 3, 4)
    // v.a // COMPILE ERROR
    // v.b // COMPILE ERROR
    v.c // ok, same module
    println(v.d)
    // v.e = 5 COMPILE ERROR
    // v.e = 6 // COMPILE ERROR
}

class Counter(private var count: Int = 0) {

    fun increment() {
        count++
    }

    fun getCount(): Int = count

    companion object {
        fun doubleCount(counter: Counter): Int {
            // Even though 'count' is private, it is accessible inside the companion object.
            return counter.count * 2
        }
        fun create(): Counter = Counter()
    }
}
// object are valid also as first class citizens, used to kind of singleton
object CounterFactory {
    fun create(): Counter = Counter()
}
fun counterExamples() {
    val counter = Counter()
    counter.increment()
    println(counter.getCount())
    println(Counter.doubleCount(counter))
    val counter2 = Counter.create()
    println(counter2.getCount())
}