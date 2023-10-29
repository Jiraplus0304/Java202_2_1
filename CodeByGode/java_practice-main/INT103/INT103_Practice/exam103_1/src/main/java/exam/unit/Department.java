package exam.unit;

public class Department {

    private final int code;
    private String name;
    private School school;
    private String logging;

    public Department(int code, String name, School school) {
        this.code = code;
        this.name = name;
        this.school = school;
        this.logging = school.getCode() + ";";
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
        this.logging += school.getCode() + ";";
    }

    public String getLog() {
        return logging;
    }
}
