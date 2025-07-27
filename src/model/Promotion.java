package model;

import java.util.Objects;

public class Promotion {

    private final int id;
	private final String name;
	
	public Promotion(PromotionBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
	}

	public static class PromotionBuilder {

	    private final int id;
		private final String name;
		
		public PromotionBuilder(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public Promotion build() {
			return new Promotion(this);
		}

	}

	@Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Promotion)) {
            return false;
        }
        Promotion promotion = (Promotion) o;
        return id == promotion.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
	@Override
	public String toString() {
		return "Promotion [id=" + id + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}
