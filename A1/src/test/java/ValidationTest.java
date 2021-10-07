import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public  class ValidationTest {

    @Test
    public void classNotNullTest() {
        Calculator c = new Calculator();
        assertNotNull(c);
    }
}