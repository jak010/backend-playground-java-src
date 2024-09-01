package chapter01;

class ShopV2 {

    public void sell(Account account, Product product) {
        if (account.canAfford(product.getPrice())) {
            account.withdraw(product.getPrice());
        } else {
            System.out.println("잔액이 부족");
        }
    }
}

public class Page36 {
}
