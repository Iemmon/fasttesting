package quizsystem.servlet.filter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ShieldedRequestTest {

    @InjectMocks
    ShieldedRequest shieldedRequest;

    @Mock
    HttpServletRequest request;

    @Test
    public void getParameterValues() {
        String param = "someParameter";
        String[] values = {"<script>alert();</script>", "eval(alert(););"};
        String[] expectedResult = {"&lt;&gt;alert&#40;&#41;;&lt;/&gt;", ";"};

        when(request.getParameterValues(anyString())).thenReturn(values);

        String[] results = shieldedRequest.getParameterValues(param);

        assertArrayEquals(expectedResult, results);
        verify(request).getParameterValues(eq(param));
    }

    @Test
    public void getParameter() {

        String param = "someParameter";
        String value = "<script>alert();</script>";
        String expectedResult = "&lt;&gt;alert&#40;&#41;;&lt;/&gt;";

        when(request.getParameter(anyString())).thenReturn(value);

        String result = shieldedRequest.getParameter(param);

        assertEquals(expectedResult, result);
        verify(request).getParameter(eq(param));
    }

    @Test
    public void getHeader() {

        String param = "someParameter";
        String value = "<script>alert();</script>";
        String expectedResult = "&lt;&gt;alert&#40;&#41;;&lt;/&gt;";

        when(request.getHeader(anyString())).thenReturn(value);

        String result = shieldedRequest.getHeader(param);
        assertEquals(expectedResult, result);
        verify(request).getHeader(eq(param));
    }
}