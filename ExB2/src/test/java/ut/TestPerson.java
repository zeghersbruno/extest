package ut;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


import exb2.exception.PersonShouldBeAdultException;
import exb2.model.Person;
import exb2.validator.ValidatePersonAge;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class TestPerson {

    Person p1;
    Person p2;
    ValidatePersonAge validator;

    @Before
        public void setUp() {
        p1 = new Person(1,"Ann","Smits", LocalDate.of(1985, 6, 28),null);
        p2 = new Person(2,"Neil","Yuong", LocalDate.of(2004, 6, 28),null);
    }


    @Test
    public void ageOfPersonFromBirthdayShouldBe35() {
        // Arrange
        // look at @Before

        //Act
        int age = p1.calculateAge();

        // Assert
        assertEquals("age is not what I expect", 35, age);
    }

    @Test
    public void ageOfPersonFromBirthdayShouldBe35WithHamcrest() {
        // Arrange
        Integer expected = 35;

        //Act
        int age = p1.calculateAge();

        // Assert
        assertThat(age, is(equalTo(expected)));
    }

    @Test
    public void toStringSentenceShouldStartsWithPerson() {
        // Arrange
        String expected = "Person";

        //Act
        String result = p1.toString();

        // Assert
        assertThat(result, startsWith(expected));
    }

    @Test(expected = PersonShouldBeAdultException.class)
    public void PersonShouldBeAdultException() throws PersonShouldBeAdultException {
        // Arrange
        validator = new ValidatePersonAge();

        //Act
        int age = p2.calculateAge();
        validator.validateAge(age);

        // Assert

    }

}
