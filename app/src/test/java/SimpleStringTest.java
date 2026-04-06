import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SimpleStringTest {

    @Test
    @DisplayName("Basic String Content Test")
    void testStringContent() {
        String text = "JUnit 5 is cool";
        
        assertTrue(text.contains("JUnit"), "Text should contain 'JUnit'");
        assertEquals(15, text.length(), "Length should be exactly 15");
    }

    @Test
    @DisplayName("Empty vs Blank Test")
    void testEmptyStrings() {
        String empty = "";
        String space = "   ";

        assertTrue(empty.isEmpty());
        assertFalse(space.isEmpty(), "Space is not empty, it has length!");

        assertTrue(empty.isBlank());
        assertTrue(space.isBlank(), "Space should be considered blank");
    }

    @Test
    @DisplayName("Case Sensitivity Test")
    void testCase() {
        String original = "ALPEREN";
        String lower = original.toLowerCase();

        assertNotEquals(original, lower, "Uppercase and Lowercase are NOT the same!");
        assertEquals("alperen", lower);
    }

    @Test
    @DisplayName("Null Check Test")
    void testNull() {
        String str = null;
        assertNull(str, "Variable should be null initially");
        
        str = "not null anymore";
        assertNotNull(str);
    }
}