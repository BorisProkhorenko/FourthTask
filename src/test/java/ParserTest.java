import com.epam.task.fourth.entity.Candy;
import com.epam.task.fourth.entity.CaramelCandy;
import com.epam.task.fourth.entity.ChocolateCandy;
import com.epam.task.fourth.enums.CaramelType;
import com.epam.task.fourth.enums.ChocolateType;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public abstract class ParserTest {

    private static final String FILENAME_CORRECT_FILE = "src/test/java/resources/candies.xml";


    private static List<Candy> candiesExpected;

    @BeforeClass
    public static void initialize() {
        CaramelCandy caramelCandy = new CaramelCandy("i-1","Apple Pops", 0.382, CaramelType.LOLLIPOP);
        ChocolateCandy chocolateCandy = new ChocolateCandy("i-2","Hershey's Kisses",
                0.535, ChocolateType.MILK);
        candiesExpected = new ArrayList<>();
        candiesExpected.add(caramelCandy);
        candiesExpected.add(chocolateCandy);
    }

    @Test
    public abstract void testParseWhenCorrectFileApplied();



    public static String getFilenameCorrectFile() {
        return FILENAME_CORRECT_FILE;
    }

    public static List<Candy> getCandiesExpected() {
        return candiesExpected;
    }
}
