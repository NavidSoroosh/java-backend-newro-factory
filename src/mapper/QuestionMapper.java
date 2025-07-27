package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Chapter;
import model.Question;

public class QuestionMapper {

	private static final QuestionMapper INSTANCE = new QuestionMapper();

    private QuestionMapper() {
    }

    public static QuestionMapper getInstance() {
        return INSTANCE;
    }

    public Question mapResultSetToQuestion(ResultSet querySet) throws SQLException {
    	if (querySet.isBeforeFirst()) {
    		querySet.next();
    	}
    	
    	return new Question.QuestionBuilder(querySet.getInt(1), querySet.getString(2), querySet.getString(3), 
    			new Chapter.ChapterBuilder(querySet.getInt(4), querySet.getString(5), querySet.getString(6)).build()).build();
    }

    public List<Question> mapResultSetToQuestions(ResultSet querySet) throws SQLException {
    	List<Question> questions = new ArrayList<>();
    	
		while (querySet.next()) {
			questions.add(mapResultSetToQuestion(querySet));
		}
		
    	return questions;
    }

}
