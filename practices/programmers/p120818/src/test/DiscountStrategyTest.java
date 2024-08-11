package test;


import org.junit.Assert;
import org.junit.jupiter.api.*;
import refactor2.discount_strategy.DiscountStrategy;
import refactor2.discount_strategy.impl.BronzeDiscountStrategy;
import refactor2.discount_strategy.impl.GoldDiscountStrategy;
import refactor2.discount_strategy.impl.SilverDiscountStrategy;

public class DiscountStrategyTest {

    @Test
    @DisplayName("Bronze 가격 할인에 대한 테스트")
    public void bronzeDiscountTest() {
        int price = 120_000;

        DiscountStrategy ds = new BronzeDiscountStrategy();

        Assert.assertEquals(114_000, ds.applyPolicy(price));
    }

    @Test
    @DisplayName("Silver 가격 할인에 대한 테스트")
    public void silverDiscountTest() {
        int price = 310_000;

        DiscountStrategy ds = new SilverDiscountStrategy();

        Assert.assertEquals(279_000, ds.applyPolicy(price));
    }

    @Test
    @DisplayName("Gold 가격 할인에 대한 테스트")
    public void goldeDiscountTest() {
        int price = 580_000;

        DiscountStrategy ds = new GoldDiscountStrategy();

        Assert.assertEquals(464_000, ds.applyPolicy(price));
    }

}
