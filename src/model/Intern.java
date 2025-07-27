package model;

import java.time.LocalDate;
import java.util.Objects;

public class Intern {

    private final int id;
	private final String firstName;
	private final String lastName;
	private final LocalDate arrival;
	private final LocalDate formationOver;
	private final Promotion promotion;
	
	public Intern(InternBuilder builder) {
		this.id = builder.id;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.arrival = builder.arrival;
		this.formationOver = builder.formationOver;
		this.promotion = builder.promotion;
	}

	public static class InternBuilder {

	    private int id;
		private final String firstName;
		private final String lastName;
		private final LocalDate arrival;
		private LocalDate formationOver;
		private final Promotion promotion;

		public InternBuilder(String firstName, String lastName, LocalDate arrival, Promotion promotion) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.arrival = arrival;
			this.promotion = promotion;
		}

		public InternBuilder setId(int id) {
			this.id = id;
			return this;
		}
		
		public InternBuilder setFormationOver(LocalDate formationOver) {
			this.formationOver = formationOver;
			return this;
		}
		
		public Intern build() {
			return new Intern(this);
		}

	}
	
	@Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Intern)) {
            return false;
        }
        Intern intern = (Intern) o;
        return id == intern.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
	@Override
	public String toString() {
		return "Intern [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", arrival=" + arrival
				+ ", formationOver=" + formationOver + ", promotion=" + promotion + "]";
	}

	public int getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public LocalDate getArrival() {
		return arrival;
	}
	
	public LocalDate getFormationOver() {
		return formationOver;
	}
	
	public Promotion getPromotion() {
		return promotion;
	}
}
