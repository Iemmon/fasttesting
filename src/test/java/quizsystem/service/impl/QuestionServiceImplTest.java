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

    @Mock
    private QuestionDao questionDao;

    @InjectMocks
    private QuestionServiceImpl questionService;

    @Test
    public void findAllByTestId() {
        List<Question> questionList = new ArrayList<>();
        when(questionDao.findAllByTestId(any(Long.class))).thenReturn(questionList);
        List<Question> questions = questionService.findAllByTestId(5L);
        assertSame(questionList, questions);
    }

    @Test
    public void getIncorrectAnsweredQuestions() {
        List<Question> questionList = new ArrayList<>();
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer(1L, "Answer", true));
        answers.add(new Answer(2L, "Other answer", false));
        answers.add(new Answer(3L, "One more answer", false));

        questionList.add(new Question(1L, "Question text", answers));

        when(questionDao.findAllByTestId(any(Long.class))).thenReturn(questionList);

        Set<Long> userAnswers = new HashSet<>();
        userAnswers.add(1L);
        assertEquals(0, questionService.getIncorrectAnsweredQuestions(10L, userAnswers).size());
    }
}
