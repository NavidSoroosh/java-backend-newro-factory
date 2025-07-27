package model;

import java.util.Objects;

public class Answer {
	
    private final int id;
	private final String label;
	private final String text;
	private final int validAnswer;
	private final Question question;

	private Answer(AnswerBuilder builder) {
		this.id = builder.id;
		this.label = builder.label;
		this.text = builder.text;
		this.validAnswer = builder.validAnswer;
		this.question = builder.question;
	}
	
	public static class AnswerBuilder {

	    private final int id;
		private final String label;
		private final String text;
		private final int validAnswer;
		private final Question question;

		public AnswerBuilder(int id, String label, String text, int validAnswer, Question question) {
			this.id = id;
			this.label = label;
			this.text = text;
			this.validAnswer = validAnswer;
			this.question = question;
		}

		public Answer build() {
			return new Answer(this);
		}

	}

	@Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Answer)) {
            return false;
        }
        Answer answer = (Answer) o;
        return id == answer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
	@Override
	public String toString() {
		return "Answer [id=" + id + ", label=" + label + ", text=" + text + ", validAnswer=" + validAnswer
				+ ", questionId=" + question + "]";
	}

	public int getId() {
		return id;
	}
	
	public String getLabel() {
		return label;
	}
	
	public String getText() {
		return text;
	}
	
	public int getValidAnswer() {
		return validAnswer;
	}
	
	public Question getQuestion() {
		return question;
	}
	
}
