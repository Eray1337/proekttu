package bg.tu_varna.sit.b1.f23621680;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private String facultyNumber;
    private String specialty;
    private int course;
    private String group;
    private String status;
    private double averageGrade;
    private Map<String, Double> enrolledCourses = new HashMap<>();

    public Student(String name, String facultyNumber, String specialty, int course, String group, String status) {
        this.name = name;
        this.facultyNumber = facultyNumber;
        this.specialty = specialty;
        this.course = course;
        this.group = group;
        this.status = status;
        this.averageGrade = 0.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public void enrollInCourse(String courseName) {
        enrolledCourses.putIfAbsent(courseName, null);
    }

    public void addGrade(String courseName, double grade) {
        if (enrolledCourses.containsKey(courseName)) {
            enrolledCourses.put(courseName, grade);
            updateAverageGrade();
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

    public Map<String, Double> getEnrolledCourses() {
        return enrolledCourses;
    }

}
