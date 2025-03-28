package org.example.it.unibo.compose

val String.containsBatman: Boolean
    get() = ".*b.*a.*t.*m.*a.*n.*".toRegex().matches(this)

// Extension Properties
fun extensionPropertiesDemo() {
    println("Batman Extension Property:")
    println("'nananananana batman'.containsBatman: ${"nananananana batman".containsBatman}")
    println("'superman'.containsBatman: ${"superman".containsBatman}")
}

// Extension Function Type Literals
fun extensionFunctionTypeLiteralsDemo() {
    // Extension function with a configuration block
    fun <T> MutableList<T>.configure(configuration: MutableList<T>.() -> Unit): MutableList<T> {
        configuration()
        return this
    }

    println("\nExtension Function Type Literals:")
    val superheroes = mutableListOf<String>().configure {
        add("Batman")
        add("Superman")
        add("Wonder Woman")
    }
    println("Configured list: $superheroes")
}

// Extension Members and Implicit Receivers
object SuperheroContext {
    val name = "Batman"

    // Extension property on String.Companion
    val String.Companion.intro
        get() = generateSequence { Double.NaN }
            .take(10)
            .joinToString(separator = "")

    // Extension function with qualified this access
    fun String.withHero() = "$this $name!"
}

fun extensionMembersDemo() {
    println("\nExtension Members and Implicit Receivers:")

    // Demonstrates scope control
    fun <T, R> insideTheScopeOf(receiver: T, method: T.() -> R): R = receiver.method()

    insideTheScopeOf(SuperheroContext) {
        // Can access context-specific extensions
        println(String.intro)
        println("Gotham".withHero())
    }
}

// Scope Functions Demonstration
fun scopeFunctionsDemo() {
    println("\nScope Functions Demonstration:")

    // let: transforms object with lambda
    val letResult = 1.let { "${it + 1}1" }
    println("let result: $letResult")

    // run: similar to let, but with 'this' context
    val runResult = 1.run { "${this + 1}1" }
    println("run result: $runResult")

    // with: non-extension version of run
    val withResult = with(1) { "${this + 1}1" }
    println("with result: $withResult")

    // apply: returns original object after side effects
    val applyResult = mutableListOf<Int>().apply {
        addAll((1..5).toList())
    }
    println("apply result: $applyResult")

    // also: similar to apply, but with 'it' parameter
    val alsoResult = 1.also { println("Side effect: ${it + 1}1") }
    println("also result: $alsoResult")
}

// Main function to run all demonstrations
fun main() {
    extensionPropertiesDemo()
    extensionFunctionTypeLiteralsDemo()
    extensionMembersDemo()
    scopeFunctionsDemo()
}