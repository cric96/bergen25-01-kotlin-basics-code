package org.example.it.unibo.basics

class Foo

fun fooExamples() {
    val foo = Foo()
    println(foo)
}

class FooWithProperties {
    val foo: String = "Foo"
}

fun fooWithPropertiesExamples() {
    val foo = FooWithProperties()
    println(foo.foo)
}

class FooWithBackngFields {
    var baz: String? = null // public accessor
    val bazLength: Int
        get() = baz?.length ?: 0 // properties, custom getter
    var stringRepresentation: String = ""
        get() = baz ?: field // access to the backing field
        set(value) {
            println("Setting value to $value")
            field = value
        }
}

fun fooWithBackingFieldsExamples() {
    val foo = FooWithBackngFields()
    println(foo.baz)
    println(foo.bazLength)
    foo.baz = "Hello"
    println(foo.baz)
    println(foo.bazLength)
    println(foo.stringRepresentation)
    foo.stringRepresentation = "World"
    println(foo.stringRepresentation)
}

class MutableComplex {
    var real: Double = 0.0
    var imaginary: Double = 0.0

    fun add(other: MutableComplex) {
        real += other.real
        imaginary += other.imaginary
    }
}

fun mutableComplexExamples() {
    val c1 = MutableComplex()
    val c2 = MutableComplex()
    c1.real = 1.0
    c1.imaginary = 2.0
    c2.real = 3.0
    c2.imaginary = 4.0
    c1.add(c2)
    println("c1.real = ${c1.real}, c1.imaginary = ${c1.imaginary}")
}

fun main() {
    println("--- ClassesExamples ---")
    println("-- Foo Examples --")
    fooExamples()
    println("-- FooWithProperties Examples --")
    fooWithPropertiesExamples()
    println("-- FooWithBackingFields Examples --")
    fooWithBackingFieldsExamples()
    println("-- MutableComplex Examples --")
    mutableComplexExamples()
}