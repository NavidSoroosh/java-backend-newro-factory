package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Promotion;

public class PromotionMapper {

	private static final PromotionMapper INSTANCE = new PromotionMapper();

    private PromotionMapper() {
    }

    public static PromotionMapper getInstance() {
        return INSTANCE;
    }

    public Promotion mapResultSetToPromotion(ResultSet querySet) throws SQLException {
    	if (querySet.isBeforeFirst()) {
    		querySet.next();
    	}
    	
    	return new Promotion.PromotionBuilder(querySet.getInt(1), querySet.getString(2)).build();
    }

    public List<Promotion> mapResultSetToPromotions(ResultSet querySet) throws SQLException {
    	List<Promotion> promotions = new ArrayList<>();
    	
		while (querySet.next()) {
			promotions.add(mapResultSetToPromotion(querySet));
		}
		
    	return promotions;
    }

}
