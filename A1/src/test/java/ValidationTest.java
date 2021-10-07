import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public  class ValidationTest {

    @Test
    public void classNotNullTest() {
        Validation v = new Validation();
        assertNotNull(v);
    }
}