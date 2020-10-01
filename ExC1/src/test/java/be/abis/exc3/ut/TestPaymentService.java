package be.abis.exc3.ut;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import be.abis.exa1.exception.SalaryTooLowException;
import be.abis.exa1.model.Address;
import be.abis.exa1.model.Company;
import be.abis.exa1.model.Person;
import be.abis.exa1.service.PaymentService;
import be.abis.exa1.validator.ValidatePerson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestPaymentService {

    @Spy
    PaymentService paymentService;

    ValidatePerson validatePerson;

    @Mock
    private Person person;

    @Mock
    private Company company;

    @Mock
    private Address address;

    @Before
    public void setUp() {
    }


    @Test(expected = SalaryTooLowException.class)
    public void throwASalarayTooLowExceptionWithMockMethodCalculateNetSalary() throws SalaryTooLowException {
        // Arrange
        when(person.calculateNetSalary()).thenReturn(1400.0);
        validatePerson = new ValidatePerson();

        //Act
        paymentService.paySalary(person);
        validatePerson.validateNetSalary(person.calculateNetSalary());

        // Assert

    }


}
