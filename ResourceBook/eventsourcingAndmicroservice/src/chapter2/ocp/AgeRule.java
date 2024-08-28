package chapter2.ocp;

import chapter2.srp.Customer;

public class AgeRule implements AssignRule {

    private int minAge;
    private int maxAge;

    public AgeRule(int minAge, int maxAge) {
        this.minAge = minAge;
        this.maxAge = maxAge;
    }


    @Override
    public boolean isStatisfied(Customer customer) {
        if (this.minAge <= customer.getBirthday().getAge() && customer.getBirthday().getAge() <= this.maxAge) {
            return true;
        }
        return false;
    }

    @Override
    public int compare(Customer before, Customer after) {
        return before.getBirthday().getAge().compareTo(after.getBirthday().getAge());
    }


}
