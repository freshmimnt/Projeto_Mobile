package pt.iade.projetomobile.lazuli;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AddAmigoActivity extends AppCompatActivity {
    private Button amizade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addamigo);

        amizade = (Button) findViewById(R.id.paButton);
        amizade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddAmigoActivity.this, "Pedido Enviado", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

}