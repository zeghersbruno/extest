package exb2.validator;


import exb2.exception.PersonShouldBeAdultException;

public class ValidatePersonAge {

    public void validateAge(int age) throws PersonShouldBeAdultException {
        if (age < 18) {
            throw new PersonShouldBeAdultException("%d is too young guy !");
        }
    }
}
