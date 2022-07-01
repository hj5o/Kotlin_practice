package com.example.kotlinpractice

// #1 overriding을 하기 위해서 class 앞에 open을 붙인다.
// #2 init으로 주 생성자를 생성하고, constructor로 부 생성자를 생성한다.
// #3 overriding한 class내의 함수를 사용하고 싶으면, 함수 앞에도 open을 붙인다.
// #4 클래스를 사용할 때 Java처럼 new를 쓰지 않는다.

open class Human constructor(name : String = "Anonymous") { // -> #1

    val name = name

    init { // 주 생성자 -> #2
        println("new human has been born")
    }

    constructor(name: String, age: Int) : this(name){ // 부 생성자 -> #2
        println("my name is ${name}, ${age} year old")
    }

    fun eatingCake() {
        println("This is YUMMY")
    }

    open fun singAsong() { // -> #3
        println("lalala")
    }
}

class Korean : Human() { // 오버라이딩하기 위해 open
    //상속 받은 메소드를 이 클래스에서 다르게 쓰고 싶어
    override fun singAsong() {
        super.singAsong() // 기존 lalala 사용
        println("랄랄라")
        println("my name isssss : ${name}")
    }
}

fun main() {
    val human = Human("jay") // 자바와 다르게 new 선언할 필요 없다 -> #4

    val stranger = Human()
    human.eatingCake()

    val mom = Human("Kuri", 50)

    println("human name is ${stranger.name}")

    val korean = Korean()
    korean.singAsong()
}
