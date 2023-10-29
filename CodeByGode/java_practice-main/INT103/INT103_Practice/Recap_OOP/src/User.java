public class User {
    private String username;
    private UserStatus status;

    public User(String username, UserStatus status) {
        this.username = username;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public UserStatus getStatus() {
        return status;
    }
}

class Test{
    public static void main(String[] args) {
        User u1 = new User("U1",UserStatus.ACTIVE);
        User u2 = new User("U2",UserStatus.INACTIVE);
        User u3 = new User("U3",UserStatus.valueOf("ACTIVE"));

        System.out.println(UserStatus.valueOf("BLOCKED"));

        System.out.println(u1.getStatus().equals(UserStatus.ACTIVE) ? u1.getUsername() : "");
        System.out.println(u2.getStatus().equals(UserStatus.ACTIVE) ? u2.getUsername() : "");
        System.out.println(u3.getStatus().equals(UserStatus.ACTIVE) ? u3.getUsername() : "");
    }
}
