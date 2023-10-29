package exam.unit;

public class School {

    private final int code;
    private String name;
    private double balance;
    private String logging = "";

    public School(int code, String name) {
        this.code = code;
        this.name = name;
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

    public double getBalance() {
        return balance;
    }

    public void earn(double amount) {
        balance += amount;
        logging += "earn(" + amount + ")";
    }

    public void spend(double amount) {
        balance -= amount;
        logging += "spend(" + amount + ")";
    }

    public String getLog() {
        return logging;
    }
}
