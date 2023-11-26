package pt.iade.projetomobile.lazuli;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup2Activity extends AppCompatActivity {

    private EditText cursoEditText, semestreEditText, turmaEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);

        cursoEditText = findViewById(R.id.curso);
        semestreEditText = findViewById(R.id.semestre);
        turmaEditText = findViewById(R.id.turma);

        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateSignup2()) {
                    Intent intent = new Intent(Signup2Activity.this, IntroActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(Signup2Activity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validateSignup2() {
        String curso = cursoEditText.getText().toString().trim();
        String semestre = semestreEditText.getText().toString().trim();
        String turma = turmaEditText.getText().toString().trim();

        return !curso.isEmpty() && !semestre.isEmpty() && !turma.isEmpty();
    }
}
