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
    public void testIsEmailValid() {
        boolean actual = emailMasker.validateEmail("kovadam95@gmail.com");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testIsEmailInvalidMissingAt() {
        boolean actual = emailMasker.validateEmail("kovadam95gmail.com");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testIsEmailInvalidMissingDomainName() {
        boolean actual = emailMasker.validateEmail("kovadam95@");
        Assertions.assertFalse(actual);
    }

    @Test
    public void testMasking() {
        String actual = emailMasker.maskEmail("kovadam95@gmail.com");
        String expected = "k*******5@gmail.com";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMaskingUnder4CharactersLength() {
        String actual = emailMasker.maskEmail("sor@gmail.com");
        String expected = "s**@gmail.com";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testMaskingOnly1CharacterLength() {
        String actual = emailMasker.maskEmail("s@gmail.com");
        String expected = "s@gmail.com";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCheckInvalidCharacter() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> emailMasker.maskEmail("sör@gmail.com"));
    }
    @Test
    public void testCheckInvalidSpecialCharacter() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> emailMasker.maskEmail("s&r@gmail.com"));
    }
}