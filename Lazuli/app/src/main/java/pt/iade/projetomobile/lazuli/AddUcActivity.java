package pt.iade.projetomobile.lazuli;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import pt.iade.projetomobile.lazuli.models.UCItem;

public class AddUcActivity extends AppCompatActivity {
    protected EditText nome, prof, sala, desc;

    protected UCItem item;

    private Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduc);

        Intent intent = getIntent();
        item = (UCItem) intent.getSerializableExtra("item");

        guardar = findViewById(R.id.gButton);
        nome = findViewById(R.id.nomeText);
        prof = findViewById(R.id.profText);
        sala = findViewById(R.id.salaText);
        desc = findViewById(R.id.descText);
        populateView();

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                commitView();
                item.save();

                Intent returnIntent = new Intent();
                returnIntent.putExtra("item", item);
                setResult(AppCompatActivity.RESULT_OK, returnIntent);


                finish();
            }
        });

    }

    protected void populateView(){
        nome.setText(item.getNome());
        sala.setText(item.getSala());
        prof.setText(item.getProf());
        desc.setText(item.getDesc());
    }

    protected void commitView(){
        item.setNome(nome.getText().toString());
        item.setSala(sala.getText().toString());
        item.setProf(prof.getText().toString());
        item.setDesc(desc.getText().toString());
    }

}