package be.abis.exc1.ut;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import be.abis.exc1.model.Address;
import be.abis.exc1.model.Company;

import org.junit.Test;

public class TestCompany {

    @Test
    public void taxForBelgianCompanyShouldBe541() {
        // Arrange
        Address ad1 = new Address("BossStreet", "11", "1000", "Brussels", "Belgium", "BE");
        Company c1 = new Company("MyFirstCompany", ad1);

        // Act
        double d1 = c1.calculateTaxToPay();

        // Assert
        assertThat(51.0, is(equalTo(d1)));

    }
}
