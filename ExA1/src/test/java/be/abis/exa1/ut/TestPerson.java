package be.abis.exa1.ut;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import be.abis.exa1.model.Person;
import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

public class TestPerson {

    @Test
    public void ageOfPersonFromBirthdayShouldBe35() {
        // Arrange
        Person p1 = new Person(1,"Ann","Smits", LocalDate.of(1985, 6, 28),null);

        //Act
        int age = p1.calculateAge();

        // Assert
        assertEquals("age is not what I expect", 35, age);
    }

    @Test
    public void ageOfPersonFromBirthdayShouldBe35WithHamcrest() {
        // Arrange
        Person p1 = new Person(1,"Ann","Smits", LocalDate.of(1985, 6, 28),null);
        Integer expected = 35;

        //Act
        int age = p1.calculateAge();

        // Assert
        assertThat(age, is(equalTo(expected)));
    }

    @Test
    public void toStringSentenceShouldStartsWithPerson() {
        // Arrange
        Person p1 = new Person(1,"Ann","Smits", LocalDate.of(1985, 6, 28),null);
        String expected = "Person";

        //Act
        String result = p1.toString().substring(0, 6);

        // Assert
        assertThat(result, is(equalTo(expected)));
    }
}
