fun main() {
    val result = calculateCommission("VK PAY", 0, 200_000)
    println("Комиссия составит $result рублей")
}

fun calculateCommission(cardType: String, pastTransfersAmount: Int, transferAmount: Int): Int {
    val total = transferAmount + pastTransfersAmount
    return if (total > 75_000) (userCard(cardType, pastTransfersAmount, transferAmount).toInt()) else 0
}

fun userCard(cardType: String, pastTransfersAmount: Int, transferAmount: Int) = when(cardType) {
    "VK PAY" -> 0.0
    "Mastercard" -> ((transferAmount + pastTransfersAmount) * 0.006) + 20
    "MAESTRO" -> ((transferAmount + pastTransfersAmount) * 0.006) + 20
    else -> 0.0
}