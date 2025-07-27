package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import mapper.QuestionMapper;
import model.Question;

public class QuestionPersistence {

	private static final QuestionPersistence INSTANCE = new QuestionPersistence();
	
	private final String selectQuestionQuery = "SELECT id, title, statement, chapter.id, chapter.name, chapter.parent_path "
			+ "FROM question INNER JOIN chapter ON question.chapter_id = chapter.id WHERE id = ?";

	private final String selectQuestionsQuery = "SELECT id, title, statement, chapter.id, chapter.name, chapter.parent_path "
			+ "FROM question INNER JOIN chapter ON question.chapter_id = chapter.id";
	
    private QuestionPersistence() {
    }

    public static QuestionPersistence getInstance() {
        return INSTANCE;
    }

	ConnectMySQL connectMySQL = ConnectMySQL.getInstance();
	QuestionMapper mapper = QuestionMapper.getInstance();

    public Optional<Question> selectQuestion(int questionId) {
		try (Connection connection = connectMySQL.getConnection()) {
		    PreparedStatement preparedStatement = connection.prepareStatement(selectQuestionQuery);
		    preparedStatement.setInt(1, questionId);
			return Optional.ofNullable(mapper.mapResultSetToQuestion(preparedStatement.executeQuery()));
		} catch (SQLException e) {
			return null;
		}
    }

    public List<Question> selectQuestions() {
		try (Connection connection = connectMySQL.getConnection()) {
			Statement statement = connection.createStatement();
			return mapper.mapResultSetToQuestions(statement.executeQuery(selectQuestionsQuery));
		} catch (SQLException e) {
			return null;
		}
    }

}
