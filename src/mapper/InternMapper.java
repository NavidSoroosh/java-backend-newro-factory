package mapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Intern;
import model.Promotion;

public class InternMapper {

	private static final InternMapper INSTANCE = new InternMapper();

    private InternMapper() {
    }

    public static InternMapper getInstance() {
        return INSTANCE;
    }

    public Intern mapResultSetToIntern(ResultSet querySet) throws SQLException {
    	if (querySet.isBeforeFirst()) {
    		querySet.next();
    	}
    	
    	Date arrival = querySet.getDate(4);
    	Date formationOver = querySet.getDate(5);
    	if (arrival == null || formationOver == null) {
    		
    	}
    	arrival.toLocalDate();
    	formationOver.toLocalDate();
    	
    	return new Intern.InternBuilder(querySet.getString(2), querySet.getString(3), querySet.getDate(4).toLocalDate(), 
    			new Promotion.PromotionBuilder(querySet.getInt(6), querySet.getString(7)).build()
    			).setId(querySet.getInt(1)).setFormationOver(querySet.getDate(5).toLocalDate()).build();
    }

    public List<Intern> mapResultSetToInterns(ResultSet querySet) throws SQLException {
    	List<Intern> interns = new ArrayList<>();
    	
		while (querySet.next()) {
			interns.add(mapResultSetToIntern(querySet));
		}
		
    	return interns;
    }

}
