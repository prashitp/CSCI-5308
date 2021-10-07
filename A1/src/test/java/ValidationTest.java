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
        List<String> ans = v.validate("1.11","2.22");
        assertEquals(0,ans.size());
    }

    @Test
    public void singleValidateTest() {
        Validation v = new Validation();
        List<String> ans = v.validate("1.111");
        assertEquals(1,ans.size());
    }
}