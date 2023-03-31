fun main() {
    val result = calculateCommission("VkPAY", 0, 100_000)
    println("Комиссия составит $result рублей")
}

fun calculateCommission(cardType: String, pastTransfersAmount: Int, transferAmount: Int) = when (cardType) {
    "VkPAY" -> 0
    "Mastercard", "MAESTRO" -> if ((transferAmount + pastTransfersAmount) > 75_000)
        (((transferAmount + pastTransfersAmount) * 0.006) + 20).toInt() else 0
    "Visa", "МИР" -> if ((transferAmount + pastTransfersAmount) * 0.0075 > 35)
        ((transferAmount + pastTransfersAmount) * 0.0075).toInt() else 35
    else -> 0
}