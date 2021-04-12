package entities;

public class RegistrationForm {
    private String email;
    private String password;

    public RegistrationForm(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public RegistrationForm() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
