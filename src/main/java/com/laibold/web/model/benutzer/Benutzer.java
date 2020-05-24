package com.laibold.web.model.benutzer;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Benutzer {

    @Id @GeneratedValue
    private long id;

    @Version
    private long version;

    @NotBlank()
    @Column(unique = true)
    private String username;

    @Size(min = 3)
    private String password;

    @NotBlank()
    private String fullName;

    private boolean acceptedTOS;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isAcceptedTOS() {
        return acceptedTOS;
    }

    public void setAcceptedTOS(boolean acceptedTOS) {
        this.acceptedTOS = acceptedTOS;
    }

    @Override
    public String toString() {
        return "Benutzer{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", acceptedTOS=" + acceptedTOS +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Benutzer benutzer = (Benutzer) o;
        return username.equals(benutzer.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
