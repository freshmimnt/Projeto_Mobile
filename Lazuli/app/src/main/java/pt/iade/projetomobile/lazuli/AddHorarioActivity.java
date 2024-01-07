package pt.iade.projetomobile.lazuli;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.time.LocalTime;
import java.util.Locale;

import pt.iade.projetomobile.lazuli.models.Horario;
import pt.iade.projetomobile.lazuli.utils.HorarioUtils;

public class AddHorarioActivity extends AppCompatActivity {

    private EditText name;

    private Button timeInicio;

    private Button timeFim;

    private Button save;

    private TextView inicio, fim, date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addhorario);

        timeInicio = findViewById(R.id.hour1Button);
        timeFim = findViewById(R.id.hour2Button);
        save = findViewById(R.id.gButton);
        inicio = findViewById(R.id.show1Hour);
        fim = findViewById(R.id.show2Hour);
        date = findViewById(R.id.dayView);
        name = findViewById(R.id.nome);
        date.setText("Dia: " + HorarioUtils.formattedDate(HorarioUtils.selectDate));


        timeInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHourInicio();
            }
        });

        timeFim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHourFim();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = name.getText().toString();


                String inicioText = inicio.getText().toString();
                String fimText = fim.getText().toString();

                LocalTime horaInicio = LocalTime.parse(inicioText);
                LocalTime horaFim = LocalTime.parse(fimText);

                Horario novoHorario = new Horario(1, HorarioUtils.selectDate, horaInicio, horaFim, nome);

                Horario.horarioArrayList.add(novoHorario);

                finish();
            }
        });
    }

    private void showHourInicio() {
        TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hour, int minute) {
                String timeStr = String.format(Locale.getDefault(), "%02d:%02d", hour, minute);
                inicio.setText(timeStr);
            }
        }, 00, 00, false);
        dialog.show();
    }

    private void showHourFim() {
        TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hour, int minute) {
                String timeStr = String.format(Locale.getDefault(), "%02d:%02d", hour, minute);
                fim.setText(timeStr);
            }
        }, 00, 00, false);
        dialog.show();
    }
}