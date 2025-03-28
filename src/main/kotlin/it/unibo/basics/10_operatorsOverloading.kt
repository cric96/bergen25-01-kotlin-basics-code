package org.example.it.unibo.basics


// 1. Arithmetic Operators
class Vector(val x: Double, val y: Double) {
    // Plus operator (+)
    operator fun plus(other: Vector): Vector {
        return Vector(x + other.x, y + other.y)
    }

    // Minus operator (-)
    operator fun minus(other: Vector): Vector {
        return Vector(x - other.x, y - other.y)
    }

    // Times operator (*)
    operator fun times(scalar: Double): Vector {
        return Vector(x * scalar, y * scalar)
    }

    // Div operator (/)
    operator fun div(scalar: Double): Vector {
        return Vector(x / scalar, y / scalar)
    }

    // Rem operator (%)
    operator fun rem(scalar: Double): Vector {
        return Vector(x % scalar, y % scalar)
    }
}

// 2. Comparison Operators
class PersonComparison(val name: String, val age: Int) {
    // Comparison operators (>, <, >=, <=)
    operator fun compareTo(other: PersonComparison): Int {
        return age.compareTo(other.age)
    }
}

// 3. Equality Operators
class Point(val x: Int, val y: Int) {
    // Equals method (==)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Point) return false
        return x == other.x && y == other.y
    }

    // HashCode for consistent behavior with equals
    override fun hashCode(): Int {
        return x.hashCode() * 31 + y.hashCode()
    }
}

// 4. Increment and Decrement Operators
class CounterDSL(var value: Int) {
    // Prefix increment (++counter)
    operator fun inc(): CounterDSL {
        return CounterDSL(value + 1)
    }

    // Prefix decrement (--counter)
    operator fun dec(): CounterDSL {
        return CounterDSL(value - 1)
    }
}

// 5. Indexing Operators
class CustomList<T> {
    private val items = mutableListOf<T>()

    // Get operator ([])
    operator fun get(index: Int): T {
        return items[index]
    }

    // Set operator ([] =)
    operator fun set(index: Int, value: T) {
        items[index] = value
    }

    fun add(item: T) {
        items.add(item)
    }
}

// 6. Invoke Operator
class Calculator {
    // Invoke operator ()
    operator fun invoke(x: Int, y: Int): Int {
        return x + y
    }
}

// 7. Range Operators
class DateRange(val start: Int, val end: Int) {
    // Contains operator (in)
    operator fun contains(value: Int): Boolean {
        return value in start..end
    }
}

// Demonstration function to show usage
fun demonstrateOperatorOverloading() {
   // Arithmetic Operators
    val v1 = Vector(1.0, 2.0)
    val v2 = Vector(3.0, 4.0)
    val sum = v1 + v2  // Vector addition
    val scaled = v1 * 2.0  // Scalar multiplication
    println("v1: \$v1, v2: \$v2")
    println("sum: \$sum")
    println("scaled: \$scaled")

    // Comparison Operators
    val person1 = PersonComparison("Alice", 30)
    val person2 = PersonComparison("Bob", 25)
    val isOlder = person1 > person2
    println("isOlder: \$isOlder")

    // Equality Operators
    val point1 = Point(1, 2)
    val point2 = Point(1, 2)
    val areEqual = point1 == point2
    println("areEqual: \$areEqual")

    // Increment/Decrement Operators
    var counter = CounterDSL(5)
    val incremented = ++counter
    val decremented = --counter
    println("incremented: \$incremented, decremented: \$decremented")

    // Indexing Operators
    val customList = CustomList<String>()
    customList.add("Hello")
    customList.add("World")
    val firstItem = customList[0]
    customList[1] = "Kotlin"
    println("firstItem: \$firstItem, second item: \${customList[1]}")

    // Invoke Operator
    val calculator = Calculator()
    val result = calculator(5, 3)
    println("result: \$result")

    // Range Operators
    val dateRange = DateRange(1, 10)
    val isInRange = 5 in dateRange
    println("isInRange: \$isInRange")
}

// 8. Unary Operators
class Complex(var real: Double, var imaginary: Double) {
    // Unary plus (+)
    operator fun unaryPlus(): Complex {
        return Complex(+real, +imaginary)
    }

    // Unary minus (-)
    operator fun unaryMinus(): Complex {
        return Complex(-real, -imaginary)
    }

    // Unary increment (++)
    operator fun inc(): Complex {
        return Complex(real + 1, imaginary)
    }

    // Unary decrement (--)
    operator fun dec(): Complex {
        return Complex(real - 1, imaginary)
    }

    // Unary not (!)
    operator fun not(): Boolean {
        return real == 0.0 && imaginary == 0.0
    }

    override fun toString(): String {
        return "$real + ${imaginary}i"
    }
}

// Demonstration of Unary Operators
fun demonstrateUnaryOperators() {
    // Unary plus
    val num1 = Complex(3.0, 4.0)
    val positiveNum = +num1  // Creates a new Complex with same values

    // Unary minus
    val negatedNum = -num1  // Negates both real and imaginary parts

    // Unary increment
    var num2 = Complex(5.0, 2.0)
    val incrementedNum = ++num2  // Increases real part by 1

    // Unary decrement
    var num3 = Complex(5.0, 2.0)
    val decrementedNum = --num3  // Decreases real part by 1

    // Unary not
    val zeroComplex = Complex(0.0, 0.0)
    val isZero = !zeroComplex  // Returns true

    // Printing to demonstrate
    println("Original: $num1")
    println("Unary Plus: $positiveNum")
    println("Unary Minus: $negatedNum")
    println("Incremented: $incrementedNum")
    println("Decremented: $decrementedNum")
    println("Is Zero: $isZero")
}

// Main function to demonstrate all operator overloading
fun main() {
    demonstrateOperatorOverloading()
    demonstrateUnaryOperators()
}