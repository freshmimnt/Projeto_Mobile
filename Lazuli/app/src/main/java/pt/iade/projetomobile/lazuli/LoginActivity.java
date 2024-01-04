package pt.iade.projetomobile.lazuli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button next;
    private EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        next = findViewById(R.id.nextButton);
        email = findViewById(R.id.emailText);
        password = findViewById(R.id.passText);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidInput(email.getText().toString(), password.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "Bem Vindo", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, IntroActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Por favor insira um email e password!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidInput(String email, String password) {
        return !email.isEmpty() && !password.isEmpty();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("username", email.getText().toString());
        outState.putString("password", password.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        email.setText(savedInstanceState.getString("username", ""));
        password.setText(savedInstanceState.getString("password", ""));
    }
}
