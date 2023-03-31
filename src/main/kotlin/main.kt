fun main() {
    val result = calculateCommission()
    println(result)
}

fun calculateCommission(cardType: String = "МИР", pastTransfersAmount: Int = 0, transferAmount: Int = 15200) =
    when (cardType) {
        "VkPAY" -> when {
            pastTransfersAmount + transferAmount > 40_000 -> "Превышен месячный лимит переводов"
            transferAmount > 15_000 -> "Превышен суточный лимит переводов"
            else -> "Комиссия составит 0 рублей"
        }

        "Mastercard", "MAESTRO" -> when {
            transferAmount > 150_000 -> "Превышен суточный лимит переводов"
            transferAmount + pastTransfersAmount > 600_000 -> "Превышен месячный лимит переводов"
            transferAmount + pastTransfersAmount > 75_000 -> "Комиссия составит ${((transferAmount * 0.006) + 20).toInt()} рублей"
            else -> "Комиссия составит 0 рублей"
        }

        "Visa", "МИР" -> when {
            transferAmount > 150_000 -> "Превышен суточный лимит переводов"
            transferAmount + pastTransfersAmount > 600_000 -> "Превышен месячный лимит переводов"
            transferAmount * 0.0075 > 35 -> "Комиссия составит ${(transferAmount * 0.0075).toInt()} рублей"
            else -> "Комиссия составит 35 рублей"
        }

        else -> 0
    }