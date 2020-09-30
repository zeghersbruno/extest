package be.abis.exa1.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FilesUtilities {
    /** writes the content of a list of strings to a file
     *
     * @param content the list of strings
     * @param fileName the name of the output file
     */
    public static void writeToFile(List<String> content, String fileName) throws IOException {
        Path pathToFile= Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(pathToFile)){
            for(String line: content) {
                writer.write(line);
            }
            System.out.println("Content written to " + pathToFile  );
        } catch (IOException e) {
            System.out.println("Could not write file to " + pathToFile);
            throw new IOException("Could not write file to " + pathToFile);
        }
    }

    /** writes the content of a list of strings to a file
     *
     * @param content the list of strings
     * @param fileName the name of the output file
     */
    public static void appendToFile(List<String> content, String fileName) throws IOException {
        Path pathToFile= Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(pathToFile, StandardOpenOption.APPEND)){
            for(String line: content) {
                writer.write(line);
            }
            System.out.println("Content append to " + pathToFile  );
        } catch (IOException e) {
            System.out.println("Could not write file to " + pathToFile);
            throw new IOException("Could not write file to " + pathToFile);
        }
    }

    /** reads the list of strings from a file and put it into content
     *
     * @param fileName input file
     * @return list of strings
     */
    public static List<String> readFromFile(String fileName) {
        List<String> content = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(pathToFile)) {
            while (reader.ready()) {
                content.add(reader.readLine());

            }
            System.out.println("Content read from " + pathToFile + ":\n");
            for (String line : content) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Could not write file to " + pathToFile);
            e.printStackTrace();
        }
        return content;
    }
}
