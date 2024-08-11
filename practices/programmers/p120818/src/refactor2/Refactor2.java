package refactor2;

import refactor2.discount_strategy.DiscountStrategy;

import java.util.ArrayList;
import java.util.List;

public class Refactor2 {

    public int calulateDiscountPrice(int price) {
        List<DiscountStrategy> discountPolicies = new ArrayList<>();

        for (DiscountStrategy e : discountPolicies) {
            int discount_amount = e.applyPolicy(price);
            if (price != discount_amount) {
                return discount_amount;
            }
        }
        return price;
    }
}
