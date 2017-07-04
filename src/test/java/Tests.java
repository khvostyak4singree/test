
import MyCode.NewValidator;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import MyCode.Validator;
import MyCode.NewValidator;
import java.io.IOException;

public class Tests {

    Validator myValidator;
    NewValidator myNewValidator;
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

    @DataProvider(name = "TestIP")
    public Object[][] createIP() {
        return new Object[][]{
                {"192.168.0.33", Boolean.TRUE},
                {"192.168.0.444", Boolean.TRUE},
                {"192.168.0.33", Boolean.TRUE},
                {"192.168.0.2", Boolean.TRUE}
        };
    }




    @BeforeTest
    void setUp() throws IOException {
        System.out.println("Created Object");
        myValidator = new Validator();
        myNewValidator = new NewValidator();
    }

    @Test(dataProvider = "TestData", description = "Test for Numbers Validation")
    void Positive(String testString, Boolean expectedResult) {
        System.out.println(testString);
        Assert.assertEquals((Boolean) myValidator.numbers(testString), expectedResult, "Bad input " + testString);
    }

    @Test(dataProvider = "TestEmail", description = "Test for Gmail Validation")
    void PositiveGmail(String testEmail, Boolean expectedGmail){
        System.out.println(testEmail);
        Assert.assertEquals((Boolean) myValidator.emails(testEmail), expectedGmail);
    }

    @Test(dataProvider = "TestIP")
    void IPCheck(String testIP, Boolean expectedIP) throws IOException {
        System.out.println(testIP);
        Assert.assertTrue((Boolean) myNewValidator.NewCoolValidator(testIP), expectedIP);

    }

    @AfterMethod
    void afterM(ITestResult testResult) {
        System.out.println(testResult.isSuccess());
        System.out.println(testResult.getMethod().getDescription());
    }
}