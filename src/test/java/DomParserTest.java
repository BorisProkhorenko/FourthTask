import com.epam.task.fourth.entity.Candy;
import com.epam.task.fourth.parsing.DomParser;
import com.epam.task.fourth.parsing.Parser;
import org.junit.Assert;

import java.util.List;

public class DomParserTest extends ParserTest {


    private static final Parser PARSER = new DomParser();

    @Override
    public void testParseWhenCorrectFileApplied() {
        //when
        List<Candy> candiesActual = PARSER.parse(getFilenameCorrectFile());
        //then
        Assert.assertEquals(getCandiesExpected(), candiesActual);
    }

}
