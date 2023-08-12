fun main() {
    // ISBN의 처음 10자리는 항상 9780921418이라고 가정
    var first10Digits = "9780921418"
    var sum = 0

    // 마지막 3자리를 입력받아서 1-3 합을 계산
    for (i in 1..3) {
        val digit = readLine()!!.toInt()
        first10Digits+=digit.toString()
    }
    for ((i,c) in first10Digits.withIndex()) {
        val n = c.code - '0'.code
        if (i % 2 == 0) {
            sum += n
        } else {
            sum += n * 3
        }
    }

    // 결과 출력
    println("The 1-3-sum is $sum")
}
