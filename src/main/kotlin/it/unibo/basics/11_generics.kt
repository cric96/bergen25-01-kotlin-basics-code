package org.example.it.unibo.basics

class FooGenerics<A, B: CharSequence>

fun <T: Comparable<T>> maxOf(a: T, b: T): T {
    return if (a > b) a else b
}

// fun <T> className(obj: T) = obj::class.simpleName DO NOT COMPILE!!

interface Position<P : Position<P>> {
    operator fun plus(other: P): P
}

interface Tensor<P : Position<P>> {
    operator fun get(index: Int): Double
    operator fun set(index: Int, value: Double)
}

interface Navigation<P> where P : Position<P>, P : Tensor<P> {
    fun move(direction: P)
}

fun <P> navigate(direction: P) where P : Position<P>, P : Tensor<P> {
    TODO()
}

// Invariant Type Example
class InvariantBox<T> {
    private var value: T? = null

    fun store(item: T) {
        value = item
    }

    fun retrieve(): T? {
        return value
    }
}

// Covariant Type Example
interface Producer<out T> {
    fun produce(): T
}
// Base and Derived Classes for Examples
open class Animal
class Dog : Animal()
class Cat : Animal()


class DogProducer : Producer<Dog> {
    override fun produce(): Dog {
        println("Producing a dog")
        return Dog()
    }
}

class CatProducer : Producer<Cat> {
    override fun produce(): Cat {
        println("Producing a cat")
        return Cat()
    }
}


// Contravariant Type Example
interface Consumer<in T> {
    fun consume(item: T)
}

class AnimalConsumer<in Animal> : Consumer<Animal> {
    override fun consume(item: Animal) {
        println("Consuming an animal: $item")
    }
}



fun demonstrateVariance() {
    // Invariant Example
    val invariantBox = InvariantBox<Dog>()
    invariantBox.store(Dog())
    // Cannot assign Box<Dog> to Box<Animal>
    // val animalBox: InvariantBox<Animal> = invariantBox // Compilation Error

    // Covariant Example
    val dogProducer: Producer<Dog> = DogProducer()
    val animalProducer: Producer<Animal> = dogProducer // Allowed with 'out' keyword
    val generalProducer: Producer<Any> = animalProducer // Allowed with 'out' keyword

    // Contravariant Example
    val dogConsumer: Consumer<Dog> = AnimalConsumer<Animal>()
    // Not allowed:
    // val animalConsumer: Consumer<Animal> = dogConsumer
    // Can assign a consumer of a more general type to a consumer of a more specific type
}

fun main() {
    demonstrateVariance()
}