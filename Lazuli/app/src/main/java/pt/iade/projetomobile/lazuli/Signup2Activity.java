package pt.iade.projetomobile.lazuli;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Signup2Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText semestreEditText, turmaEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);
        Spinner spinner = findViewById(R.id.curso);
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

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item, getResources().getStringArray(R.array.Cursos));
        adapter.setDropDownViewResource(R.layout.dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private boolean validateSignup2() {
        String semestre = semestreEditText.getText().toString().trim();
        String turma = turmaEditText.getText().toString().trim();

        return !semestre.isEmpty() && !turma.isEmpty();
    }
}
