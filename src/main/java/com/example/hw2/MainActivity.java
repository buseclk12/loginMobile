package com.example.hw2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText usernameEditText, passwordEditText;
    TextView registerTextView;
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.editTextTextPersonName);
        passwordEditText = findViewById(R.id.editTextTextPassword);
        registerTextView = findViewById(R.id.textView2);

        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //kayıt olma ekranına geçiş yapma!
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });
        CardView loginCardView = findViewById(R.id.cardView);
        loginCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username= usernameEditText.getText().toString();
                String password= passwordEditText.getText().toString();
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Kullanıcı adı ve şifre gereklidir", Toast.LENGTH_SHORT).show();
                } else {
                    DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());
                    User user = dbHelper.getUser(username, password);

                    if (user != null) {
                        // kullanıcı adı ve şifre doğru
                        Intent intent = new Intent(MainActivity.this, Register.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // kullanıcı adı veya şifre yanlış
                        Toast.makeText(getApplicationContext(), "Kullanıcı adı veya şifre yanlış", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }


}