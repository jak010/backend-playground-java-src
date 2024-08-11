package refactor1;

import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/120818
 * 머쓱이네 옷가게는 10만 원 이상 사면 5%, 30만 원 이상 사면 10%, 50만 원 이상 사면 20%를 할인해줍니다.
 * 구매한 옷의 가격 price가 주어질 때, 지불해야 할 금액을 return 하도록 solution 함수를 완성해보세요.
 * <p>
 * 할인 정책 - DiscountPolicy
 * 할인율    - DiscountThreshold
 * 가격     - amount
 */


interface DiscountPolicy {


    int applyPolicy(int price);

    boolean isApplyDiscountRate(int price);

}

abstract class AbstractDiscountThresHold {
    Double discountRate = 0.0;
    int maxThreadHold = 0;
    int minThreadHold = 0;


}


class BronzeDiscountPolicy extends AbstractDiscountThresHold implements DiscountPolicy {

    public BronzeDiscountPolicy() {
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


class SilverDiscountPolicy extends AbstractDiscountThresHold implements DiscountPolicy {

    public SilverDiscountPolicy() {
        this.discountRate = 0.9;
        this.maxThreadHold = 500_000;
        this.minThreadHold = 300_000;
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

class GoldDiscountPolicy extends AbstractDiscountThresHold implements DiscountPolicy {

    public GoldDiscountPolicy() {
        this.discountRate = 0.8;
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
        return price >= this.minThreadHold;
    }
}


public class programmers120818Refactor {


    public static int solution(int price) {
        int discountAmount = 0;

        List<DiscountPolicy> policies = new ArrayList<>();
        policies.add(new GoldDiscountPolicy());
        policies.add(new SilverDiscountPolicy());
        policies.add(new BronzeDiscountPolicy());

        for (DiscountPolicy policy : policies) {
            discountAmount = policy.applyPolicy(price);
            if (price != discountAmount) {
                return discountAmount;
            }
        }
        return price;
    }

    public static void main(String[] args) {
        System.out.println(solution(150_000));
        System.out.println(solution(580_000));
    }
}
