package bg.tu_varna.sit.b1.f23621680;

public class Course {
    private String name;
    private boolean isMandatory;
    private int year;

    public Course(String name, boolean isMandatory, int year) {
        this.name = name;
        this.isMandatory = isMandatory;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMandatory() {
        return isMandatory;
    }

    public void setMandatory(boolean mandatory) {
        isMandatory = mandatory;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}