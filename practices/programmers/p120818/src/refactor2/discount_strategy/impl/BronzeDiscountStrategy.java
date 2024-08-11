package refactor2.discount_strategy.impl;

import refactor2.discount_strategy.threadhold.DiscountThreadHold;
import refactor2.discount_strategy.DiscountStrategy;



public class BronzeDiscountStrategy extends DiscountThreadHold implements DiscountStrategy {

    BronzeDiscountStrategy() {
        this.discountRate = 0.95;
        this.maxThreadHold = 300_000;
        this.minThreadHold = 100_000;
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
