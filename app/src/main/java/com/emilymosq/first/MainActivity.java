package com.emilymosq.first;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView welcomeText = findViewById(R.id.welcomeText);
        TextView addedText = findViewById(R.id.addedText);

        SharedPreferences sharedPreferences = getSharedPreferences("Usuario", Context.MODE_PRIVATE);
        String nombre = sharedPreferences.getString("userName", "anonimo");
        String password = sharedPreferences.getString("userPassword", "contraseña");

        welcomeText.setText("hola " + nombre);
        addedText.setText("tu contraseña es: " + password);



    }
}