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

import java.util.GregorianCalendar;
import java.util.Date;

import pt.iade.projetomobile.lazuli.modules.AgendaItem;

public class TarefaActivity extends AppCompatActivity {
    protected AgendaItem item;
    protected EditText title;
    protected EditText description;
    Button guardar;
    private TextView timeText;
    private TextView hourText;
    private Button date;
    private Button hour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa);
        timeText = findViewById(R.id.showTime);
        date = findViewById(R.id.dateButton);
        hourText = findViewById(R.id.showHour);
        hour = findViewById(R.id.hourButton);
        guardar = findViewById(R.id.gButton);

        Intent intent = getIntent();
        item = (AgendaItem) intent.getSerializableExtra("item");

        setUpComponentes();

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        hour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHour();
            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDate();
            }
        });
    }

    private void showDate(){
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                if ((day < 10) && (month < 10)) {
                    timeText.setText("0"+String.valueOf(day)+"/"+"0"+String.valueOf(month+1)+"/"+String.valueOf(year));
                }
                else if(day < 10){
                    timeText.setText("0"+String.valueOf(day)+"/"+String.valueOf(month+1)+"/"+String.valueOf(year));
                }
                else if(month < 10){
                    timeText.setText(String.valueOf(day)+"/"+"0"+String.valueOf(month+1)+"/"+String.valueOf(year));
                }
                else{
                    timeText.setText(String.valueOf(day)+"/"+String.valueOf(month+1)+"/"+String.valueOf(year));
                }
            }
        }, 2023, 0, 01);
        dialog.show();
    }

    private void showHour(){
        TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hour, int minute) {
                if((hour < 10) && (minute < 10)){
                    hourText.setText("0"+String.valueOf(hour)+":"+"0"+String.valueOf(minute));
                }
                else if(minute < 10){
                    hourText.setText(String.valueOf(hour)+":"+"0"+String.valueOf(minute));
                }
                else if(hour < 10){
                    hourText.setText("0"+String.valueOf(hour)+":"+String.valueOf(minute));
                }
                else{
                    hourText.setText(String.valueOf(hour)+":"+String.valueOf(minute));
                }
            }
        }, 06,06, false);
        dialog.show();
    }
    private void setUpComponentes(){
        title = (EditText) findViewById(R.id.nomeText);
        description = (EditText) findViewById(R.id.descText);
        populateView();
    }

    protected void populateView(){
        title.setText(item.getTitle());
        description.setText(item.getDescription());

    }

}
