package model;

import java.util.Objects;

public class Chapter {

	private final int id;
	private final String name;
	private final String parentPath;
	
	public Chapter(ChapterBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.parentPath = builder.parentPath;
	}

	public static class ChapterBuilder {

		private final int id;
		private final String name;
		private final String parentPath;

		public ChapterBuilder(int id, String name, String parentPath) {
			this.id = id;
			this.name = name;
			this.parentPath = parentPath;
		}

		public Chapter build() {
			return new Chapter(this);
		}

	}

	@Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Chapter)) {
            return false;
        }
        Chapter chapter = (Chapter) o;
        return id == chapter.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
	@Override
	public String toString() {
		return "Chapter [id=" + id + ", name=" + name + ", parentPath=" + parentPath + "]";
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getParentPath() {
		return parentPath;
	}
}
