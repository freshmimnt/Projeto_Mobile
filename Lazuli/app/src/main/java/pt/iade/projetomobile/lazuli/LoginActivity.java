package pt.iade.projetomobile.lazuli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import pt.iade.projetomobile.lazuli.models.User;
import pt.iade.projetomobile.lazuli.retrofit.RetrofitService;
import pt.iade.projetomobile.lazuli.retrofit.UtilizadorApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                String emailText = email.getText().toString();
                String passwordText = password.getText().toString();

                if (isValidInput(emailText, passwordText)) {
                    authenticateUser(emailText, passwordText);
                } else {
                    Toast.makeText(LoginActivity.this, "Por favor introduza um email ou password válidos!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidInput(String email, String password) {
        return !email.isEmpty() && !password.isEmpty();
    }

    private void authenticateUser(String email, String password) {
        RetrofitService retrofitService = new RetrofitService();
        UtilizadorApi utilizadorApi = retrofitService.getRetrofit().create(UtilizadorApi.class);

        Map<String, String> credentials = new HashMap<>();
        credentials.put("email", email);
        credentials.put("password", password);

        Call<User> call = utilizadorApi.authenticateUser(credentials);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    User authenticatedUser = response.body();
                    Toast.makeText(LoginActivity.this, "Bem-Vindo, " + authenticatedUser.getName() + "!", Toast.LENGTH_SHORT).show();


                    Intent intent = new Intent(LoginActivity.this, IntroActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Falha na autenticação", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Erro: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
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
