package nsu.kurgin.lab1;

import java.io.Serializable;

public class User implements Serializable {
    private String nameUser;
    private String surname;
    private String dateOfBirtheOfBirth;
    private String password;

    public User(String nameUser, String surname, String dateOfBirtheOfBirth, String password) {
        this.nameUser = nameUser;
        this.surname = surname;
        this.dateOfBirtheOfBirth = dateOfBirtheOfBirth;
        this.password = password;
    }

    public String getNameUser() {
        return nameUser;
    }

    public String getSurname() {
        return surname;
    }

    public String getDateOfBirtheOfBirth() {
        return dateOfBirtheOfBirth;
    }

    public String getPassword() {
        return password;
    }

}
