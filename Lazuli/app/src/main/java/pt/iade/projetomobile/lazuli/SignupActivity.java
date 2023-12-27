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

    private EditText nomeEditText, emailEditText, passEditText, repPassEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        initializeComponents();

    }

    private void initializeComponents(){
        nomeEditText = findViewById(R.id.nome);
        emailEditText = findViewById(R.id.email_signup);
        passEditText = findViewById(R.id.pass_Text);
        repPassEditText = findViewById(R.id.reppassText);


        Button nextButton = findViewById(R.id.nextButton);

        RetrofitService retrofitService = new RetrofitService();
        UtilizadorApi utilizadorApi = retrofitService.getRetrofit().create(UtilizadorApi.class);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String nome = nomeEditText.getText().toString();
                    String email = emailEditText.getText().toString();
                    String password = passEditText.getText().toString();
                    String repPassword = repPassEditText.getText().toString();
                    User user = new User();
                    user.setName(nome);
                    user.setEmail(email);
                    user.setPassword(repPassword);
                    utilizadorApi.save(user)
                            .enqueue(new Callback<User>() {
                                @Override
                                public void onResponse(Call<User> call, Response<User> response) {
                                    Toast.makeText(SignupActivity.this, "Dados guardados com sucesso", Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onFailure(Call<User> call, Throwable t) {
                                    Toast.makeText(SignupActivity.this, "Falha ao guardar os dados", Toast.LENGTH_SHORT).show();
                                    Logger.getLogger(SignupActivity.class.getName()).log(Level.SEVERE, "Ocorreu um erro", t);

                                }
                            });

                    Intent intent = new Intent(SignupActivity.this, Signup2Activity.class);
                    startActivity(intent);
            }
        });
    }
}
