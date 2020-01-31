package testingsystem.service.impl;

import testingsystem.dao.impl.TopicDaoImpl;
import testingsystem.entity.Topic;
import testingsystem.service.TopicService;

public class TopicServiceImpl implements TopicService {
    TopicDaoImpl topicRepository;

    @Override
    public Topic get(Long id) {
        return null;
    }
}
