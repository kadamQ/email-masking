package uni.eszterhazy.multiparadigmas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmailMaskerTest {

    EmailMasker emailMasker;
    @BeforeEach
    void setUp() {
         emailMasker = new EmailMasker();
    }

    @Test
    public void  testIsEmailValid(){
        boolean actual = emailMasker.validateEmail("kovadam95@gmail.com");
        Assertions.assertEquals(true,actual);
    }
    @Test
    public void testIsEmailInvalidMissingAt(){
        boolean actual = emailMasker.validateEmail("kovadam95gmail.com");
        Assertions.assertEquals(false,actual);
    }
    @Test
    public void testIsEmailInvalidMissingDomainName(){
        boolean actual = emailMasker.validateEmail("kovadam95@");
        Assertions.assertEquals(false,actual);
    }
}