package org.example.it.unibo.compose

data class Student(val name: String, val surname: String, val age: Int)

class Exam : MutableCollection<Student> by mutableListOf() {
    fun register(name: String, surname: String, age: Int) {
        add(Student(name, surname, age))
    }

    override fun toString(): String {
        return super.toString()
    }
}

fun delegationByClasses() {
    val exam = Exam()
    exam.register("Alice", "Rossi", 29)
    exam.register("Bob", "Verdi", 31)
    println(exam)
    println(exam.size)
    // By delegation, we can use all the methods of MutableList!!!
    println(exam.isEmpty())
    println(exam.contains(Student("Alice", "Rossi", 29)))
}

fun delegationByLazy() {
    val lazyValue: String by lazy {
        println("computed!")
        "Hello"
    }
    println(lazyValue)
    println(lazyValue)
}

class PersonJson(private val representation: Map<String, Any?>) {
    val name: String by representation
    val age: Int by representation
    override fun toString(): String {
        return "PersonJson(name=$name, age=$age)"
    }
}

class MutablePersonJson(private val representation: MutableMap<String, Any?>) {
    var name: String by representation
    var age: Int by representation
    override fun toString(): String {
        return "MutablePersonJson(name=$name, age=$age)"
    }
}

fun delegationByMap() {
    val person = PersonJson(mapOf("name" to "Alice", "age" to 29))
    // to -> infix function
    val tuples = "name" to "Alice"
    println(tuples)
    println(person)
}

fun delegationByMapMutable() {
    val person = MutablePersonJson(mutableMapOf("name" to "Alice", "age" to 29))
    println(person)
    person.name = "Bob"
    println(person)
}

class CustomDelegate {
    private var storedValue: String = ""

    operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>): String {
        println("Getting value for ${property.name}")
        return storedValue
    }

    operator fun setValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>, value: String) {
        println("Setting value for ${property.name} to $value")
        storedValue = value.uppercase()
    }
}

fun main() {
    delegationByClasses()
    delegationByLazy()
    delegationByMap()
    delegationByMapMutable()
    var custom by CustomDelegate()
    custom = "Hello"
}