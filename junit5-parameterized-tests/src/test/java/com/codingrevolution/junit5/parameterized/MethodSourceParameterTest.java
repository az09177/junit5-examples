package com.codingrevolution.junit5.parameterized;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MethodSourceParameterTest {

    @ParameterizedTest
    @MethodSource("palindromesProvider")
    void palindromeReadsSameBackward(String string) {
        assertEquals(string, isPalindrome(string));
    }

    private String isPalindrome(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    private static Stream<String> palindromesProvider() {
        return Stream.of("racecar", "radar", "able was I ere I saw elba");
    }

    @ParameterizedTest(name = "{index} => arabic={0}, roman={1}")
    @MethodSource("arabicToRomanProvider")
    void convertArabicToRomanNumeral(int arabic, String roman) {
        assertEquals(roman, new RomanNumeral(arabic).toString());
    }

    private static Stream<Arguments> arabicToRomanProvider() {
        return Stream.of(
                Arguments.of(1, "I"),
                Arguments.of(3, "III"),
                Arguments.of(4, "IV"),
                Arguments.of(5, "V"),
                Arguments.of(6, "VI"),
                Arguments.of(8, "VIII"),
                Arguments.of(9, "IX"),
                Arguments.of(10, "X"),
                Arguments.of(11, "XI"),
                Arguments.of(14, "XIV"),
                Arguments.of(15, "XV"),
                Arguments.of(16, "XVI"),
                Arguments.of(39, "XXXIX"),
                Arguments.of(40, "XL"),
                Arguments.of(50, "L")
        );
    }
}
