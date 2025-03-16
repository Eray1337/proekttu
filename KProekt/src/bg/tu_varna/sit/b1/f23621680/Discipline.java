package bg.tu_varna.sit.b1.f23621680;

public class Discipline {
    private String name;
    private boolean isMandatory;

    public Discipline(String name, boolean isMandatory) {
        this.name = name;
        this.isMandatory = isMandatory;
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
}