package persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import exception.QueryException;
import mapper.InternMapper;
import model.Intern;

public class InternPersistence {

	private static final InternPersistence INSTANCE = new InternPersistence();
	
	private final String selectInternQuery = "SELECT first_name, last_name, arrival, formation_over, promotion_id, "
			+ "promotion.name FROM intern INNER JOIN promotion ON intern.promotion_id = promotion.id WHERE intern.id = ?";
	
	private final String selectInternsQuery = "SELECT first_name, last_name, arrival, formation_over, promotion_id, "
			+ "promotion.name FROM intern INNER JOIN promotion ON intern.promotion_id = promotion.id";

	private final String selectInternsPageQuery = "SELECT first_name, last_name, arrival, formation_over, promotion_id, "
			+ "promotion.name FROM intern INNER JOIN promotion ON intern.promotion_id = promotion.id LIMIT ?, ?";
	
	private final String insertInternQuery = "INSERT INTO intern (first_name, last_name, arrival, formation_over, promotion_id) "
			+ "VALUES (?, ?, ?, ?, ?)";

	private final String updateInternQuery = "UPDATE intern SET first_name = ?, last_name = ?, arrival = ?, formation_over = ?, promotion_id = ? "
			+ "WHERE id = ?";
	
	private final String deleteInternQuery = "DELETE FROM intern WHERE id = ?";
	
    private InternPersistence() {
    }

    public static InternPersistence getInstance() {
        return INSTANCE;
    }

	ConnectMySQL connectMySQL = ConnectMySQL.getInstance();
	InternMapper mapper = InternMapper.getInstance();

	private PreparedStatement prepareStatement(String query) throws SQLException {
		Connection connection = connectMySQL.getConnection();
	    return connection.prepareStatement(query);
	}
	
    public Optional<Intern> selectIntern(int internId) throws QueryException {
	    try (PreparedStatement preparedStatement = prepareStatement(selectInternQuery)) {
			preparedStatement.setInt(1, internId);
			return Optional.ofNullable(mapper.mapResultSetToIntern(preparedStatement.executeQuery()));
		} catch (SQLException e) {
			throw new QueryException();
		}
    }

    public List<Intern> selectInterns() {
		try (Connection connection = connectMySQL.getConnection()) {
			Statement statement = connection.createStatement();
			return mapper.mapResultSetToInterns(statement.executeQuery(selectInternsQuery));
		} catch (SQLException e) {
			return new ArrayList<Intern>();
		}
    }

    public List<Intern> selectInternsPage(int offset, int limit) throws QueryException {
		try (PreparedStatement preparedStatement = prepareStatement(selectInternsPageQuery)) {
			preparedStatement.setInt(1, offset);
			preparedStatement.setInt(2, limit);
			return mapper.mapResultSetToInterns(preparedStatement.executeQuery());
		} catch (SQLException e) {
			throw new QueryException();
		}
    }

    public boolean insertIntern(Intern internData) {
	    try (PreparedStatement preparedStatement = prepareStatement(insertInternQuery)) {
		    preparedStatement.setString(1, internData.getFirstName());
			preparedStatement.setString(2, internData.getLastName());
		    preparedStatement.setDate(3, Date.valueOf(internData.getArrival()));
		    preparedStatement.setDate(4, Date.valueOf(internData.getFormationOver()));
		    preparedStatement.setInt(5, internData.getPromotion().getId());
		    preparedStatement.executeUpdate();
		    return true;
		} catch (SQLException e) {
			return false;
		}
    }

    public boolean updateIntern(int internId, Intern internData) {
	    try (PreparedStatement preparedStatement = prepareStatement(updateInternQuery)) {
		    preparedStatement.setString(1, internData.getFirstName());
		    preparedStatement.setString(2, internData.getLastName());
		    preparedStatement.setDate(3, Date.valueOf(internData.getArrival()));
		    preparedStatement.setDate(4, Date.valueOf(internData.getFormationOver()));
			preparedStatement.setInt(5, internData.getPromotion().getId());
		    preparedStatement.setInt(6, internId);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			return false;
		}
    }
    
    public boolean deleteIntern(int internId) {
		try (PreparedStatement preparedStatement = prepareStatement(deleteInternQuery)) {
		    preparedStatement.setInt(1, internId);
		    preparedStatement.executeUpdate();
		    return true;
		} catch (SQLException e) {
			return false;
		}
    }
}
