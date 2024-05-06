//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    webVisit("Home")
    webVisit("About")
    webVisit("Contact Us")
    webVisit("Social Media")
    webVisit("Inquiry")

    val top5Webpages = getTop5Webpages()
    println("Top 5 most frequently visited web pages:")
    for ((webpage, visits) in top5Webpages) {
        println("$webpage: $visits visits")
    }
}
val webpageVisits = mutableMapOf<String, Int>()
fun webVisit(webpage: String) {
    val visits = webpageVisits.getOrDefault(webpage, 0)
    webpageVisits[webpage] = visits + 1
}

fun getTop5Webpages(): List<Pair<String, Int>> {
    return webpageVisits.toList()
        .sortedByDescending { (_, visits) -> visits }
        .take(5)
}