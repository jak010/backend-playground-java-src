package chapter01;

import java.util.*;

class StoreV2 {
    private List<OrderV2> orders;
    private long retnalFee;

    public long calculateRevenue() {
        long revenue = 0;
        for (OrderV2 order : orders) {
            revenue += order.calculateRevenue();
        }
        return revenue;
    }

    public List<OrderV2> getOrders() {
        return orders;
    }

    public long getRetnalFee() {
        return retnalFee;
    }
}

class OrderV2 {

    private List<FoodV2> foods;

    private double transactionFeePerecent = -0.03;

    public List<FoodV2> getFoods() {
        return foods;
    }

    public double getTransactionFeePerecent() {
        return transactionFeePerecent;
    }

    public long calculateRevenue() {
        long revenue = 0;
        for (FoodV2 foodV2 : foods) {
            revenue += foodV2.calculateRevenue();
        }
        return revenue;
    }

    public long calculateProfit() {
        long income = 0;
        for (FoodV2 foodV2 : foods) {
            income += foodV2.calculateProfit();
        }
        return (long) (income - calculateRevenue() * transactionFeePerecent);
    }
}

class FoodV2 {
    public long getPrice() {
        return price;
    }

    private long price;

    public long getOriginCost() {
        return originCost;
    }

    private long originCost; // 원가

    public long calculateRevenue() {
        return price;
    }

    public long calculateProfit() {
        return price - originCost;
    }
}


class RestaurantChainV2 {
    private List<StoreV2> stores;

    // 매출을 계산하는 함수
    public long calculateRevenue() {
        long revenue = 0;
        for (StoreV2 store : stores) {
            revenue += store.calculateRevenue();
        }
        return revenue;
    }

    // 순이익을 계산하는 함수
    public long calculateProfit() {
        long income = 0;
        for (StoreV2 storeV2 : stores) {
            income += storeV2.calculateRevenue();
        }
        return income;
    }
}

public class Page23 {


}
