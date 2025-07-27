package service;

import java.util.List;

import model.Promotion;
import persistence.PromotionPersistence;

public class PromotionService {

	private static final PromotionService INSTANCE = new PromotionService();

    private PromotionService() {
    }

    public static PromotionService getInstance() {
        return INSTANCE;
    }

    PromotionPersistence internPersistence = PromotionPersistence.getInstance();

	public List<Promotion> selectPromotions() {
		return this.internPersistence.selectPromotions();
	}

}
