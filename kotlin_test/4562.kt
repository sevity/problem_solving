fun main() {
    val n = readLine()!!.toInt()
    repeat(n) {
        val (x, y) = readLine()!!.split(" ").map { it.toInt() }
        if (x >= y) {
            println("MMM BRAINS")
        } else {
            println("NO BRAINS")
        }
    }
}

