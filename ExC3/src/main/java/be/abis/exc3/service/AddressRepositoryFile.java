package be.abis.exc3.service;

import be.abis.exc3.model.Address;
import java.io.IOException;
import java.nio.file.Path;

public class AddressRepositoryFile implements AddressRepository {

    @Override
    public void saveAddress(Address address, Path pathToFile) throws IOException {
        address.writeAddressToFile(pathToFile);
    }
}
