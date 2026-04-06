
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll; 
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) 
@DisplayName("Master Level JUnit Features")
class MasterTest {

    private int counter = 0;

    @BeforeAll
    void initAll() {
        System.out.println("Global Setup: Initializing...");
        counter = 0;
    }

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class) 
    @DisplayName("Counter Logic Group")
    class CounterTests {
        
        @Test
        @Order(1) 
        @DisplayName("Increment Test")
        void testIncrement() {
            counter++;
            assertEquals(1, counter, "Counter should be 1 after first increment");
        }

        @Test
        @Order(2)
        @DisplayName("Maintain State Test")
        void testState() {
            counter++;
            assertEquals(2, counter, "Counter should be 2 because state is maintained");
        }
    }

    @Test
    @Tag("System")
    @DisplayName("Environment Variable Check")
    void checkEnv() {
        assertNotNull(System.getProperty("java.version"), "Java version should be detectable");
    }
}