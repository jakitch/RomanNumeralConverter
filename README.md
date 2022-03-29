# RomanNumeralConverter
It took me about 3.5 hours to complete this challenge. It is a command line applicication and the user can choose which type of conversion they want to do when the program starts. There are some cases where my numeral to decimal converter does not always catch when a roman numeral is invalid (in the cases when there are more than 3 consecutive numerals or in a case of invalid subractive numeral precedence- single numeral precedence is checked for though), however it still adds up the symbols correctly in these cases and every valid roman numeral I tested comes out as the correct number. 

# Compiling
I decided to code this in Kotlin and used IntellijIDEA Community Edition to compose and compile/run it. If you are going to use a command line Kotlin compiler, it is not necessary to complie UnitTest.kt as that file is just a testing script for my own use that contains no implementation for the challenge. Just compile RomanConverter.kt with the latest version of Kotlin.