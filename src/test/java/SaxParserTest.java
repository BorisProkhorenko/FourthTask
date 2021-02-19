import com.epam.task.fourth.entity.Candy;
import com.epam.task.fourth.parsing.Parser;
import com.epam.task.fourth.parsing.SaxParser;
import org.junit.Assert;

import java.util.List;

public class SaxParserTest extends ParserTest {


    private static final Parser PARSER = new SaxParser();

    @Override
    public void testParseWhenCorrectFileApplied() {
        //when
        List<Candy> candiesActual = PARSER.parse(getFilenameCorrectFile());
        //then
        Assert.assertEquals(getCandiesExpected(), candiesActual);
    }


}
