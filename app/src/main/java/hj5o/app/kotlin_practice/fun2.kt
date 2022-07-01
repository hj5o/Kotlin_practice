package com.example.kotlinpractice

// #1 조건식은 자바와 흡사하지만 자바의 삼항연산자는 코틀린에서 없다.
// #2 when을 이용해 자바의 Case처럼 활용할 수 있다.
// #3 Array & List. 자바의 Array, ArrayList와 비슷하다.
// #4 반복문은 python의 for문과 흡사하다.
// #5 step, downTo, withIndex 등 내부 함수들도 유용하게 쓸 수 있다.
// #6 Java의 NullPointerException은 run해봐야 알 수 있는데, Kotlin은 변수 type에 ?를 붙여 NPE를 제어할 수 있다. (컴파일 시점)
// #7 ?: 엘비스 연산자를 이용하여 MYSQL의 IFNULL 처럼 활용할 수 있는 시스템이 있다.
// #8 !! 반드시 null이 아닌 값에 사용하여 nullable 사용을 방지할 수 있지만, 잘못 사용할 경우 NPE를 유발한다.

fun main() {
    condition2(51, 4)
}

fun condition1(a : Int, b : Int) : Int { // -> #1
    if (a > b) {
        return a
    } else {
        return b
    }
}
fun condition2(a : Int, b : Int) = if (a > b ) a else b // 자바의 삼항연산자 (a > b) ? a : b

fun checkNum (score : Int) {
    when (score) { // -> #2
        0 -> println("this is 0")
        1 -> println("this is 1")
        2, 3 -> println("this is 2 or 3")
//        else -> println("I don't know")
    }
    var b = when (score) {
        1 -> 1
        2 -> 2
        else -> 3
    }

    println("b : $b")

    when (score) {
        in 90..100 -> println("You are genius")
        in 10..90 -> println("Normal")
        else -> println("Bad")
    }
}

// Array & List
// Array 처음에 크기 지정
// List(수정X) and MutableList(수정O)

fun array() { // -> #3
    val array = arrayOf(1,2,3)
    val list = listOf<Int>(1,2,3)
    val list1 = listOf(1,2,3)

    val array2 = arrayOf(1, "d", 3.4f)
    val list2 = listOf<Any>(1, "d", 3.4f)

    array[0] = 3 // 변경 가능

    var arrayList = arrayListOf<Int>()
    arrayList.add(10)
    arrayList.add(20)
    arrayList[0] = 15
    println(arrayList)
}

// 반복문(For & While)
fun forAndWhile() {

    val students = arrayListOf<String>("Jay", "Cinn", "jenny", "james")

    for (name in students) { // -> #4
        println("${name}")
    }

    for ((idx, name) in students.withIndex()) { // -> #5
        println("${idx+1}번째 학생 : ${name}")
    }

    var sum = 0
    for (i in 1..10) { // 1+2+ --- + 10 = 55
        sum += i
    }
    println("sum = $sum")
    var sum_step = 0
    for (i in 1..10 step 2) { // 1+3+5+7+9 = 25
        sum_step += i
    }
    println("sum_step = $sum_step")
    var sum_downTo = 0
    for (i in 10 downTo 1) { // 10+9+8+ --- + 1 = 55
        sum_downTo += i
    }
    println("sum_downTo = $sum_downTo")

    // for (int i in 1 until 100) {} // 100을 포함하지 않는다. (1~99)

    var index = 0
    while (index < 3) {
        println("current index : ${index}")
        index++
    }
}

// NonNull & Nullable
fun nullCheck() {
    // NPE : NullPointerException (JAVA) : play해봐야 알 수 있음

    var name : String = "jay"

    var nullName : String? = null // 물음표를 붙여야 되므로 type 생략 불가    -> #6
    // ? < 컴파일 시점에서 NPE를 잡아줌
    var nameInUpperCase = name.toUpperCase()

    var nullNameInUpperCase = nullName?.toUpperCase()
    // null인지 아닌지 모름, null이 아니면 toUpperCase, null이면 null 반환


    // ?: 엘비스 연산자
    val lastName : String? = null

    val fullName = name + " " + (lastName?: "NO lastName")
    println(fullName)

}

// !! : 확실하게 null이 아닐 때만 사용
fun ingnoreNulls(str : String?) {
    val mNotNull : String = str!!  // str에는 절대 null이 들어갈 수 없어
    val upper = mNotNull.toUpperCase()

    val email : String? = "jay@naver.com"
    email?.let{
        println("my email is ${email}")
    }
}