import com.epam.task.fourth.validation.XmlValidator;
import org.junit.Assert;
import org.junit.Test;

public class ValidatorTest {

    private static final String FILENAME_CORRECT_FILE = "src/test/java/resources/candies.xml";
    private static final String FILENAME_INCORRECT_FILE = "src/test/java/resources/incorrect.xml";

    private static final XmlValidator VALIDATOR = new XmlValidator();

    @Test
    public void testIsValidWhenCorrectFileApplied(){
        //when
        boolean isValid = VALIDATOR.isValid(FILENAME_CORRECT_FILE);
        //then
        Assert.assertTrue(isValid);
    }

    @Test
    public void testIsValidWhenIncorrectFileApplied(){
        //when
        boolean isValid = VALIDATOR.isValid(FILENAME_INCORRECT_FILE);
        //then
        Assert.assertFalse(isValid);
    }
}
