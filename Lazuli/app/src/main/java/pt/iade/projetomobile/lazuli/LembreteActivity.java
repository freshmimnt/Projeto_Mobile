package pt.iade.projetomobile.lazuli;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import pt.iade.projetomobile.lazuli.models.LembreteItem;

public class LembreteActivity extends AppCompatActivity {

    protected LembreteItem item;
    private Button guardar, date, time;
    private TextView dateText, timeText, title, description;
    protected CheckBox check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lembrete);

        timeText= findViewById(R.id.showTime);
        dateText = findViewById(R.id.showDate);
        date = findViewById(R.id.dateButton);
        time = findViewById(R.id.timeButton);
        guardar = findViewById(R.id.gButton);

        Intent intent  = getIntent();
        item = (LembreteItem) intent.getSerializableExtra("item");

        setUpComponents();

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
                timeText.setText(timeStr);
            }
        }, 00, 00, false);
        dialog.show();
    }

    private void setUpComponents(){
        title = findViewById(R.id.nomeText);
        description = findViewById(R.id.descText);
        check = findViewById(R.id.checkBox);

        populateView();
    }

    protected void populateView(){
        title.setText(item.getTitle());
        description.setText(item.getDescription());
        check.setChecked(item.isDone());

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());

        if (item.getDate() != null) {
            dateText.setText(dateFormat.format(item.getDate().getTime()));
        }

        if (item.getTime() != null) {
            dateText.setText(timeFormat.format(item.getTime()));
        }
    }
}
