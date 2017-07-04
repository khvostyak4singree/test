
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MyCode.Validator;

public class Tests {

    Validator myValidator;

    @DataProvider(name = "TestData")
    public Object[][] createData() {
        return new Object[][]{
                {"6000", Boolean.TRUE},
                {"6000,1", Boolean.FALSE},
                {"6000,10000", Boolean.TRUE},
                {"6000.10", Boolean.TRUE}
        };
    }

    @DataProvider(name = "TestEmail")
    public Object[][] createEmail() {
        return new Object[][]{
                {"test@gmail.com", Boolean.TRUE},
                {"@gmail.com", Boolean.FALSE},
                {"@mail.ru", Boolean.FALSE},
                {"@.com", Boolean.FALSE}
        };
    }
    
    @BeforeTest
    void setUp() {
        System.out.println("Created Object");
        myValidator = new Validator();
    }

    @Test(dataProvider = "TestData", description = "Test for Numbers Validation")
    void Positive(String testString, Boolean expectedResult) {
        System.out.println(testString);
        Assert.assertEquals((Boolean) myValidator.numbers(testString), expectedResult, "Bad input " + testString);
    }

    @Test(dataProvider = "TestEmail", description = "Test for Gmail Validation")
    void PositiveGamil(String testEmail, Boolean expectedGmail){
        System.out.println(testEmail);
        Assert.assertEquals((Boolean) myValidator.emails(testEmail), expectedGmail);
    }

    @AfterMethod
    void afterM(ITestResult testResult) {
        System.out.println(testResult.isSuccess());
        System.out.println(testResult.getMethod().getDescription());
    }
}