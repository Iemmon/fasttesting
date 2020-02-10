package quizsystem.dao.pagination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PageRequestParserTest {

    @Parameterized.Parameter
    public String page;
    @Parameterized.Parameter(1)
    public int maxUsers;
    @Parameterized.Parameter(2)
    public int expectedPageNumber;
    @Parameterized.Parameter(3)
    public int expectedMaxPages;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"wrsd", 21, 1, 5},
                {null, 21, 1, 5},
                {"2", 400, 2, 80},
                {"12", 12, 3, 3},
                {"-5", 40, 1, 8},
                {"3", 16, 3, 4}
        });
    }

    @Test
    public void parseIntoPageRequest() {
        PageRequest request = PageRequestParser.parseIntoPageRequest(page, maxUsers);
        assertEquals(expectedPageNumber, request.getPageNumber());
        assertEquals(expectedMaxPages, request.getMaxPages());
    }
}