package pt.iade.projetomobile.lazuli;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.SharedPreferences;


public class SignupActivity extends AppCompatActivity {

    private EditText nomeEditText, emailEditText, passEditText, repPassEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        nomeEditText = findViewById(R.id.nome);
        emailEditText = findViewById(R.id.email_signup);
        passEditText = findViewById(R.id.pass_Text);
        repPassEditText = findViewById(R.id.reppassText);

        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateSignup()) {
                        saveNameToSharedPreferences();
                    Intent intent = new Intent(SignupActivity.this, Signup2Activity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(SignupActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validateSignup() {
        String nome = nomeEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String password = passEditText.getText().toString().trim();
        String repPassword = repPassEditText.getText().toString().trim();
        return !nome.isEmpty() && !email.isEmpty() && !password.isEmpty() && password.equals(repPassword);
    }
    private void saveNameToSharedPreferences() {
        String nome = nomeEditText.getText().toString().trim();
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("nome", nome);
        editor.apply();
    }
}
