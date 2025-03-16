package bg.tu_varna.sit.b1.f23621680;

public class GradeRecord {
    private String facultyNumber;
    private String discipline;
    private double grade;

    public GradeRecord(String facultyNumber, String discipline, double grade) {
        this.facultyNumber = facultyNumber;
        this.discipline = discipline;
        this.grade = grade;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}