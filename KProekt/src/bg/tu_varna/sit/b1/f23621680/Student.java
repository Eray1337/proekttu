package bg.tu_varna.sit.b1.f23621680;

import java.util.*;

public class Student {

    private String name;
    private String facultyNumber;
    private String specialty;
    private int course;
    private String group;
    private String status;
    private double averageGrade;
    private Map<String, Double> enrolledCourses;

    public Student(String name, String facultyNumber, String specialty, int course, String group, String status) {
        this.name = name;
        this.facultyNumber = facultyNumber;
        this.specialty = specialty;
        this.course = course;
        this.group = group;
        this.status = status;
        this.averageGrade = 0.0;
        this.enrolledCourses = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public String getSpecialty() {
        return specialty;
    }

    public int getCourse() {
        return course;
    }

    public String getGroup() {
        return group;
    }

    public String getStatus() {
        return status;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public Map<String, Double> getEnrolledCourses() {
        return enrolledCourses;
    }



    public void enrollInCourse(String courseName) {
        enrolledCourses.putIfAbsent(courseName, null);
    }

    public void addGrade(String courseName, double grade) {
        if (enrolledCourses.containsKey(courseName)) {
            enrolledCourses.put(courseName, grade);
            updateAverageGrade();
        } else {
            System.out.println("Студентът не е записан в дисциплината " + courseName);
        }
    }

    private void updateAverageGrade() {
        double sum = 0.0;
        int count = 0;
        for (Double grade : enrolledCourses.values()) {
            sum += (grade != null) ? grade : 2.0;
            count++;
        }
        this.averageGrade = count > 0 ? sum / count : 0.0;
    }

    @Override
    public String toString() {
        return "Студент " + name + " с факултетен номер " + facultyNumber +
                ", Специалност: " + specialty + ", Курс: " + course +
                ", Група: " + group + ", Статус: " + status +
                ", Среден успех: " + averageGrade;
    }

    public String getAcademicReport() {
        StringBuilder report = new StringBuilder("Академична справка за студент с факултетен номер " + facultyNumber + ":\n");
        report.append("Записани дисциплини и оценки:\n");

        for (String course : enrolledCourses.keySet()) {
            double grade = enrolledCourses.get(course);
            report.append(course + ": " + (grade != 0 ? grade : "Не взето") + "\n");
        }

        report.append("Среден успех: " + averageGrade + "\n");

        return report.toString();
    }
}
