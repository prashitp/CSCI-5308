import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public  class ValidationTest {

    @Test
    public void classNotNullTest() {
        Validation v = new Validation();
        assertNotNull(v);
    }

    @Test
    public void validateTest() {
        Validation v = new Validation();
        List<String> ans = v.validate("1.11","2.321");
        assertEquals("Decimal Exceeded for 2.321",ans.get(0));
    }

}