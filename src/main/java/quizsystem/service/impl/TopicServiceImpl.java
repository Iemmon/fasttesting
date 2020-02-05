package quizsystem.service.impl;

import quizsystem.dao.TopicDao;
import quizsystem.entity.Topic;
import quizsystem.service.TopicService;

import java.util.List;

public class TopicServiceImpl implements TopicService {
    private final TopicDao topicRepository;

    public TopicServiceImpl(TopicDao topicDao) {
        this.topicRepository = topicDao;
    }

    @Override
    public List<Topic> findAll() {
        return topicRepository.findAll();
    }
}
