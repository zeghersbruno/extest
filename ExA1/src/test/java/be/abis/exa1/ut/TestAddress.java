package be.abis.exa1.ut;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

import be.abis.exa1.model.Address;
import be.abis.exa1.validator.ReadAddressFromFile;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;
import org.hamcrest.core.Every;
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

    @Test
    public void AddressShouldBeAddedInAFile() throws IOException {
        // Arrange
        Address ad = new Address("champagneStreet", "25", "5000", "Namur", "Belgium","BE");
        ad.writeAddressToFile();
        ReadAddressFromFile readAddress = new ReadAddressFromFile();
        List<String> lsAddress = new ArrayList<>();
        String expected = "Address";

        // Act
        lsAddress = readAddress.readAddress();

        // Assert
        assertThat(lsAddress, Every.everyItem(startsWith(expected)));

    }

    // This test should be ignored as the file is write/read enabled
    @Test(expected = IOException.class)
    public void AddAddressShouldInAFileShouldGiveIOException() throws IOException {
        // Arrange
        Address ad = new Address("champagneStreet", "25", "5000", "Namur", "Belgium","BE");

        // Act
        ad.writeAddressToFile();

        // Assert

    }
}
