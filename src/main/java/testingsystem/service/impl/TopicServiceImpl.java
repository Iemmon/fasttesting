package testingsystem.service.impl;

import testingsystem.dao.TopicDao;
import testingsystem.entity.Topic;
import testingsystem.service.TopicService;

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
