package be.abis.exc1.validator;

import be.abis.exc1.exception.PersonShouldBeAdultException;
import be.abis.exc1.exception.SalaryTooLowException;

public class ValidatePerson {

    public void validateAge(int age) throws PersonShouldBeAdultException {
        if (age < 18) {
            throw new PersonShouldBeAdultException("%d is too young guy !");
        }
    }

    public void validateNetSalary(double netSalary) throws SalaryTooLowException {
        if (netSalary < 1500) {
            throw  new SalaryTooLowException("%d is too low boss !");
        }
    }
}
