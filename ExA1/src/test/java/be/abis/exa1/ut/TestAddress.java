package be.abis.exa1.ut;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

import be.abis.exa1.model.Address;
import be.abis.exa1.validator.ReadAddressFromFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.hamcrest.core.Every;
import org.junit.Assert;
import org.junit.Test;

public class TestAddress {

    private static String fileName = "C:\\Users\\bruno\\IdeaProjects\\JavaTest\\ExA1\\src\\main\\resources\\address.txt";
    private static Path pathToFile = Paths.get(fileName);

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
        File myFile = new File(pathToFile.toString());
        myFile.setWritable(true);
        List<String> lsAddress = new ArrayList<>();
        Address ad = new Address("champagneStreet", "25", "5000", "Namur", "Belgium","BE");
        lsAddress = ad.readAddressFromFile();
        int numberOfAddressesBefore = lsAddress.size();
        int expected = numberOfAddressesBefore + 1;

        // Act

        ad.writeAddressToFile();
        lsAddress = ad.readAddressFromFile();

        // Assert
        assertThat(lsAddress.size(), is(equalTo(expected)));

    }

    // This test should be ignored as the file is write/read enabled
    @Test(expected = IOException.class)
    public void AddAddressShouldInAFileShouldGiveIOException() throws IOException {
        // Arrange
        System.out.println(pathToFile.toString());
        File myFile = new File(pathToFile.toString());
        myFile.setReadOnly();
        Address ad = new Address("champagneStreet", "25", "5000", "Namur", "Belgium","BE");

        // Act
        ad.writeAddressToFile();
        myFile.setWritable(true);

        // Assert
        assertThat(myFile.canWrite(), is(true));
    }
}
