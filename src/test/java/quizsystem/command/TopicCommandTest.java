package quizsystem.command;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import quizsystem.entity.Topic;
import quizsystem.service.TopicService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TopicCommandTest {

    @Mock
    private TopicService topicService;

    @InjectMocks
    private TopicCommand topicCommand;

    @Mock
    private HttpServletRequest request;

    @Test
    public void executeShouldRedirectToTopicsPage() {
        List<Topic> topicList = new ArrayList<>();
        when(topicService.findAll()).thenReturn(topicList);

        String topicsPage = topicCommand.execute(request);
        assertEquals("topics.jsp", topicsPage);

        verify(request).setAttribute("topics", topicList);
    }
}