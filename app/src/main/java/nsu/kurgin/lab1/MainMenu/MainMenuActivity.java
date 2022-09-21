package nsu.kurgin.lab1.MainMenu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import nsu.kurgin.lab1.R;
import nsu.kurgin.lab1.User;

public class MainMenuActivity extends AppCompatActivity {
    private User user;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getIntent().getExtras();

        if (arguments != null) {
            user = (User) arguments.getSerializable(User.class.getSimpleName());
            createDialog();
        } else {
            Log.e("criticalError", "argument is null");
            finish();
        }

        setContentView(R.layout.activity_main_menu);
    }


    public void clickInButtonHello(View view) {
        dialog.show();
    }

    public void createDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Hello, " + user.getNameUser());
        builder.setCancelable(true);
        builder.setPositiveButton("Ok!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog = builder.create();
    }
}