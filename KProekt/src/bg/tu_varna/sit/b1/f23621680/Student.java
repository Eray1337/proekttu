package bg.tu_varna.sit.b1.f23621680;

public class Student {
    private String name;
    private String facultyNumber;
    private String specialty;
    private int course;
    private String group;
    private String status;
    private double averageGrade;

    public Student(String name, String facultyNumber, String specialty, int course, String group, String status) {
        this.name = name;
        this.facultyNumber = facultyNumber;
        this.specialty = specialty;
        this.course = course;
        this.group = group;
        this.status = status;
        this.averageGrade = 0.0;
    }
}