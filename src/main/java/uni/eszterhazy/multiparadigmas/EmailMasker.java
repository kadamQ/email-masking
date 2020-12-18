package uni.eszterhazy.multiparadigmas;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailMasker {
    private static final int LENGTH_BELOW_FIRST_CHARACTER_MASKING = 4;

    protected boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    public String maskEmail(String email) {
        if (!validateEmail(email))
            throw new IllegalArgumentException("Invalid email format!");
        String domain = email.substring(email.indexOf('@'));
        String textBeforeAt = email.substring(0, email.indexOf('@'));
        if(textBeforeAt.length() < LENGTH_BELOW_FIRST_CHARACTER_MASKING)
            return textBeforeAt.replaceAll("(?<!^).", "*") + domain;
        else
            return textBeforeAt.replaceAll("(?<!^).(?!$)", "*") + domain;
    }
}
