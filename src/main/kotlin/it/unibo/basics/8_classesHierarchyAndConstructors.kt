package org.example.it.unibo.basics

import java.util.*

interface Shape {
    fun area(): Double
    fun perimeter(): Double
}

class Circle(val radius: Double) : Shape {
    override fun area(): Double = Math.PI * radius * radius
    override fun perimeter(): Double = 2 * Math.PI * radius
}

class Rectangle(val width: Double, val height: Double) : Shape {
    override fun area(): Double = width * height
    override fun perimeter(): Double = 2 * (width + height)
}

fun areasForShapes(vararg shapes: Shape) {
    for (shape in shapes) {
        println("Area: ${shape.area()}")
    }
}

interface A { fun foo() { println("A") } }
interface B { fun foo() { println("B") } }

class C : A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }
}

class D: A

// Constructors
// - Primary constructor: defined in the class header
// - Secondary constructor: defined in the class body
class Person(val name: String, val age: Int) {
    init {
        println("Person initialized with name $name and age $age")
    }
    constructor(name: String) : this(name, 0) {
        println("Secondary constructor")
    }

    fun yearOfBirth() = Calendar.getInstance().get(Calendar.YEAR) - age
}

fun personExamples() {
    val p1 = Person("Alice", 29)
    println(p1.yearOfBirth())
    val p2 = Person("Bob")
    println(p2.yearOfBirth())
}

// Late initialization
// Bad: Nullable references
class FatherBad(var son: String? = null)

// Better: lateinit
class Father {
    lateinit var son: String
    fun init() {
        son = "Son"
    }
    // Compiler ensures initialization before use
}

fun fatherExamples() {
    val f = Father()
    f.init()
    println(f.son)
}

fun main() {
    println("--- ClassesAdvanced ---")
    println("-- Foo Examples --")
    fooExamples()
    println("-- FooWithProperties Examples --")
    fooWithPropertiesExamples()
    println("-- FooWithBackingFields Examples --")
    fooWithBackingFieldsExamples()
    println("-- MutableComplex Examples --")
    mutableComplexExamples()
    println("-- Shape Examples --")
    personExamples()
    println("-- Person Examples --")
    fatherExamples()
}