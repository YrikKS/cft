package nsu.kurgin.lab1.Registration;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nsu.kurgin.lab1.Constants;
import nsu.kurgin.lab1.User;

public class Model {
    private User user;

    public void createUser(String nameUser, String surname, String dateOfBirth, String password) {
        user = new User(nameUser, surname, dateOfBirth, password);
    }


    public boolean isNameCorrect(String nameUser) {
        if (nameUser.length() < 2) {
            return false;
        } else if (nameUser.length() > 22) {
            return false;
        } else
            return true;
    }

    public boolean isSurnameCorrcet(String surnameUser) {
        if (surnameUser.length() < 2) {
            return false;
        } else if (surnameUser.length() > 22) {
            return false;
        } else
            return true;
    }

    public boolean isDateOfBirthCorrect(String dateOfBirth) {
        return true;
    }

    public boolean isPasswordCorrect(String password) {
        Pattern pattern = Pattern.compile(Constants.REGEX_FOR_PASSWORD);
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    public boolean isPasswordMatches(String password, String passwordRepeat) {
        return password.equals(passwordRepeat);
    }
}
