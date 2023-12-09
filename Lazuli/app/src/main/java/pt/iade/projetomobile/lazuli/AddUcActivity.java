package pt.iade.projetomobile.lazuli;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import pt.iade.projetomobile.lazuli.models.UCItem;

public class AddUcActivity extends AppCompatActivity {
    protected EditText nome, prof, sala, desc;

    protected UCItem item;

    private Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduc);

        item = new UCItem(1, "Coraçau", "Happy","Birthday","Today is not my birthday");

        guardar = findViewById(R.id.gButton);
        nome = findViewById(R.id.nomeText);
        prof = findViewById(R.id.profText);
        sala = findViewById(R.id.salaText);
        desc = findViewById(R.id.descText);
        populateView();

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

}