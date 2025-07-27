package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Chapter;

public class ChapterMapper {

	private static final ChapterMapper INSTANCE = new ChapterMapper();

    private ChapterMapper() {
    }

    public static ChapterMapper getInstance() {
        return INSTANCE;
    }

    public Chapter mapResultSetToChapter(ResultSet querySet) throws SQLException {
    	if (querySet.isBeforeFirst()) {
    		querySet.next();
    	}
    	
		return new Chapter.ChapterBuilder(querySet.getInt(1), querySet.getString(2), querySet.getString(3)).build();
    }

    public List<Chapter> mapResultSetToChapters(ResultSet querySet) throws SQLException {
    	List<Chapter> chapters = new ArrayList<>();
    	
		while (querySet.next()) {
			chapters.add(mapResultSetToChapter(querySet));
		}
		
    	return chapters;
    }

}
