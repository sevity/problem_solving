fun main() {
    val antenna = readLine()!!.toInt()
    val eye = readLine()!!.toInt()
    if(antenna>=3 && eye<=4) println("TroyMartian")
    if(antenna<=6 && eye>=2) println("VladSaturnian")
    if(antenna<=2 && eye<=3) println("GraemeMercurian")
}