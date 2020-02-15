package quizsystem.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import quizsystem.dao.QuestionDao;
import quizsystem.entity.Answer;
import quizsystem.entity.Question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class QuestionServiceImplTest {

    private static final Long TEST_ID = 10L;
    private static final Long ANSWER_ID_CHOSEN_BY_USER = 1L;

    @Mock
    private QuestionDao questionDao;

    @InjectMocks
    private QuestionServiceImpl questionService;

    @Test
    public void findAllByTestId() {
        List<Question> questionList = new ArrayList<>();
        when(questionDao.findAllByTestId(any(Long.class))).thenReturn(questionList);
        List<Question> questions = questionService.findAllByTestId(TEST_ID);
        assertSame(questionList, questions);
    }

    @Test
    public void getIncorrectAnsweredQuestionsShouldReturnNothingWhenAnswerIsCorrect() {
        List<Question> questionList = setListOfQuestions();
        Set<Long> userAnswers = new HashSet<>();
        userAnswers.add(ANSWER_ID_CHOSEN_BY_USER);

        when(questionDao.findAllByTestId(any(Long.class))).thenReturn(questionList);
        int numOfIncorrectAnswers = questionService.getIncorrectAnsweredQuestions(TEST_ID, userAnswers).size();
        assertEquals(0, numOfIncorrectAnswers);
    }

    private List<Question> setListOfQuestions(){
        List<Question> questionList = new ArrayList<>();
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer(1L, "Answer", true));
        answers.add(new Answer(2L, "Other answer", false));
        answers.add(new Answer(3L, "One more answer", false));

        questionList.add(new Question(1L, "Question text", answers));

        return questionList;
    }
}