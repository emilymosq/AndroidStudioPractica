package com.emilymosq.first;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextInputLayout registerUsernameTIL = findViewById(R.id.registerUsernameTIL);
        TextInputLayout registerPasswordTIL = findViewById(R.id.registerPasswordTIL);
        TextInputLayout registerConfirmPasswordTIL = findViewById(R.id.registerConfirmPasswordTIL);
        Button registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = String.valueOf(registerUsernameTIL.getEditText().getText());
                String password = String.valueOf(registerPasswordTIL.getEditText().getText());
                String userPasswordCheck = String.valueOf(registerConfirmPasswordTIL.getEditText().getText());

                if(!password.equals(userPasswordCheck)){
                    Toast toast = Toast.makeText(getApplicationContext(), "Tus contraseñas no coinciden",  Toast.LENGTH_SHORT);
                    toast.show();
                } else{
                    SharedPreferences preferences = getSharedPreferences("Usuario", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("username", username);
                    editor.putString("password", password);
                    editor.apply();
                }
            }
        });
    }
}