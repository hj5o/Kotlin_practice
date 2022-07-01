package com.example.kotlinpractice

// #1 Kotlin은 JavaScript의 함수 선언식처럼 함수를 사용한다.
// #2 변수명을 선언할 때는 Java와 다르다.
//  Java는 int a = 0;         Kotlin은 var a : Int = 0   or   var a = 0
//  Kotlin은 변수명을 type보다 먼저 쓰고, return type은 parameter 쓰고 난 뒤에 쓰는데 일반적으로 생략 가능하다. (자동추론)
//  다만 함수에서는 Unit으로 명명해야한다. 이러한 요소 때문에 코틀린은 Expression하고 자바는 void만 함수를 만드므로 Statement하다.
// val : value, var = variable을 의미하며 val은 immutable, var는 mutable한 특징을 가진다.
// #4 문자열 내에 ${}로 변수를 사용할 수 있다.
// #5 $를 써야하는 상황에는 \(백슬래쉬)를 이용하면 된다.

fun main() { // -> #1
    var a : Int = 0 // -> #2
    var b = 1
    println(a)
    println(b)
    helloWorld() // Hello World
    println(add(10, 20)) // 30

    // -> #4
    val name = "hj5o"
    val lastName = "kim"
    println("my name is ${name + " " + lastName}. I'm 28") // 3
    println("my \$name") // -> #5 백슬래쉬를 사용하면 변수가 아닌 문자로 인식
    println("my $name")
    println()
}

// #1
fun helloWorld() {
    println("Hello World")
}
// #2
fun add(a : Int, b : Int) : Int { // -> #3  : Int
    return a+b
}
