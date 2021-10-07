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
        assertEquals(ans,-6);
    }

    @Test
    public void addPositiveTest() {
        Calculator c = new Calculator();
        int ans = c.add(4,2);
        assertEquals(ans,6);
    }

    @Test
    public void subtractNegativeTest() {
        Calculator c = new Calculator();
        int ans = c.subtract(-4,-2);
        assertEquals(ans,-2);
    }

    @Test
    public void subtractPositiveTest() {
        Calculator c = new Calculator();
        int ans = c.subtract(4,2);
        assertEquals(ans,2);
    }

    @Test
    public void multiplyTest() {
        Calculator c = new Calculator();
        int ans = c.multiply(5,2);
        assertEquals(ans,10);
    }

    @Test
    public void divideTest() {
        Calculator c = new Calculator();
        int ans = c.divide(10, 2);
        assertEquals(ans, 5);
    }

 }