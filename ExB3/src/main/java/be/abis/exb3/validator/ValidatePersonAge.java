package be.abis.exb3.validator;

import be.abis.exb3.exception.PersonShouldBeAdultException;

public class ValidatePersonAge {

    public void validateAge(int age) throws PersonShouldBeAdultException {
        if (age < 18) {
            throw new PersonShouldBeAdultException("%d is too young guy !");
        }
    }
}
