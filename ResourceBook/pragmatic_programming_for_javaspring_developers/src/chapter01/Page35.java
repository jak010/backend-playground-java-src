package chapter01;


interface Product {
    long getPrice();
}

interface Account {
    long getMoney();

    void setMoney(long l);

    boolean canAfford(long price);

    void withdraw(long price);
}

// TDA를 따르지 않는 코드, Page35

class Shop {

    public void sell(Account account, Product product) {
        long price = product.getPrice();
        long mileage = account.getMoney();

        if (mileage >= price) {
            account.setMoney(mileage - price);
        } else {
            System.out.println("잔액이 부족");
        }
    }
}


public class Page35 {
}
