package nsu.kurgin.lab1.Registration;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import nsu.kurgin.lab1.Constants;
import nsu.kurgin.lab1.MainMenu.MainMenuActivity;
import nsu.kurgin.lab1.R;
import nsu.kurgin.lab1.Registration.UpdateField;
import nsu.kurgin.lab1.Registration.ViewModel;
import nsu.kurgin.lab1.User;


public class RegistrationActivity extends AppCompatActivity implements Observer {

    private final ViewModel viewModel = new ViewModel();
    private Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel.addObserver(this);
        setFocus();
    }

    public void clickInRegistration(View view) {
        if (viewModel.checkAll(((TextView) findViewById(R.id.nameText)).getText().toString(),
                ((TextView) findViewById(R.id.surnameText)).getText().toString(),
                ((TextView) findViewById(R.id.dateOfBirthText)).getText().toString(),
                ((TextView) findViewById(R.id.passwordText)).getText().toString(),
                ((TextView) findViewById(R.id.confirmPasswordText)).getText().toString())) {

            User user = new User(((TextView) findViewById(R.id.nameText)).getText().toString(),
                    ((TextView) findViewById(R.id.surnameText)).getText().toString(),
                    ((TextView) findViewById(R.id.dateOfBirthText)).getText().toString(),
                    ((TextView) findViewById(R.id.passwordText)).getText().toString());
            Intent intent = new Intent(this, MainMenuActivity.class);
            intent.putExtra(User.class.getSimpleName(), user);

            startActivity(intent);
        }
    }


    @Override
    public void update(Observable o, Object arg) {
        UpdateField updateField = (UpdateField) arg;
        switch (updateField.getTypeChange()) {
            case (Constants.NAME_ERR):
                ((TextView) findViewById(R.id.nameErr)).setText(updateField.getMsg());
                break;
            case (Constants.SURNAME_FIELD_ERR):
                ((TextView) findViewById(R.id.surnameErr)).setText(updateField.getMsg());
                break;
            case (Constants.DATE_OF_BIRTH_FIELD_ERR):
                ((TextView) findViewById(R.id.dateOfBirthErr)).setText(updateField.getMsg());
                break;
            case (Constants.PASSWORD_FIELD_ERR):
                ((TextView) findViewById(R.id.passwordErr)).setText(updateField.getMsg());
                break;
            case (Constants.CORRECT_FIELD_ERR):
                ((TextView) findViewById(R.id.confirmPasswordErr)).setText(updateField.getMsg());
                break;
        }
    }

    public void setFocus() {
        ((TextView) findViewById(R.id.nameText)).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    viewModel.checkName(((TextView) findViewById(R.id.nameText)).getText().toString());
                }
            }
        });

        ((TextView) findViewById(R.id.surnameText)).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    viewModel.checkSurname((((TextView) findViewById(R.id.surnameText)).getText().toString()));
                }
            }
        });

        ((TextView) findViewById(R.id.dateOfBirthText)).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    viewModel.checkDateOfBirth(((TextView) findViewById(R.id.dateOfBirthText)).getText().toString());
                }
            }
        });

        ((TextView) findViewById(R.id.passwordText)).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    viewModel.checkPassword(((TextView) findViewById(R.id.passwordText)).getText().toString());
                }
            }
        });

        ((TextView) findViewById(R.id.confirmPasswordText)).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    viewModel.checkSecondPassword(((TextView) findViewById(R.id.confirmPasswordText)).getText().toString(),
                            ((TextView) findViewById(R.id.passwordText)).getText().toString());
                }
            }
        });

    }

    DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, monthOfYear);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setInitialDateTime();
        }
    };

    private void setInitialDateTime() {
        ((TextView) findViewById(R.id.dateOfBirthText)).setText(DateUtils.formatDateTime(this,
                calendar.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR));
    }

    public void clickInDate(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();

    }
}