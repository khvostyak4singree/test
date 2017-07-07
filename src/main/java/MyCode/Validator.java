package MyCode;

import java.util.regex.Pattern;

public class Validator {

    private String patterNumbers = "^(?:Numbers: )?(?:(?:[2-9][0-9]{3}|10000)(?:\\.\\d\\d)?(?:,|$))+$";
    private String patterEmails = "^(?i)(?:(?:[^@]+@gmail\\.com)(?:,|$))+$";
    private String patterSomething ="^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";

    public Validator() {
    }


    public boolean numbers(String input) {
        return Pattern.matches(this.patterNumbers, input);
    }

    public boolean emails(String input) {
        return Pattern.matches(this.patterEmails, input);
    }

    public boolean NewCoolValidator(String input) {

        return Pattern.matches(this.patterSomething, input.replaceAll(input, "192.168.0.1"));
    }
}