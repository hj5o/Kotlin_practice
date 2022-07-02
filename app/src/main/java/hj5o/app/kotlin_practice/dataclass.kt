package hj5o.app.kotlin_practice

// pojo class : 비어 있는 틀 역할을 하는 class
data class Ticket(val companyName : String, val name : String, var date : String, var seatInfo : Int)
// toString(), hashCode(), equals(), copy()
// codebody 없이 pojo class가 만들어짐

class TicketNormal(val companyName : String, val name : String, var date : String, var seatInfo : Int)

fun main() {
    val ticketA = Ticket("koreanAir", "Jay", "2022-07-02", 14)
    val ticketB = TicketNormal("koreanAir", "Jay", "2022-07-02", 14)

    println(ticketA) // 바로 출력, 하나의 파일에 모으기 때문에 관리하기 편함
    println(ticketB) // 메모리 주소값
}