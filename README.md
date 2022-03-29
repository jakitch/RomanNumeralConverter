# RomanNumeralConverter
It took me about 3.5 hours to complete this challenge. It is a command line application and the user can choose which type of conversion they want to do when the program starts. There are some cases where my numeral to decimal converter does not always catch when a roman numeral is invalid (in the cases when there are more than 3 consecutive numerals or in a case of invalid subtractive numeral precedence- single numeral precedence is checked for though), however it still adds up the symbols correctly in these cases and every valid roman numeral I tested comes out as the correct number. 

# Compiling
I decided to code this in Kotlin and used IntellijIDEA Community Edition to compose and compile/run it. For your convience I complied the code into a jar file that you can just run with Java. This jar is located in the excecutable directory. If you want to use a command line Kotlin compiler (or Intellij if you have it installed) to compile it yourself, it is not necessary to compile UnitTest.kt as that file is just a testing script for my own use that contains no implementation for the challenge. Just compile RomanConverter.kt with the latest version of Kotlin.

