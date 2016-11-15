

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by manish_kumar9 on 10/02/16.
 */
public class Class {
    private static ArrayList<Student> studentList=new ArrayList<>();

    public static void loadStudents(String fileName) {

            Path pathToFile = Paths.get(fileName);
            // create an instance of BufferedReader // using try with resource, Java 7 feature to close resources
            try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
                // read the first line from the text file
                String line = br.readLine();
                // loop until all lines are read
                while (line != null) {
                    // use string.split to load a string array with the values from
                    // each line of // the file, using a comma as the delimiter
                    String[] attributes = line.split(",");
                    Student student = new Student(attributes[0],Integer.parseInt(attributes[1]),Integer.parseInt(attributes[2]));
                    // adding student into ArrayList
                    studentList.add(student);
                    // read next line before looping
                    // if end of file reached, line would be null
                    line = br.readLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


    }
}
