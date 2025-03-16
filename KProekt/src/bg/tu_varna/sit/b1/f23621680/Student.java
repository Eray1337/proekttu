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

}
