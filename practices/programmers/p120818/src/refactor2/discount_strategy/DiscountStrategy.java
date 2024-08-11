package refactor2.discount_strategy;

public interface DiscountStrategy {


    int applyPolicy(int price);

    boolean isApplyDiscountRate(int price);

}
