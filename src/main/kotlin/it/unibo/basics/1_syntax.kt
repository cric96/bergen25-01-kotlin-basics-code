package org.example.it.unibo.basics
// Top-level val(ues) and var(iables) are allowed
// NB! No semicolons are needed
val x = 10 // x is a read-only variable
var y = 20 // y is a mutable variable
val xWithType: Int = 10 // differently from Java, the type goes after the name
var yWithType: Int = 20
// Top-level functions are allowed
fun foo() = 20 // type is inferred
fun bar(): Int = 20 // type is explicit
fun multipleLine(): Int {
    return 20
}
// Function parameters
fun foo(a: Int = 0, b: String = "default"): Int = a // throws NotImplementedError
fun fooFunction() {
    foo(1, "bar") // OK, positional
    foo(a = 1, b = "bar") // OK, named
    foo(1, b = "bar") // OK, hybrid
    foo(a = 1, "bar") // error: no value passed for parameter 'b'
    foo() // OK, both defaults
    foo(1) // OK, same as foo(1, "foo")
    // foo("bar") // error: type mismatch: inferred type is String but Int was expected
    foo(b = "bar") // OK, same as foo(0, "bar")
}

// foo() ERROR! only top level functions can be called from the top level

// A special function that can be called from the top level
fun main() {
    println("Hello World!")
    println("$x $y") // as in java
}