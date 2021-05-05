package br.com.lucas.java_db1start;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PasswordMeterV2Test {

    private PasswordMeterV2 meter;

    @BeforeEach
    private void setup() {
        this.meter = new PasswordMeterV2();
    }

    @Test
    public void checkEmptyPassword() {
        String expected = "Password: \n" +
                "Score: 0\n" +
                "Complexity: Very Weak\n" +
                "Addictions\n" +
                "[C: 0 | B: 0] Number of Characters\n" +
                "[C: 0 | B: 0] Uppercase Letters\n" +
                "[C: 0 | B: 0] Lowercase Letters\n" +
                "[C: 0 | B: 0] Numbers\n" +
                "[C: 0 | B: 0] Symbols\n" +
                "[C: 0 | B: 0] Middle Numbers or Symbols\n" +
                "[C: 0 | B: 0] Requirements\n" +
                "Deductions\n" +
                "[C: 0 | B: 0] Letters Only\n" +
                "[C: 0 | B: 0] Numbers Only\n" +
                "[C: 0 | B: 0] Repeat Characters (Case Insensitive)\n" +
                "[C: 0 | B: 0] Consecutive Uppercase Letters\n" +
                "[C: 0 | B: 0] Consecutive Lowercase Letters\n" +
                "[C: 0 | B: 0] Consecutive Numbers\n" +
                "[C: 0 | B: 0] Sequential Letters\n" +
                "[C: 0 | B: 0] Sequential Numbers\n" +
                "[C: 0 | B: 0] Sequential Symbols";

        this.meter.checkPassword("");
        assertEquals(expected, this.meter.toString());
    }

    @Test
    public void checkVeryWeakPassword() {
        String expected = "Password: 123\n" +
                "Score: 4\n" +
                "Complexity: Very Weak\n" +
                "Addictions\n" +
                "[C: 3 | B: 12] Number of Characters\n" +
                "[C: 0 | B: 0] Uppercase Letters\n" +
                "[C: 0 | B: 0] Lowercase Letters\n" +
                "[C: 3 | B: 0] Numbers\n" +
                "[C: 0 | B: 0] Symbols\n" +
                "[C: 1 | B: 2] Middle Numbers or Symbols\n" +
                "[C: 1 | B: 0] Requirements\n" +
                "Deductions\n" +
                "[C: 0 | B: 0] Letters Only\n" +
                "[C: 3 | B: 3] Numbers Only\n" +
                "[C: 0 | B: 0] Repeat Characters (Case Insensitive)\n" +
                "[C: 0 | B: 0] Consecutive Uppercase Letters\n" +
                "[C: 0 | B: 0] Consecutive Lowercase Letters\n" +
                "[C: 2 | B: 4] Consecutive Numbers\n" +
                "[C: 0 | B: 0] Sequential Letters\n" +
                "[C: 1 | B: 3] Sequential Numbers\n" +
                "[C: 0 | B: 0] Sequential Symbols";

        this.meter.checkPassword("123");
        assertEquals(expected, this.meter.toString());
    }

    @Test
    public void checkWeakPassword() {
        String expected = "Password: abc123\n" +
                "Score: 32\n" +
                "Complexity: Weak\n" +
                "Addictions\n" +
                "[C: 6 | B: 24] Number of Characters\n" +
                "[C: 0 | B: 0] Uppercase Letters\n" +
                "[C: 3 | B: 6] Lowercase Letters\n" +
                "[C: 3 | B: 12] Numbers\n" +
                "[C: 0 | B: 0] Symbols\n" +
                "[C: 2 | B: 4] Middle Numbers or Symbols\n" +
                "[C: 2 | B: 0] Requirements\n" +
                "Deductions\n" +
                "[C: 0 | B: 0] Letters Only\n" +
                "[C: 0 | B: 0] Numbers Only\n" +
                "[C: 0 | B: 0] Repeat Characters (Case Insensitive)\n" +
                "[C: 0 | B: 0] Consecutive Uppercase Letters\n" +
                "[C: 2 | B: 4] Consecutive Lowercase Letters\n" +
                "[C: 2 | B: 4] Consecutive Numbers\n" +
                "[C: 1 | B: 3] Sequential Letters\n" +
                "[C: 1 | B: 3] Sequential Numbers\n" +
                "[C: 0 | B: 0] Sequential Symbols";

        this.meter.checkPassword("abc123");
        assertEquals(expected, this.meter.toString());
    }

    @Test
    public void checkGoodPassword() {
        String expected = "Password: 124a58\n" +
                "Score: 54\n" +
                "Complexity: Good\n" +
                "Addictions\n" +
                "[C: 6 | B: 24] Number of Characters\n" +
                "[C: 0 | B: 0] Uppercase Letters\n" +
                "[C: 1 | B: 10] Lowercase Letters\n" +
                "[C: 5 | B: 20] Numbers\n" +
                "[C: 0 | B: 0] Symbols\n" +
                "[C: 3 | B: 6] Middle Numbers or Symbols\n" +
                "[C: 2 | B: 0] Requirements\n" +
                "Deductions\n" +
                "[C: 0 | B: 0] Letters Only\n" +
                "[C: 0 | B: 0] Numbers Only\n" +
                "[C: 0 | B: 0] Repeat Characters (Case Insensitive)\n" +
                "[C: 0 | B: 0] Consecutive Uppercase Letters\n" +
                "[C: 0 | B: 0] Consecutive Lowercase Letters\n" +
                "[C: 3 | B: 6] Consecutive Numbers\n" +
                "[C: 0 | B: 0] Sequential Letters\n" +
                "[C: 0 | B: 0] Sequential Numbers\n" +
                "[C: 0 | B: 0] Sequential Symbols";

        this.meter.checkPassword("124a58");
        assertEquals(expected, this.meter.toString());
    }

    @Test
    public void checkStrongPassword() {
        String expected = "Password: abc123ha33!\n" +
                "Score: 79\n" +
                "Complexity: Strong\n" +
                "Addictions\n" +
                "[C: 11 | B: 44] Number of Characters\n" +
                "[C: 0 | B: 0] Uppercase Letters\n" +
                "[C: 5 | B: 12] Lowercase Letters\n" +
                "[C: 5 | B: 20] Numbers\n" +
                "[C: 1 | B: 6] Symbols\n" +
                "[C: 5 | B: 10] Middle Numbers or Symbols\n" +
                "[C: 4 | B: 8] Requirements\n" +
                "Deductions\n" +
                "[C: 0 | B: 0] Letters Only\n" +
                "[C: 0 | B: 0] Numbers Only\n" +
                "[C: 5 | B: 3] Repeat Characters (Case Insensitive)\n" +
                "[C: 0 | B: 0] Consecutive Uppercase Letters\n" +
                "[C: 3 | B: 6] Consecutive Lowercase Letters\n" +
                "[C: 3 | B: 6] Consecutive Numbers\n" +
                "[C: 1 | B: 3] Sequential Letters\n" +
                "[C: 1 | B: 3] Sequential Numbers\n" +
                "[C: 0 | B: 0] Sequential Symbols";

        this.meter.checkPassword("abc123ha33!");
        assertEquals(expected, this.meter.toString());
    }

    @Test
    public void checkVeryStrongPassword() {
        String expected = "Password: a23b#c12@a33!\n" +
                "Score: 100\n" +
                "Complexity: Very Strong\n" +
                "Addictions\n" +
                "[C: 13 | B: 52] Number of Characters\n" +
                "[C: 0 | B: 0] Uppercase Letters\n" +
                "[C: 4 | B: 18] Lowercase Letters\n" +
                "[C: 6 | B: 24] Numbers\n" +
                "[C: 3 | B: 18] Symbols\n" +
                "[C: 8 | B: 16] Middle Numbers or Symbols\n" +
                "[C: 4 | B: 8] Requirements\n" +
                "Deductions\n" +
                "[C: 0 | B: 0] Letters Only\n" +
                "[C: 0 | B: 0] Numbers Only\n" +
                "[C: 7 | B: 3] Repeat Characters (Case Insensitive)\n" +
                "[C: 0 | B: 0] Consecutive Uppercase Letters\n" +
                "[C: 0 | B: 0] Consecutive Lowercase Letters\n" +
                "[C: 3 | B: 6] Consecutive Numbers\n" +
                "[C: 0 | B: 0] Sequential Letters\n" +
                "[C: 0 | B: 0] Sequential Numbers\n" +
                "[C: 0 | B: 0] Sequential Symbols";

        this.meter.checkPassword("a23b#c12@a33!");
        assertEquals(expected, this.meter.toString());
    }

    @Test
    public void checkPasswordWithSpaces() {
        String expected = "Password: a b 1 4 # @ a\n" +
                "Score: 100\n" +
                "Complexity: Very Strong\n" +
                "Addictions\n" +
                "[C: 13 | B: 52] Number of Characters\n" +
                "[C: 0 | B: 0] Uppercase Letters\n" +
                "[C: 3 | B: 20] Lowercase Letters\n" +
                "[C: 2 | B: 8] Numbers\n" +
                "[C: 2 | B: 12] Symbols\n" +
                "[C: 4 | B: 8] Middle Numbers or Symbols\n" +
                "[C: 4 | B: 8] Requirements\n" +
                "Deductions\n" +
                "[C: 0 | B: 0] Letters Only\n" +
                "[C: 0 | B: 0] Numbers Only\n" +
                "[C: 2 | B: 1] Repeat Characters (Case Insensitive)\n" +
                "[C: 0 | B: 0] Consecutive Uppercase Letters\n" +
                "[C: 1 | B: 2] Consecutive Lowercase Letters\n" +
                "[C: 1 | B: 2] Consecutive Numbers\n" +
                "[C: 0 | B: 0] Sequential Letters\n" +
                "[C: 0 | B: 0] Sequential Numbers\n" +
                "[C: 0 | B: 0] Sequential Symbols";

        this.meter.checkPassword("a b 1 4 # @ a");
        assertEquals(expected, this.meter.toString());
    }
}