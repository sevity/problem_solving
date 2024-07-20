fun main() {
    var sum = 0;
    for(i in 1..5){
        val n = readLine()!!.toInt();
        sum += n;
    }
    println(sum)
}