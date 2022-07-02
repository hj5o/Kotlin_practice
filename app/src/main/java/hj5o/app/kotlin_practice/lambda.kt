package hj5o.app.kotlin_practice

// Lambda
// value처럼 다룰 수 있는 익명함수
// 1. method의 파라미터로 넘겨줄 수 있다. fun method(a : Int)
// 2. return 값으로 사용할 수 있다.

// lambda의 기본 정의
// val lambdaName : Type = {argumentList -> codeBody}

val square : (Int) -> (Int) = {number -> number * number}
//val square = {number : Int -> number * number}

val nameAge = {name : String, age : Int ->
    "My name is ${name}, I'm ${age} years old"
}

fun main() {
    println(square(10))
    println(nameAge("Jay", 28))

    val a = "Jay said"
    println(a.pizzaIsGreat())

    println(extendString("Jay", 28))

    println(calcGrade(90))

    val lambda = {number : Double -> number == 4.2}
    println(invokeLambda(lambda))
    println(invokeLambda({it > 2.2})) // it은 하나 들어가는 파라미터
    println(invokeLambda{it > 2.2}) // 마지막 파라미터가 람다식일 때 사용 가능
}

// 확장함수

val pizzaIsGreat : String.() -> String = {
    this + " Pizza is the best"
}

fun extendString(name : String, age : Int) : String {
    val introduceMyself : String.(Int) -> String = {"I am ${this} and ${it} years old"}
    return name.introduceMyself(age)
}

// 람다의 return

val calcGrade : (Int) -> String = {
    when (it) {
        in 0..40 -> "Fail"
        in 41..70 -> "Pass"
        in 71..100 -> "Perfect"
        else -> "Error"
    }
}

// 람다를 표현하는 여러가지 방법

fun invokeLambda(lambda : (Double) -> Boolean) : Boolean {
    return lambda(5.23)
}