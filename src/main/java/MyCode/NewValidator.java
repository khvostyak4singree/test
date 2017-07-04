package MyCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hillel on 04.07.17.
 */
public class NewValidator {

    private String patterSomething = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";

    public String NewCoolValidator(String testIP){

        return patterSomething.replaceAll(this.patterSomething, testIP);

    }
}
