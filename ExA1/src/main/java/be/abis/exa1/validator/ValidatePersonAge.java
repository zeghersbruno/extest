package be.abis.exa1.validator;

import be.abis.exa1.exception.PersonShouldBeAdultException;

public class ValidatePersonAge {

    public void validateAge(int age) throws PersonShouldBeAdultException {
        if (age < 18) {
            throw new PersonShouldBeAdultException("%d is too young guy !");
        }
    }
}
