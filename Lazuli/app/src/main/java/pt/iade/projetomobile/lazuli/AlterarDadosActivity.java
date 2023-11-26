package pt.iade.projetomobile.lazuli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlterarDadosActivity extends AppCompatActivity {

    private Button nome, curso, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterardados);

        nome = (Button) findViewById(R.id.altNomeButton);
        curso = (Button) findViewById(R.id.altCursoButton);
        password = (Button) findViewById(R.id.altPassButton);

        nome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlterarDadosActivity.this, AltNomeActivity.class);
                startActivity(intent);
            }
        });
        curso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlterarDadosActivity.this, AltCursoActivity.class);
                startActivity(intent);
            }
        });
        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlterarDadosActivity.this, AltPasswordActivity.class);
                startActivity(intent);
            }
        });
    }
}