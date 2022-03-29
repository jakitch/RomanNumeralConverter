import org.junit.Test
import kotlin.test.assertEquals

class UnitTests {

    @Test
    fun decimalToNumeral() {
        assertEquals("MMMCMXCIX", RomanConverter.decimalToNumeral(3999))
        assertEquals("CLXV", RomanConverter.decimalToNumeral(165))
        assertEquals("XCIV", RomanConverter.decimalToNumeral(94))
    }

    @Test
    fun numeralToDecimal() {
        assertEquals(3999.toString(), RomanConverter.numeralToDecimal("MMMCMXCIX"))
        assertEquals(165.toString(), RomanConverter.numeralToDecimal("CLXV"))
        assertEquals(94.toString(), RomanConverter.numeralToDecimal("XCIV"))
    }

    @Test
    fun testEveryNumber() {
        var numbers = ArrayList<String>()
        for(i in 1..3999) {
            numbers.add(RomanConverter.decimalToNumeral(i))
        }
        for(i in 1..3999) {
            assertEquals(i.toString(), RomanConverter.numeralToDecimal(numbers[i-1]))
        }
    }
}