package quizsystem.dao.pagination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class PageRequestParserTest {



    @Test
    public void parseIntoPageRequest() {
        String page = "1";
        int itemsPerPage = 5;
        int maxUsers = 21;

        PageRequest request = PageRequestParser.parseIntoPageRequest(page, itemsPerPage, maxUsers);
        assertEquals(1, request.getPageNumber());
        assertEquals(5, request.getItemsPerPage());
        assertEquals(5, request.getMaxPages());
    }
}