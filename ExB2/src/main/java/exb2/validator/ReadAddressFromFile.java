package exb2.validator;


import exb2.utilities.FilesUtilities;
import java.io.IOException;
import java.util.List;

public class ReadAddressFromFile {

    private static String fileName = "C:\\Users\\bruno\\IdeaProjects\\JavaTest\\ExA1\\src\\main\\resources\\address.txt";

    public List<String> readAddress() {
        return FilesUtilities.readFromFile(fileName);
    }

    public void WriteAddressToFile(List<String> lsStr) throws IOException {
        FilesUtilities.writeToFile(lsStr, fileName);
    }
}
