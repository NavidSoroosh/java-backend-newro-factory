package ui;

import java.util.List;

import exception.QueryException;
import model.Intern;
import persistence.InternPersistence;

public class InternPage extends Page<Intern> {

	private InternPersistence internPersistence;

    {
		internPersistence = InternPersistence.getInstance();
    }
    
	public InternPage(int offset, int limit) throws QueryException {
		super(offset, limit);
		pageData = internPersistence.selectInternsPage(offset, limit);
	}

	public List<Intern> getPageData() {
		return pageData;
	}

}
