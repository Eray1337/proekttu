package bg.tu_varna.sit.b1.f23621680;

import java.io.*;
import java.util.*;

public class FileManager {

    private List<Student> students = new ArrayList<>();
    private String filePath;

    public FileManager(String filePath) {
    }

    public void openFile(String filePath)     {
        this.filePath = filePath;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String fn = parts[0];
                    String name = parts[1];
                    String program = parts[2];
                    String group = parts[3];
                    int year = Integer.parseInt(parts[4]);
                    String status = parts[5];
                    Student student = new Student(name, fn, program, year, group, status);
                    students.add(student);
                }
            }
            System.out.println("Файлът е отворен успешно и данните са заредени.");
        } catch (IOException e) {
            System.out.println("Грешка при отваряне на файла: " + e.getMessage());
        }
    }

    public void saveToFile() {
        if (filePath == null || filePath.isEmpty()) {
            System.out.println("Няма зададен път за файл.");
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Student student : students) {
                writer.write(student.getFacultyNumber() + ","
                        + student.getName() + ","
                        + student.getSpecialty() + ","
                        + student.getGroup() + ","
                        + student.getCourse() + ","
                        + student.getStatus());
                writer.newLine();
            }
            System.out.println("Данните са записани в файла: " + filePath);
        } catch (IOException e) {
            System.out.println("Грешка при записването на файла: " + e.getMessage());
        }
    }

    public void saveAs(String newFileName) {
        this.filePath = newFileName;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(newFileName))) {
            for (Student student : students) {
                writer.write(student.getFacultyNumber() + ","
                        + student.getName() + ","
                        + student.getSpecialty() + ","
                        + student.getGroup() + ","
                        + student.getCourse() + ","
                        + student.getStatus());
                writer.newLine();
            }
            System.out.println("Данните са записани в новия файл: " + newFileName);
        } catch (IOException e) {
            System.out.println("Грешка при записването на файла: " + e.getMessage());
        }
    }

}
