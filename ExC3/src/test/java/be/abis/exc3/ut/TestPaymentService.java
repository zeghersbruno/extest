package be.abis.exc3.ut;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import be.abis.exc3.exception.SalaryTooLowException;
import be.abis.exc3.model.Person;
import be.abis.exc3.service.AbisPaymentServiceImpl;
import be.abis.exc3.service.PaymentService;
import be.abis.exc3.validator.ValidatePerson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.junit.Assert.assertThat;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestPaymentService {

    PaymentService paymentService;

    ValidatePerson validatePerson;

    @Mock
    private Person person;

    @Before
    public void setUp() {
        paymentService = new AbisPaymentServiceImpl();
    }

    @Test()
    public void calculateSalaryWithMockMethodCalculateNetSalary() {
        // Arrange
        when(person.calculateNetSalary()).thenReturn(1600.0);

        //Act
        paymentService.paySalary(person);

        // Assert
        verify(person, times(1)).calculateNetSalary();
    }

    @Test(expected = SalaryTooLowException.class)
    public void throwASalarayTooLowExceptionWithMockMethodCalculateNetSalary() throws SalaryTooLowException {
        // Arrange
        when(person.calculateNetSalary()).thenReturn(1400.0);

        validatePerson = new ValidatePerson();

        //Act
        validatePerson.validateNetSalary(person.calculateNetSalary());

        // Assert
        // SalaryTooLowException
    }


}
