package pt.iade.projetomobile.lazuli;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PessoasActivity extends AppCompatActivity {

    private ImageButton pessoaA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pessoas);
        pessoaA = (ImageButton) findViewById(R.id.pessoaAButton);
        pessoaA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PessoasActivity.this,AddAmigoActivity.class);
                startActivity(intent);
            }
        });
    }
}