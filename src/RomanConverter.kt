fun main() {
    RomanConverter.runProgramLoop()
}

object RomanConverter {
    //rules for roman->decimal conversion
    private val rules = mapOf(
        'I' to NumeralMapValues(1, null),
        'V' to NumeralMapValues(5, 'I'),
        'X' to NumeralMapValues(10, 'I'),
        'L' to NumeralMapValues(50, 'X'),
        'C' to NumeralMapValues(100, 'X'),
        'D' to NumeralMapValues(500, 'C'),
        'M' to NumeralMapValues(1000, 'C')
    )

    //keeps track of which numeral goes with which decimal number
//Only used for decimal->roman conversion
    private val numbers = listOf<NumeralAssociations>(
        NumeralAssociations(1000, "M"),
        NumeralAssociations(900, "CM"),
        NumeralAssociations(500, "D"),
        NumeralAssociations(400, "CD"),
        NumeralAssociations(100, "C"),
        NumeralAssociations(90, "XC"),
        NumeralAssociations(50, "L"),
        NumeralAssociations(40, "XL"),
        NumeralAssociations(10, "X"),
        NumeralAssociations(9, "IX"),
        NumeralAssociations(5, "V"),
        NumeralAssociations(4, "IV"),
        NumeralAssociations(1, "I"),
    )

    fun runProgramLoop() {

        for (i in 1..3999) {
        }

        var running = true

        //Main program loop
        while (running) {
            printCommands()
            print("-> ")
            val input = readLine()!!
            if (input.equals("numeral")) {
                do {
                    print("Enter a numeral: ")
                    val numeralInput = readLine()!!

                    if (numeralInput.equals("quit"))
                        break

                    println(numeralToDecimal(numeralInput.uppercase()))

                } while (!numeralInput.equals("quit"))
            } else if (input.equals("decimal")) {
                do {
                    print("Enter a number: ")
                    var numberInput = 0
                    try {
                        val userInput = readLine()!!

                        if (userInput.equals("quit"))
                            break

                        numberInput = Integer.parseInt(userInput)
                        println(decimalToNumeral(numberInput))

                    } catch (e: Exception) {
                        println("Please enter an integer")
                    }

                } while (numberInput != -1)
            } else if (input.equals("quit")) {
                running = false
            }
        }
    }

    /*
    Helper function for numeralToDecimal()
    Searches the rules map to see if a given character is associated with any keys (rules[char]?.dec is the search)
    If the character is not found in the map, then it is invalid and the function returns null to indicate that
     */
    fun charIsLegal(char: Char): Boolean {
        return when (rules[char]?.dec) {
            null -> false
            else -> true
        }
    }

    fun numeralToDecimal(input: String): String {

        //Check cases of input lengths 0, 1, and 2
        if (input.isEmpty())
            return "Not a valid roman numeral"
        else if (input.length == 1) {
            return when (charIsLegal(input[0])) {
                true -> rules[input[0]]?.dec.toString()
                false -> "Not a valid roman numeral"
            }
        } else {
            var hasValidChars = true

            //check that every character is valid
            for (i in input.indices) {
                if (!charIsLegal(input[i])) {
                    hasValidChars = false
                    break
                }
            }

            if (hasValidChars) {

                var isValidNum = true
                var total = 0
                var i = 0
                while (i < input.length - 1) {

                    val currChar = input[i]
                    val nextChar = input[i + 1]

                    if (rules[currChar]!!.dec < rules[nextChar]!!.dec) {

                        if (currChar == rules[nextChar]?.preChar) {
                            total += rules[nextChar]!!.dec - rules[currChar]!!.dec
                            i++
                            //On the second to last char, the loop will end so add the last character to get correct total
                            if (i == input.length - 2) {
                                total += rules[input[i + 1]]?.dec!!
                            }
                        } else {
                            isValidNum = false
                            break
                        }
                    } else {
                        total += rules[currChar]?.dec!!

                        //On the second to last char, the loop will end so add the last character to get correct total
                        if (i == input.length - 2) {
                            total += rules[nextChar]?.dec!!
                        }
                    }
                    i++
                }
                return when (isValidNum) {
                    true -> total.toString()
                    false -> "Not a valid roman numeral"
                }
            } else {
                return "Not a valid roman numeral"
            }
        }
    }

    fun decimalToNumeral(input: Int): String {
        var numeral = ""
        var currTotal = input
        if (input < 1 || input > 3999)
            numeral = "Number out of range"
        else {
            while (currTotal > 0) {
                for (number in numbers) {
                    if (number.dec <= currTotal) {
                        currTotal -= number.dec
                        numeral += number.rom
                        break
                    }
                }
            }
        }
        return numeral
    }

    private fun printCommands() {
        println("Command List: (quit is the only one you can call while running a converter)")
        println("'numeral' -- convert roman numerals to decimals")
        println("'decimal' -- convert decimals to roman numerals")
        println("'quit' -- quit the current program")
    }
}

//data classes to store associations between a decimal number and a roman numeral
data class NumeralMapValues(val dec: Int, val preChar: Char?) //preChar = the legal preceding character to dec
data class NumeralAssociations(val dec: Int, val rom: String?)



