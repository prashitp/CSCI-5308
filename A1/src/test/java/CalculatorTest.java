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
        assertEquals(-6,ans);
    }

    @Test
    public void addPositiveTest() {
        Calculator c = new Calculator();
        int ans = c.add(4,2);
        assertEquals(6,ans);
    }

    @Test
    public void subtractNegativeTest() {
        Calculator c = new Calculator();
        int ans = c.subtract(-4,-2);
        assertEquals(-2,ans);
    }

    @Test
    public void subtractPositiveTest() {
        Calculator c = new Calculator();
        int ans = c.subtract(4,2);
        assertEquals(2,ans);
    }

    @Test
    public void multiplyTest() {
        Calculator c = new Calculator();
        int ans = c.multiply(5,2);
        assertEquals(10,ans);
    }

    @Test
    public void divideTest() {
        Calculator c = new Calculator();
        int ans = c.divide(10, 2);
        assertEquals(5,ans);
    }

    @Test
    public void fizzBuzzContainsDivisibleBy3NoTest(){
        Calculator c = new Calculator();
        String ans = c.fizzbuzz(3);
        assertTrue(ans.contains("Fizz"));
    }

    @Test
    public void fizzBuzzContainsdivisibleBy5NoTest(){
        Calculator c = new Calculator();
        String ans = c.fizzbuzz(5);
        assertTrue(ans.contains("Buzz"));
    }

    @Test
    public void fizzBuzzContainesDivisibleBy3And5NoTest(){
        Calculator c = new Calculator();
        String ans = c.fizzbuzz(15);
        assertTrue(ans.contains("FizzBuzz"));
    }

    @Test
    public void fizzBuzzContainesNotDivisibleBy3And5NoTest(){
        Calculator c = new Calculator();
        String ans = c.fizzbuzz(2);
        assertTrue(ans.contains("2"));
    }

    @Test
    public void addStringsTest() {
        Calculator c = new Calculator();
        String ans = null;
        try {
            ans = c.addStrings("5.12","2.42");
        } catch (DecimalExceededException e) {
            System.out.println(e);
        }
        assertEquals("7.54",ans);
    }

    @Test
    public void addStringsMoreThan2DecimalExceptionTest() throws DecimalExceededException {
        Calculator c = new Calculator();
        Exception exp = assertThrows(DecimalExceededException.class, () -> c.addStrings("5.12212","2.4212"));
        assertEquals("Decimal places exceeded.",exp.getMessage());
    }

 }