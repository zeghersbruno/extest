package ut;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


import exb2.exception.PersonShouldBeAdultException;
import exb2.model.Person;
import exb2.validator.ValidatePersonAge;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TestPerson {

    Person p1;
    Person p2;
    ValidatePersonAge validator;

    @BeforeEach
        public void setUp() {
        p1 = new Person(1,"Ann","Smits", LocalDate.of(1985, 6, 28),null);
        p2 = new Person(2,"Neil","Yuong", LocalDate.of(2004, 6, 28),null);
    }


    @Tag("ageTests")
    @Test
    @DisplayName("l'âge de la personne testée doit être 35 ans")
    public void ageOfPersonFromBirthdayShouldBe35() {
        // Arrange
        // look at @Before

        //Act
        int age = p1.calculateAge();

        // Assert
        assertEquals("age is not what I expect", 35, age);
    }

    @Tag("ageTests")
    @Test
    @DisplayName("L'âge de la personne doit être de 35 ans")
    public void ageOfPersonFromBirthdayShouldBe35WithHamcrest() {
        // Arrange
        Integer expected = 35;

        //Act
        int age = p1.calculateAge();

        // Assert
        assertThat(age, is(equalTo(expected)));
    }

    @Test
    @DisplayName("Eah Sentence should start with 'Person'")
    public void toStringSentenceShouldStartsWithPerson() {
        // Arrange
        String expected = "Person";

        //Act
        String result = p1.toString();

        // Assert
        assertThat(result, startsWith(expected));
    }

    @Tag("ageTests")
    @Test
    public void PersonShouldBeAdultException() {
        // Arrange
        validator = new ValidatePersonAge();

        //Act
        int age = p2.calculateAge();

        // Assert
        assertThrows(PersonShouldBeAdultException.class, () -> {
            validator.validateAge(age);
        });
    }

}
