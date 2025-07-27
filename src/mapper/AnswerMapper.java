package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Answer;
import model.Chapter;
import model.Question;

public class AnswerMapper {

	private static final AnswerMapper INSTANCE = new AnswerMapper();

    private AnswerMapper() {
    }

    public static AnswerMapper getInstance() {
        return INSTANCE;
    }

    public Answer mapResultSetToAnswer(ResultSet querySet) throws SQLException {
    	if (querySet.isBeforeFirst()) {
    		querySet.next();
    	}
    	
    	return new Answer.AnswerBuilder(querySet.getInt(1), querySet.getString(2), querySet.getString(3), querySet.getInt(4), 
    			new Question.QuestionBuilder(querySet.getInt(5), querySet.getString(6), querySet.getString(7), 
    			new Chapter.ChapterBuilder(querySet.getInt(8), querySet.getString(9), querySet.getString(10)).build()).build()).build();
    }

    public List<Answer> mapResultSetToAnswers(ResultSet querySet) throws SQLException {
    	List<Answer> answers = new ArrayList<>();
    	
		while (querySet.next()) {
			answers.add(mapResultSetToAnswer(querySet));
		}
		
    	return answers;
    }

}
