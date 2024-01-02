package pt.iade.projetomobile.lazuli;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class LembreteActivity extends AppCompatActivity {

    private Button guardar, date, time;
    private TextView dateText;
    private TextView timeText;

    protected CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lembrete);

        timeText= findViewById(R.id.showTime);
        dateText = findViewById(R.id.showDate);
        date = findViewById(R.id.dateButton);
        time = findViewById(R.id.timeButton);
        guardar = findViewById(R.id.gButton);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
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

    private void showDate() {
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                Calendar calendar = new GregorianCalendar(year, month, day);
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

                dateText.setText(format.format(calendar.getTime()));
            }
        }, 2023, 0, 01);
        dialog.show();
    }

    private void showHour() {
        TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hour, int minute) {
                String timeStr = String.format(Locale.getDefault(), "%02d:%02d", hour, minute);
                dateText.setText(timeStr);
            }
        }, 00, 00, false);
        dialog.show();
    }
}
