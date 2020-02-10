package quizsystem.command;

import quizsystem.entity.Topic;
import quizsystem.service.TopicService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class TopicCommand implements Command{

    private final TopicService topicService;

    public TopicCommand(TopicService topicService) {
        this.topicService = topicService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        List<Topic> topics = topicService.findAll();
        request.setAttribute("topics", topics);
        return "topics.jsp";
    }
}
