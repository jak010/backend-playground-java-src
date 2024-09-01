package chapter01;

import java.util.List;

class Store {
    private List<Order> orders;

    public long getRetnalFee() {
        return retnalFee;
    }

    private long retnalFee;

    public List<Order> getOrders() {
        return orders;
    }
}

class Order {
    public List<Food> getFoods() {
        return foods;
    }

    private List<Food> foods;

    public double getTransactionFeePerecent() {
        return transactionFeePerecent;
    }

    private double transactionFeePerecent = -0.03;


}

class Food {
    public long getPrice() {
        return price;
    }

    private long price;

    public long getOriginCost() {
        return originCost;
    }

    private long originCost; // 원가
}


class RestaurantChain {
    private List<Store> stores;

    // 매출을 계산하는 함수
    public long calculateRevenue() {
        long revenue = 0;
        for (Store store : stores) {
            for (Order order : store.getOrders()) {
                for (Food food : order.getFoods()) {
                    revenue += food.getPrice();
                }
            }
        }
        return revenue;
    }

    // 순이익을 계산하는 함수
    public long calculateProfit() {
        long cost = 0;
        for (Store store : stores) {
            for (Order order : store.getOrders()) {
                long orderPrice = 0;
                for (Food food : order.getFoods()) {
                    orderPrice += food.getPrice();
                    cost += food.getOriginCost();
                }
                cost += orderPrice * order.getTransactionFeePerecent();
            }
            cost += store.getRetnalFee();
        }
        return calculateRevenue() - cost;
    }
}

public class Page19 {

    public static void main(String[] args) {

    }

}
