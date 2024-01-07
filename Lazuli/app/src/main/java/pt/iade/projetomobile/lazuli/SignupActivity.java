package pt.iade.projetomobile.lazuli;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.logging.Level;
import java.util.logging.Logger;

import pt.iade.projetomobile.lazuli.models.User;
import pt.iade.projetomobile.lazuli.retrofit.RetrofitService;
import pt.iade.projetomobile.lazuli.retrofit.UtilizadorApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SignupActivity extends AppCompatActivity {

    private EditText nomeText, emailText, passText, repPassText;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        initializeComponents();
    }

    private void initializeComponents() {
        nomeText = findViewById(R.id.nome);
        emailText = findViewById(R.id.email_signup);
        passText = findViewById(R.id.pass_Text);
        repPassText = findViewById(R.id.reppassText);

        Button nextButton = findViewById(R.id.nextButton);

        RetrofitService retrofitService = new RetrofitService();
        UtilizadorApi utilizadorApi = retrofitService.getRetrofit().create(UtilizadorApi.class);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = nomeText.getText().toString();
                String email = emailText.getText().toString();
                String password = passText.getText().toString();
                String repPassword = repPassText.getText().toString();


                if (nome.isEmpty() || email.isEmpty() || password.isEmpty() || repPassword.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "Please provide all information", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!password.equals(repPassword)) {
                    Toast.makeText(SignupActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }


                User user = new User();
                user.setName(nome);
                user.setEmail(email);
                user.setPassword(password);
                Intent intent = new Intent(SignupActivity.this, Signup2Activity.class);
                intent.putExtra("user", user);
                startActivity(intent);

            }
        });
    }
}

