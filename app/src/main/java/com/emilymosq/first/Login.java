package com.emilymosq.first;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        Button loginButton = findViewById(R.id.loginButton);
        TextView loginRegisterText = findViewById(R.id.loginRegisterText);
        TextInputLayout loginUsernameTIL = findViewById(R.id.loginUsernameTIL);
        TextInputLayout passwordUsernameTIL = findViewById(R.id.loginPasswordTIL);

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String username = String.valueOf(loginUsernameTIL.getEditText().getText()).trim();
                String userpassword = String.valueOf(passwordUsernameTIL.getEditText().getText()).trim();


                if (username.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Ingresa un usuario.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (userpassword.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Ingresa una contraseña.", Toast.LENGTH_SHORT).show();
                }

            SharedPreferences sharedPreferences = getSharedPreferences("Usuario", MODE_PRIVATE);
            String savedUser = sharedPreferences.getString("username", null);
            String savedPassword = sharedPreferences.getString("password", null);

                if(username.equals(savedUser) && userpassword.equals(savedPassword)){
                    launchMain();
                }else{
                    Toast.makeText(getApplicationContext(), "Datos incorrectos", Toast.LENGTH_SHORT).show();
            }


            loginRegisterText.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    launchRegister();
                }
            });
        }

        public void launchMain(){
            Intent intent = new Intent(Login.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        public void launchRegister(){
            Intent intent = new Intent(Login.this, Register.class);
            startActivity(intent);
        }
}