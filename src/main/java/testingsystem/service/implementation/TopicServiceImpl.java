package testingsystem.service.implementation;

import testingsystem.database.dao.implementation.TopicDaoImpl;
import testingsystem.domain.Topic;
import testingsystem.service.interfacepack.TopicService;

public class TopicServiceImpl implements TopicService {
    TopicDaoImpl topicRepository;

    @Override
    public Topic get(Long id) {
        return null;
    }
}
