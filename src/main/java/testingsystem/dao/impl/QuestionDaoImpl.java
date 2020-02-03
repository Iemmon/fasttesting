package testingsystem.dao.impl;

import org.apache.log4j.Logger;
import testingsystem.dao.connectionpool.ConnectionPool;
import testingsystem.dao.exception.DataBaseSqlRuntimeException;
import testingsystem.dao.QuestionDao;
import testingsystem.entity.Answer;
import testingsystem.entity.Question;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuestionDaoImpl extends AbstractCrudDaoImpl<Question> implements QuestionDao {
    protected static final Logger LOGGER = Logger.getLogger(QuestionDaoImpl.class);

    private static final String DELETE_QUERY = "DELETE FROM questions WHERE id=?";
    private static final String SAVE_QUERY = "INSERT INTO questions name=?";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM questions WHERE id=?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM questions";
    private static final String FIND_ALL_BY_TEST_ID_QUERY = "SELECT questions.id, questions.question_text, answers.id as answer_id, answers.answer_text, answers.is_correct FROM questions INNER JOIN answers ON answers.question_id = questions.id WHERE questions.test_id=?";
    private static final String COUNT_QUERY = "SELECT COUNT(*) FROM questions";
    private static final String UPDATE_QUERY = "UPDATE questions SET name=? WHERE id=?";
    private static final String FIND_ALL_ANSWERS_QUERY = "SELECT questions.id, questions.question_text, answers.id as answer_id, answers.answer_text, answers.is_correct FROM questions INNER JOIN answers ON answers.question_id = questions.id WHERE questions.id=?";

    public QuestionDaoImpl(ConnectionPool pool) {
        super(pool, FIND_BY_ID_QUERY, FIND_ALL_QUERY, COUNT_QUERY);
    }

    @Override
    public void save(Question entity) {
        try (final PreparedStatement preparedStatement = pool.getConnection().prepareStatement(SAVE_QUERY)) {
            preparedStatement.setString(1, entity.getQuestion());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn(String.format(SAVE_QUERY + " failed", e));
            throw new DataBaseSqlRuntimeException("Question saving failed", e);
        }
    }

    @Override
    public List<Question> findAllByTestId(Long id) {
        return findAllByParam(id, FIND_ALL_BY_TEST_ID_QUERY, LONG_PARAM_SETTER);
    }

    @Override
    public Optional<Question> findById(Long id) throws DataBaseSqlRuntimeException {
        return findByParam(id, FIND_ALL_ANSWERS_QUERY, LONG_PARAM_SETTER);
    }

    @Override
    public void update(Question entity) {
        try (final PreparedStatement preparedStatement = pool.getConnection().prepareStatement(UPDATE_QUERY)) {
            preparedStatement.setString(1, entity.getQuestion());
            preparedStatement.setLong(2, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn(String.format(UPDATE_QUERY + " failed", e));
            throw new DataBaseSqlRuntimeException("Question update fail", e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try (final PreparedStatement preparedStatement = pool.getConnection().prepareStatement(DELETE_QUERY)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            LOGGER.warn(String.format(DELETE_QUERY + " failed", e));
            throw new DataBaseSqlRuntimeException("No questions were found", e);
        }
    }

    @Override
    protected Question mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        List<Answer> answers = new ArrayList<>();
        long currentQuestId = resultSet.getLong("id");
        Question question = new Question(resultSet.getLong("id"), resultSet.getString("question_text"), answers);
        resultSet.previous();
        while (resultSet.next()) {
            if(resultSet.getLong("id") != currentQuestId){
                resultSet.previous();
                break;
            }
            Answer answer = new Answer(resultSet.getString("answer_text"), resultSet.getBoolean("is_correct"));
            answers.add(answer);
        }
        return question;
    }
}
