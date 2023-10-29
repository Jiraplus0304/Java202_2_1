package dev.bestzige.int202employeerecruitmentsystem.utils;

import dev.bestzige.int202employeerecruitmentsystem.models.*;

import java.util.*;
import java.io.*;

public class FileUtil {
    private static final String APP_FILE_PATH = "applications.txt";

    public static List<Application> loadDataApplications() {
        List<Application> applications = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FileUtil.class.getClassLoader().getResource(APP_FILE_PATH).getFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                Application app = new Application(parts[0], parts[1], parts[2], JobPosition.valueOf(parts[3]));
                applications.add(app);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return applications;
    }

    public static void saveDataApplications(List<Application> applications) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FileUtil.class.getClassLoader().getResource(APP_FILE_PATH).getFile()))) {
            for (Application app : applications) {
                bw.write(app.getFirstName() + "," + app.getLastName() + "," + app.getEmail() + "," + app.getJobPosition());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
