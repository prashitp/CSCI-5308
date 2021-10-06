import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void classNotNullTest() {
        Calculator c = new Calculator();
        assertNotNull(c);
    }

    @Test
    public void addNegativeTest() {
        Calculator c = new Calculator();
        int ans = c.add(-4,-2);
        assertEquals(-6,-6);
    }

    @Test
    public void addPositiveTest() {
        Calculator c = new Calculator();
        int ans = c.add(4,2);
        assertEquals(6,6);
    }

 }