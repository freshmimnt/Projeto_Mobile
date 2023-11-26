package pt.iade.projetomobile.lazuli;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class AddPartiActivity extends AppCompatActivity {

    private ImageButton participante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addparti);

        participante =(ImageButton) findViewById(R.id.partiAddButton);
        participante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddPartiActivity.this, "Participante Adicionado", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}