package nsu.kurgin.lab1;

public class Constants {
    public static final String REGEX_FOR_DATE_OF_BIRTH = "([\\d]{2}.[\\d]{2}.[\\d]{4})";
    public static final String REGEX_FOR_PASSWORD = "(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-zа-яё])(?=.*[A-ZА-ЯЁ])[0-9a-zA-Z!@#$%^&*]{6,}";

    public static final String NAME_ERR = "NAME_ERR";
    public static final String SURNAME_FIELD_ERR = "SURNAME_ERR";
    public static final String PASSWORD_FIELD_ERR = "PASSWORD_ERR";
    public static final String DATE_OF_BIRTH_FIELD_ERR = "DATE_OF_BIRTH_ERR";
    public static final String SECOND_PASSWORD_FIELD_ERR = "SECOND_PASSWORD_ERR";
    public static final String CORRECT_FIELD_ERR = "SECOND_PASSWORD_ERR";
    public static final String NOTHING_UPDATE = "NOTHING_UPDATE";

    public static final String SUB_STRING_FOR_FIEND_NAME_VIEW = "app:id/";
}
