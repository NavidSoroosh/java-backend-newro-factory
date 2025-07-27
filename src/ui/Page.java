package ui;

import java.util.List;

public abstract class Page<E> {
	
	protected List<E> pageData;
	protected int offset;
	protected int limit;
	
	public Page(int offset, int limit) {
		this.offset = offset;
		this.limit = limit;
	}

	public List<E> getPageData() {
		return pageData;
	}

}
