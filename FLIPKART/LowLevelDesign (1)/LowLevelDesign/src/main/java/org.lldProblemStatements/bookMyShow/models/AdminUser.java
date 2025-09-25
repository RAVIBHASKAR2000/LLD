package main.java.org.lldProblemStatements.bookMyShow.models;

public class AdminUser extends User {
    private final boolean isAdmin;

    public AdminUser(String username) {
        super(username);
        this.isAdmin = true;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
