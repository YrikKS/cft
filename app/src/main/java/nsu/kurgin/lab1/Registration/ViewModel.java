package nsu.kurgin.lab1.Registration;


import java.util.Objects;
import java.util.Observable;

import nsu.kurgin.lab1.Constants;
import nsu.kurgin.lab1.Registration.Model;
import nsu.kurgin.lab1.Registration.UpdateField;

public class ViewModel extends Observable {
    private Model model = new Model();

    public void createUser(String nameUser, String surname, String dateOfBirth, String password, String secondPassword) {
        if (model.isNameCorrect(nameUser) &&
                model.isSurnameCorrcet(surname) &&
                model.isDateOfBirthCorrect(dateOfBirth) &&
                model.isPasswordCorrect(password) &&
                model.isPasswordMatches(secondPassword, password)) {

            model.createUser(nameUser, surname, dateOfBirth, password);
        } else {
            setChanged();
            notifyObservers(new UpdateField(Constants.NOTHING_UPDATE, ""));
        }
    }

    public void checkPassword(String str) {
        if (Objects.equals(str, "")) {
            setChanged();
            notifyObservers(new UpdateField(Constants.NOTHING_UPDATE, ""));
            return;
        }

        if (model.isPasswordCorrect(str)) {
            setChanged();
            notifyObservers(new UpdateField(Constants.PASSWORD_FIELD_ERR, ""));
        } else {
            setChanged();
            notifyObservers(new UpdateField(Constants.PASSWORD_FIELD_ERR, "there must be 6 characters, 1 number, 1 special character, 1 uppercase and 1 lowcase"));
        }
    }

    public void checkName(String str) {
        if (Objects.equals(str, "")) {
            setChanged();
            notifyObservers(new UpdateField(Constants.NOTHING_UPDATE, ""));
            return;
        }

        if (model.isNameCorrect(str)) {
            setChanged();
            notifyObservers(new UpdateField(Constants.NAME_ERR, ""));
        } else {
            setChanged();
            notifyObservers(new UpdateField(Constants.NAME_ERR, "Incorrect length"));
        }
    }

    public void checkSurname(String str) {
        if (Objects.equals(str, "")) {
            setChanged();
            notifyObservers(new UpdateField(Constants.NOTHING_UPDATE, ""));
            return;
        }

        if (model.isSurnameCorrcet(str)) {
            setChanged();
            notifyObservers(new UpdateField(Constants.SURNAME_FIELD_ERR, ""));
        } else {
            setChanged();
            notifyObservers(new UpdateField(Constants.SURNAME_FIELD_ERR, "Incorrect length"));
        }
    }

    public void checkDateOfBirth(String str) {
        if (Objects.equals(str, "")) {
            setChanged();
            notifyObservers(new UpdateField(Constants.NOTHING_UPDATE, ""));
            return;
        }

        if (model.isDateOfBirthCorrect(str)) {
            setChanged();
            notifyObservers(new UpdateField(Constants.DATE_OF_BIRTH_FIELD_ERR, ""));
        } else {
            setChanged();
            notifyObservers(new UpdateField(Constants.DATE_OF_BIRTH_FIELD_ERR, "wrong date example: 31.12.1999"));
        }
    }

    public void checkSecondPassword(String password, String secondPassword) {
        if (Objects.equals(password, "") || Objects.equals(secondPassword, "")) {
            setChanged();
            notifyObservers(new UpdateField(Constants.NOTHING_UPDATE, ""));
            return;
        }

        if (model.isPasswordMatches(password, secondPassword)) {
            setChanged();
            notifyObservers(new UpdateField(Constants.SECOND_PASSWORD_FIELD_ERR, ""));
        } else {
            setChanged();
            notifyObservers(new UpdateField(Constants.SECOND_PASSWORD_FIELD_ERR, "Passwords don't match"));
        }
    }

    public boolean checkAll(String nameUser, String surnameUser, String dateOfBirth, String password, String secondPassword) {
        return model.isNameCorrect(nameUser) &&
                model.isSurnameCorrcet(surnameUser) &&
                model.isDateOfBirthCorrect(dateOfBirth) &&
                model.isPasswordCorrect(password) &&
                model.isPasswordMatches(secondPassword, password);
    }
}
