package refactor2.discount_strategy.impl;

import refactor2.discount_strategy.DiscountStrategy;
import refactor2.discount_strategy.threadhold.DiscountThreadHold;

public class GoldDiscountStrategy extends DiscountThreadHold implements DiscountStrategy {


    public GoldDiscountStrategy() {
        this.discountRate = 0.80;
        this.minThreadHold = 500_000;

    }

    @Override
    public int applyPolicy(int price) {
        if (isApplyDiscountRate(price)) {
            return (int) (price * this.discountRate);
        }
        return price;
    }

    @Override
    public boolean isApplyDiscountRate(int price) {
        return price > this.minThreadHold;
    }

}
