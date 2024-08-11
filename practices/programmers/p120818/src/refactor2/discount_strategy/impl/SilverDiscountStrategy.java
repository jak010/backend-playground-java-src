package refactor2.discount_strategy.impl;

import refactor2.discount_strategy.DiscountStrategy;
import refactor2.discount_strategy.threadhold.DiscountThreadHold;

public class SilverDiscountStrategy extends DiscountThreadHold implements DiscountStrategy {

    SilverDiscountStrategy() {
        this.discountRate = 0.90;
        this.minThreadHold = 300_000;
        this.maxThreadHold = 500_000;
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
        return (price >= this.minThreadHold) && (price < this.maxThreadHold);
    }

}
