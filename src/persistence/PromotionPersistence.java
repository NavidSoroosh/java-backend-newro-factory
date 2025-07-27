package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import mapper.PromotionMapper;
import model.Promotion;

public class PromotionPersistence {

	private static final PromotionPersistence INSTANCE = new PromotionPersistence();

	private final String selectPromotionsQuery = "SELECT id, name FROM promotion";

    private PromotionPersistence() {
    }

    public static PromotionPersistence getInstance() {
        return INSTANCE;
    }

	ConnectMySQL connectMySQL = ConnectMySQL.getInstance();
	PromotionMapper mapper = PromotionMapper.getInstance();
	
    public List<Promotion> selectPromotions() {
		try (Connection connection = connectMySQL.getConnection()) {
			Statement statement = connection.createStatement();
			return mapper.mapResultSetToPromotions(statement.executeQuery(selectPromotionsQuery));
		} catch (SQLException e) {
			return null;
		}
    }

}
