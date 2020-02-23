package quizsystem.dao.impl;

import org.apache.log4j.Logger;
import quizsystem.dao.QuestionDao;
import quizsystem.dao.connectionpool.ConnectionPool;
import quizsystem.entity.Answer;
import quizsystem.entity.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDaoImpl extends AbstractCrudDaoImpl<Question> implements QuestionDao {
    protected static final Logger LOGGER = Logger.getLogger(QuestionDaoImpl.class);

    private static final String FIND_BY_ID_QUERY = "SELECT * FROM questions WHERE id=?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM questions";
    private static final String FIND_ALL_BY_TEST_ID_QUERY = "SELECT questions.id, questions.question_text, answers.id as answer_id, answers.answer_text, answers.is_correct FROM questions INNER JOIN answers ON answers.question_id = questions.id WHERE questions.test_id=?";
    private static final String COUNT_QUERY = "SELECT COUNT(*) FROM questions";

    public QuestionDaoImpl(ConnectionPool pool) {
        super(pool, FIND_BY_ID_QUERY, FIND_ALL_QUERY, COUNT_QUERY);
    }

    @Override
    public List<Question> findAllByTestId(Long id) {
        return findAllByParam(id, FIND_ALL_BY_TEST_ID_QUERY, LONG_PARAM_SETTER);
    }

    @Override
    protected Question mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        List<Answer> answers = new ArrayList<>();
        long currentQuestId = resultSet.getLong("id");
        Question question = new Question(currentQuestId, resultSet.getString("question_text"), answers);
        resultSet.previous();
        while (resultSet.next()) {
            if(resultSet.getLong("id") != currentQuestId){
                resultSet.previous();
                break;
            }
            Answer answer = new Answer(resultSet.getLong("answer_id"), resultSet.getString("answer_text"), resultSet.getBoolean("is_correct"));
            answers.add(answer);
        }
        return question;
    }
}
