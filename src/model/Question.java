package model;

import java.util.Objects;

public class Question {

	private final int id;
	private final String title;
	private final String statement;
	private final Chapter chapter;
	
	public Question(QuestionBuilder builder) {
		this.id = builder.id;
		this.title = builder.title;
		this.statement = builder.statement;
		this.chapter = builder.chapter;
	}

	public static class QuestionBuilder {

		private final int id;
		private final String title;
		private final String statement;
		private final Chapter chapter;

		public QuestionBuilder(int id, String title, String statement, Chapter chapter) {
			this.id = id;
			this.title = title;
			this.statement = statement;
			this.chapter = chapter;
		}

		public Question build() {
			return new Question(this);
		}

		@Override
	    public boolean equals(Object o) {

	        if (o == this) return true;
	        if (!(o instanceof Question)) {
	            return false;
	        }
	        Question question = (Question) o;
	        return id == question.id;
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(id);
	    }
	    
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", title=" + title + ", statement=" + statement + ", chapterId=" + chapter
				+ "]";
	}

	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getStatement() {
		return statement;
	}
	
	public Chapter getChapter() {
		return chapter;
	}
}
