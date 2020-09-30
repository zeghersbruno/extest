package be.abis.exa1.ut;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import be.abis.exa1.model.Address;
import org.junit.Assert;
import org.junit.Test;

public class TestAddress {

    @Test
    public void BelgianZipCodeShouldBeNumeric() {
        // Arrange
        Address ad = new Address("champagneStreet", "25", "5000", "Namur", "Belgium","BE");

        // Act
        boolean isAZipCode = ad.checkBelgianZipCode();

        // Assert
        assertTrue("Zip Code is not correct", isAZipCode);

    }
}
