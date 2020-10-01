package be.abis.exa1.service;

import be.abis.exa1.model.Person;

public class AbisPaymentServiceImpl implements PaymentService {

    @Override
    public void paySalary(Person person) {
        System.out.println("Paying " + person.calculateNetSalary() + " to " + person.getFirstName());
    }
}
