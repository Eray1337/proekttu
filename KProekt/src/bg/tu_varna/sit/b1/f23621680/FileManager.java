package bg.tu_varna.sit.b1.f23621680;

import java.io.*;
import java.util.*;

public class FileManager {

    private List<Student> students = new ArrayList<>();
    private String filePath="KProekt/file.txt";

    public void openFile(String fileName) {
        this.filePath = fileName;

        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("Грешка: Файлът не съществува.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
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
                } else {
                    System.out.println("Пропуснат ред, тъй като не съдържа точно 6 стойности: " + line);
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

    public void createStudent(String name, String facultyNumber, String specialty, int course, String group, String status) {
        Student newStudent = new Student(name, facultyNumber, specialty, course, group, status);
        students.add(newStudent);
        saveToFile();
    }
    public void enrollInCourse(String fn, String course) {
        Student student = findStudentByFacultyNumber(fn);
        if (student != null) {
            student.enrollInCourse(course);
            saveToFile();
            System.out.println("Студентът с факултетен номер " + fn + " е записан в дисциплината " + course);
        } else {
            System.out.println("Няма такъв студент.");
        }
    }

    public void addGrade(String fn, String course, double grade) {
        Student student = findStudentByFacultyNumber(fn);
        if (student != null) {
            student.addGrade(course, grade);
            saveToFile();
            System.out.println("Оценката " + grade + " е добавена за дисциплината " + course);
        } else {
            System.out.println("Няма такъв студент.");
        }
    }

    private Student findStudentByFacultyNumber(String fn) {
        for (Student student : students) {
            if (student.getFacultyNumber().equals(fn)) {
                return student;
            }
        }
        return null;
    }

    public void printProtocol(String course) {
        System.out.println("Протокол за дисциплина " + course + ":");
        for (Student student : students) {
            if (student.getEnrolledCourses().containsKey(course)) {
                double grade = student.getEnrolledCourses().get(course);
                System.out.println("Факултетен номер: " + student.getFacultyNumber() + ", " + course + ": " + (grade != 0 ? grade : "Не взето"));
            }
        }
    }

    public void printAcademicReport(String fn) {
        Student student = findStudentByFacultyNumber(fn);
        if (student != null) {
            System.out.println(student.getAcademicReport());
        } else {
            System.out.println("Няма такъв студент.");
        }
    }

    public List<Student> getStudents() {
        return students;
    }
}
