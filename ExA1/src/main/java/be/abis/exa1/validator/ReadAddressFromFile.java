package be.abis.exa1.validator;

import be.abis.exa1.utilities.FilesUtilities;
import java.util.List;

public class ReadAddressFromFile {

    public List<String> readAddress() {
        String fileName = "C:\\Users\\bruno\\IdeaProjects\\JavaTest\\ExA1\\src\\main\\resources\\address.txt";
        return FilesUtilities.readFromFile(fileName);
    }
}
