package ut;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import exb2.exception.PersonShouldBeAdultException;
import exb2.model.Address;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;


public class TestAddress {

    private static String fileName = "C:\\Users\\bruno\\IdeaProjects\\JavaTest\\ExA1\\src\\main\\resources\\address.txt";
    private static Path pathToFile = Paths.get(fileName);

    @Test
    public void belgianZipCodeShouldBeNumeric() {
        // Arrange
        Address ad = new Address("champagneStreet", "25", "5000", "Namur", "Belgium","BE");

        // Act
        boolean isAZipCode = ad.checkBelgianZipCode();

        // Assert
       assertThat(isAZipCode, is(true));

    }

    @Test
    public void addressShouldBeAddedInAFile() throws IOException {
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

    @Test
    public void addAddressShouldInAFileShouldGiveIOException() {
        // Arrange
        System.out.println(pathToFile.toString());
        File myFile = new File(pathToFile.toString());
        myFile.setReadOnly();
        Address ad = new Address("champagneStreet", "25", "5000", "Namur", "Belgium","BE");

        // Act


        // Assert
        assertThrows(IOException.class, () -> {
            ad.writeAddressToFile();
        });
        assertThat(myFile.canWrite(), is(true));
    }
}
