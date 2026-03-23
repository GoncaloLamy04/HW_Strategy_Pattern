package dk.hw_strategy_pattern.model;


// Repræsenterer de data brugeren sender ind via registreringsformularen
public class RegisterUserModel {

    private String username;
    private String email;
    private String password;

    // Getters og setters bruges af Thymeleaf til at læse og skrive data
    // når formularen bindes til dette objekt via @ModelAttribute
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
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

    // Skjuler password så det ikke vises i logs eller output
    @Override
    public String toString() {
        return "RegisterUserModel{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='[hidden]'" +
                '}';
    }
}