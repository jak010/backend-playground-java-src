package chapter2.ocp;

import chapter2.srp.Customer;

public class AgeFilter implements Filter {


    private int minAge;
    private int maxAge;

    public AgeFilter(int minAge, int maxAge) {
        this.minAge = minAge;
        this.maxAge = maxAge;
    }


    @Override
    public boolean isStatisFied(Customer customer) {
        if (this.minAge <= customer.getBirthday().getAge() && customer.getBirthday().getAge() <= this.maxAge) {
            return true;
        }
        return false;
    }
}
