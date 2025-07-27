package service;

import java.util.List;
import java.util.Optional;

import exception.QueryException;
import model.Question;
import persistence.QuestionPersistence;

public class QuestionService {

	private static final QuestionService INSTANCE = new QuestionService();

    private QuestionService() {
    }

    public static QuestionService getInstance() {
        return INSTANCE;
    }

	QuestionPersistence questionPersistence = QuestionPersistence.getInstance();

	
	public Optional<Question> selectQuestion(int questionId) throws QueryException {
		return this.questionPersistence.selectQuestion(questionId);
	}

	public List<Question> selectQuestions() {
		return this.questionPersistence.selectQuestions();
	}

}
