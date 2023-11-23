package pt.iade.projetomobile.lazuli;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class AddUcActivity extends AppCompatActivity {

    private TextView timeText;
    private TextView hourText;
    private Button date;
    private Button hour;
    private Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adduc);

        timeText = findViewById(R.id.showTime);
        date = findViewById(R.id.dateButton);
        hourText = findViewById(R.id.showHour);
        hour = findViewById(R.id.hourButton);
        guardar = findViewById(R.id.gButton);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDate();
            }
        });
        hour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHour();
            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void showDate(){
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {

                timeText.setText(String.valueOf(day)+"/"+String.valueOf(month+1)+"/"+String.valueOf(year));
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
}