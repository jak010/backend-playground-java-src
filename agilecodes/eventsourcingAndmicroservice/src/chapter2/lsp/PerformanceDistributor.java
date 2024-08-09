package chapter2.lsp;

import chapter2.example.Surveyor;
import chapter2.srp.Assign;
import chapter2.srp.Customer;

import java.util.List;

public class PerformanceDistributor implements Distributable {

    @Override
    public List<Assign> distribute(List<Customer> customers, List<Surveyor> surveyors) {
        return null;
    }
}
