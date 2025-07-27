package service;

import java.util.List;
import java.util.Optional;

import exception.QueryException;
import model.Intern;
import persistence.InternPersistence;

public class InternService {

	private static final InternService INSTANCE = new InternService();

    private InternService() {
    }

    public static InternService getInstance() {
        return INSTANCE;
    }

	InternPersistence internPersistence = InternPersistence.getInstance();

	
	public Optional<Intern> selectIntern(int internId) throws QueryException {
		return this.internPersistence.selectIntern(internId);
	}

	public List<Intern> selectInterns() {
		return this.internPersistence.selectInterns();
	}
	
	public List<Intern> selectInternsPage(int offset, int limit) throws QueryException {
		return this.internPersistence.selectInternsPage(offset, limit);
	}
	
	public boolean insertIntern(Intern internData) {
		return this.internPersistence.insertIntern(internData);
	}
	
	public boolean updateIntern(int id, Intern internData) {
		return this.internPersistence.updateIntern(id, internData);
	}
	
	public boolean deleteIntern(int id) {
		return this.internPersistence.deleteIntern(id);
	}

}
