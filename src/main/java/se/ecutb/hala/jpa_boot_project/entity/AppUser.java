package se.ecutb.hala.jpa_boot_project.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
@Entity
@Table(name = "appUsers")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    @Column(length = 16, unique = true,name = "user_name")
    private String userName;
    @Column(length = 100, name = "first_name")
    private String firstName;
    @Column(length = 100, name = "last_name")
    private String lastName;
    @Column(length = 12, name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "active")
    private boolean active = true;
    @Column(length = 12, name = "password")
    private String password;

    public AppUser(String userName, String firstName, String lastName, LocalDate birthDate, String password) {
        setUserName(userName);
        setFirstName(firstName);
        setLastName(lastName);
        setBirthDate(birthDate);
        setPassword(password);
    }

    public AppUser() {
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isActive() {
        return active;
    }

    public void toggleActive(boolean active) {
        this.active = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return userId == appUser.userId &&
                active == appUser.active &&
                Objects.equals(userName, appUser.userName) &&
                Objects.equals(firstName, appUser.firstName) &&
                Objects.equals(lastName, appUser.lastName) &&
                Objects.equals(birthDate, appUser.birthDate) &&
                Objects.equals(password, appUser.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, firstName, lastName, birthDate, active, password);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AppUser{");
        sb.append("userId=").append(userId);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", birthDate=").append(birthDate);
        sb.append(", active=").append(active);
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
