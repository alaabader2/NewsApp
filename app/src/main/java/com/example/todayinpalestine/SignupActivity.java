package com.example.todayinpalestine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    private EditText name_et, email_et, password_et, password2_et;
    private Button signupButton;
    private UserPreferences userPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name_et = findViewById(R.id.name_et);
        email_et = findViewById(R.id.email_et);
        password_et = findViewById(R.id.password_et);
        password2_et = findViewById(R.id.password2_et);
        signupButton = findViewById(R.id.signupButton);
        userPreferences = new UserPreferences(this);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = name_et.getText().toString();
                String email = email_et.getText().toString();
                String password = password_et.getText().toString();
                String confirmPassword = password2_et.getText().toString();

                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(email) ||
                        TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)) {
                    Toast.makeText(SignupActivity.this, "Please fill all required fields.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    Toast.makeText(SignupActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                userPreferences.addUser(username, email, password, confirmPassword);

                startActivity(new Intent(SignupActivity.this, MainNews_Activity.class));

            }
        });

    }
}