package be.abis.exc3.service;

import be.abis.exc3.model.Address;
import java.io.IOException;
import java.nio.file.Path;

public interface AddressRepository {
    public void saveAddress(Address address, Path pathToFile) throws IOException;
}
