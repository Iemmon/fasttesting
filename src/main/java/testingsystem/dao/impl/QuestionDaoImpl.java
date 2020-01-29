package testingsystem.dao.impl;

import org.apache.log4j.Logger;
import testingsystem.dao.ConnectionPool;
import testingsystem.dao.exception.DataBaseSqlRuntimeException;
import testingsystem.dao.interfacepack.QuestionDao;
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
    private static final String COUNT_QUERY = "SELECT COUNT(*) FROM questions";
    private static final String UPDATE_QUERY = "UPDATE questions SET name=? WHERE id=?";
    private static final String FIND_ALL_ANSWERS_QUERY = "SELECT questions.id, questions.question_text, answers.id, answers.answer_text, answers.is_correct FROM questions INNER JOIN answers ON answers.question_id = questions.id WHERE questions.id=?";

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
    public List<Question> findAll() {
        return super.findAll();
    }

    @Override
    public Optional<Question> findById(Long id) {
        try (final PreparedStatement preparedStatement =
                     pool.getConnection().prepareStatement(FIND_ALL_ANSWERS_QUERY);) {

            preparedStatement.setLong(1, id);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                Question question = null;
                List<Answer> answers = new ArrayList<Answer>();
                while (resultSet.next()) {
                    if (question == null) {
                        question = new Question(resultSet.getLong("id"), resultSet.getString("question_text"), answers);
                    }
                    Answer answer = new Answer(resultSet.getString("answer_text"), resultSet.getBoolean("is_correct"));
                    answers.add(answer);
                }
                return Optional.ofNullable(question);
            }
        } catch (SQLException e) {
            LOGGER.warn(String.format(FIND_ALL_ANSWERS_QUERY + " failed", e));
            throw new DataBaseSqlRuntimeException("No entries were found", e);
        }
    }

    @Override
    public long count() {
        return super.count();
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
        return new Question(resultSet.getLong("id"), resultSet.getString("question"));
    }
}
