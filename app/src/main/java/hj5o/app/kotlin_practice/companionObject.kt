package hj5o.app.kotlin_practice

// Java의 static 대신 사용
//  #1 object를 선언하면 singleton처럼 한 번만 사용된다.
class book private constructor(val id : Int, val name : String) {

    companion object bookFactory :idProvider {

        override fun getId(): Int {
            return 777
        }

        val myBook = "name"

        fun create() = book(0, "Angel")
//        fun create() = book(getId(), myBook) // 777, name
    }
}

interface idProvider {
    fun getId() : Int
}

fun main() {
    val book = book.create()
//  = val book = book.Companion.create()

    val bookId = hj5o.app.kotlin_practice.book.bookFactory.getId()

    println("${book.id}, ${book.name}")
    println()
    println("object")
    val car = carFactory.makeCar(10)
    val car2 = carFactory.makeCar(200)

    println(car)
    println(car2)
    println(carFactory.cars.size.toString())
}

object carFactory { // singleton pattern -> #1
    val cars = mutableListOf<Car>()
    fun makeCar(horsePower: Int) : Car {
        val car = Car(horsePower)
        cars.add(car)
        return car
    }

}

data class Car(val horsePower : Int)
