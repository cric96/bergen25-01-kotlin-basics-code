package org.example.it.unibo.compose

val lambda = {
    println("Hello from lambda")
}

fun payAttention() = {
    println("Pay attention!")
}

fun lambdaExample() {
    lambda.invoke()
    lambda()
    payAttention()()
}

fun <T, I, R> compose(f: (T) -> I, g: (I) -> R): (T) -> R {
    return { x: T -> g(f(x)) }
}

fun <T, I, R> composeCompact(f: (T) -> I, g: (I) -> R): (T) -> R = { g(f(it)) }

fun delay(time: Long, block: () -> Unit) {
    Thread.sleep(time)
    block()
}

fun breakingFlow(): List<Int> = (0..10).toList().map {
    if (it > 4) {
        return (0..it).toList() // returns from breakingFlow
    }
    it
}

fun main() {
    lambdaExample()
    fun addOne(x: Int): Int = x + 1
    val f = { x: Int -> x + 1 }
    val g = { x: Int -> x * 2 }
    val h = compose(f, g)
    println(h(1)) // 4
    val h2 = composeCompact(f, g)
    println(h2(1)) // 4
    val h3 = compose(f, ::addOne)
    println(h3(1)) // 3
    delay(1000) { // trailing lambda, kind of DSL!
        println("Hello after 1 second")
    }
    var sum = 0
    (1..10).forEach {
        sum += it // legal!
    }
    println(sum)
    println("result = " + breakingFlow())
    // forEach with destructuring
    mapOf(46 to "Rossi", 4 to "Dovizioso", 93 to "Marquez").forEach { (number, name) ->
        println("Rider number $number is $name")
    }
}