package com.example.todayinpalestine;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText name_et, password_et;
    private Button loginButton;
    private CheckBox rememberCheckBox;
    private UserPreferences userPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name_et = findViewById(R.id.name_et);
        password_et = findViewById(R.id.password_et);
        loginButton = findViewById(R.id.loginButton);
        rememberCheckBox = findViewById(R.id.remember);
        userPreferences = new UserPreferences(this);

        if (userPreferences.isRememberMe()) {
            name_et.setText(userPreferences.getUsername());
            password_et.setText(userPreferences.getPassword());
            rememberCheckBox.setChecked(true);
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = name_et.getText().toString();
                String password = password_et.getText().toString();

                if (validateCredentials(username, password)) {
                    if (rememberCheckBox.isChecked()) {
                        userPreferences.addUser(username, "", password, "");
                        userPreferences.setRememberMe(true);
                    } else {
                        userPreferences.clearCredentials();
                    }

                    startActivity(new Intent(LoginActivity.this, MainNews_Activity.class));
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Incorrect credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean validateCredentials(String username, String password) {
        String storedUsername = userPreferences.getUsername();
        String storedPassword = userPreferences.getPassword();

        if (username.equals(storedUsername) && password.equals(storedPassword)) {
            return true;
        } else {
            return false;
        }
    }

}
