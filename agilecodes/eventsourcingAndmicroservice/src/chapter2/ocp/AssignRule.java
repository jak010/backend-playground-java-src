package chapter2.ocp;

import chapter2.srp.Customer;

import java.util.Comparator;

/* XXX: Comparator  */
public interface AssignRule extends Comparator<Customer> {

    public boolean isStatisfied(Customer customer);

    public int compare(Customer before, Customer after);

}
