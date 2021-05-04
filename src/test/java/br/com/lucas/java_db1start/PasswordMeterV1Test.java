package br.com.lucas.java_db1start;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordMeterV1Test {

    @Test
    void checkPassword() {
        var expected = "Password: 123456\n" +
                "Score: 4\n" +
                "Complexity: Very Weak\n" +
                "Addictions\n" +
                "[C: 6 | B: 24] Number of Characters\n" +
                "[C: 0 | B: 0] Uppercase Letters\n" +
                "[C: 0 | B: 0] Lowercase Letters\n" +
                "[C: 6 | B: 0] Numbers\n" +
                "[C: 0 | B: 0] Symbols\n" +
                "[C: 4 | B: 8] Middle Numbers or Symbols\n" +
                "[C: 1 | B: 0] Requirements\n" +
                "Deductions\n" +
                "[C: 0 | B: 0] Letters Only\n" +
                "[C: 6 | B: 6] Numbers Only\n" +
                "[C: 0 | B: 0] Repeat Characters (Case Insensitive)\n" +
                "[C: 0 | B: 0] Consecutive Uppercase Letters\n" +
                "[C: 0 | B: 0] Consecutive Lowercase Letters\n" +
                "[C: 5 | B: 10] Consecutive Numbers\n" +
                "[C: 0 | B: 0] Sequential Letters\n" +
                "[C: 4 | B: 12] Sequential Numbers\n" +
                "[C: 0 | B: 0] Sequential Symbols";

        var meter = new PasswordMeterV1();

        meter.checkPassword("123456");

        assertEquals(expected, meter.toString());
    }
}