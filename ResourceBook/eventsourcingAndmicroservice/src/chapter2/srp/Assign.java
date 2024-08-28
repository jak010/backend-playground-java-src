package chapter2.srp;

import chapter2.example.Surveyor;

/**
 * 배정을 유비쿼터스 언어로 등록하고 Assign 클래스를 추가한다.
 */
public class Assign {
    public Assign(Customer customer, Surveyor surveyor) {
        this.customer = customer;
        this.surveyor = surveyor;
    }

    private Customer customer;
    private Surveyor surveyor;

}
