import org.junit.Test
import kotlin.test.assertEquals

class CommissionTest {

    @Test
    fun testVkPAYNotCommission() {
        val cardType = "VkPAY"
        val pastTransfersAmount = 0
        val transferAmount = 1500

        val result = calculateCommission(
            cardType = cardType, pastTransfersAmount = pastTransfersAmount, transferAmount = transferAmount
        )

        assertEquals("Комиссия составит 0 рублей", result)

    }

    @Test
    fun testVkPAYMonthPayment() {
        val cardType = "VkPAY"
        val pastTransfersAmount = 0
        val transferAmount = 150_000

        val result = calculateCommission(
            cardType = cardType, pastTransfersAmount = pastTransfersAmount, transferAmount = transferAmount
        )

        assertEquals("Превышен месячный лимит переводов", result)

    }

    @Test
    fun testVkPAYDailyPayment() {
        val cardType = "VkPAY"
        val pastTransfersAmount = 0
        val transferAmount = 16000

        val result = calculateCommission(
            cardType = cardType, pastTransfersAmount = pastTransfersAmount, transferAmount = transferAmount
        )

        assertEquals("Превышен суточный лимит переводов", result)

    }

    @Test
    fun testVisaMIRCommission() {
        val cardType = "Visa"
        val pastTransfersAmount = 0
        val transferAmount = 400

        val result = calculateCommission(
            cardType = cardType, pastTransfersAmount = pastTransfersAmount, transferAmount = transferAmount
        )

        assertEquals("Комиссия составит 35 рублей", result)

    }

    @Test
    fun testVisaCommission() {
        val cardType = "Visa"
        val pastTransfersAmount = 0
        val transferAmount = 12500

        val result = calculateCommission(
            cardType = cardType, pastTransfersAmount = pastTransfersAmount, transferAmount = transferAmount
        )

        assertEquals("Комиссия составит 93 рублей", result)

    }

    @Test
    fun testMIRMonthlyCommission() {
        val cardType = "МИР"
        val pastTransfersAmount = 600_000
        val transferAmount = 12500

        val result = calculateCommission(
            cardType = cardType, pastTransfersAmount = pastTransfersAmount, transferAmount = transferAmount
        )

        assertEquals("Превышен месячный лимит переводов", result)

    }

    @Test
    fun testMastercardCommission() {
        val cardType = "Mastercard"
        val pastTransfersAmount = 0
        val transferAmount = 12500

        val result = calculateCommission(
            cardType = cardType, pastTransfersAmount = pastTransfersAmount, transferAmount = transferAmount
        )

        assertEquals("Комиссия составит 0 рублей", result)

    }

    @Test
    fun testMastercardDailyCommission() {
        val cardType = "Mastercard"
        val pastTransfersAmount = 0
        val transferAmount = 151_000

        val result = calculateCommission(
            cardType = cardType, pastTransfersAmount = pastTransfersAmount, transferAmount = transferAmount
        )

        assertEquals("Превышен суточный лимит переводов", result)

    }

    @Test
    fun testMastercardMonthlyCommission() {
        val cardType = "Mastercard"
        val pastTransfersAmount = 600_000
        val transferAmount = 12500

        val result = calculateCommission(
            cardType = cardType, pastTransfersAmount = pastTransfersAmount, transferAmount = transferAmount
        )

        assertEquals("Превышен месячный лимит переводов", result)

    }

    @Test
    fun testWrongCard() {
        val cardType = "111"
        val pastTransfersAmount = 0
        val transferAmount = 1500

        val result = calculateCommission(
            cardType = cardType, pastTransfersAmount = pastTransfersAmount, transferAmount = transferAmount
        )

        assertEquals("Такой карты нет", result)

    }
}