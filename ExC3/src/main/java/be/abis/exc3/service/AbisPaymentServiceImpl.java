package be.abis.exc3.service;

import be.abis.exc3.model.Person;

public class AbisPaymentServiceImpl implements PaymentService {

    @Override
    public void paySalary(Person person) {
        System.out.println("Paying " + person.calculateNetSalary() + " to " + person.getFirstName());
    }
}
