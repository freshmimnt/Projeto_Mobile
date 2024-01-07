package pt.iade.projetomobile.lazuli;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import java.util.GregorianCalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import pt.iade.projetomobile.lazuli.models.TarefaItem;

public class TarefaActivity extends AppCompatActivity {

    protected TarefaItem item;
    protected EditText title;
    protected EditText description;
    private Button guardar, date, time;
    private TextView dateText, timeText;
    protected CheckBox check;
    protected int listPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa);
        dateText = findViewById(R.id.showDate);
        date = findViewById(R.id.dateButton);
        timeText = findViewById(R.id.showHour);
        time = findViewById(R.id.hourButton);
        guardar = findViewById(R.id.gButton);

        Intent intent = getIntent();
        listPosition = intent.getIntExtra("position", -1);
        item = (TarefaItem) intent.getSerializableExtra("item");

        setUpComponents();

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commitView();
                item.save();
                Intent returnIntent = new Intent();
                returnIntent.putExtra("position", listPosition);
                returnIntent.putExtra("item", item);
                setResult(AppCompatActivity.RESULT_OK, returnIntent);
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
        Calendar currentData = Calendar.getInstance();
        int currentYear = currentData.get(Calendar.YEAR);
        int currentMonth = currentData.get(Calendar.MONTH);
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                Calendar calendar = new GregorianCalendar(year, month, day);
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

                dateText.setText(format.format(calendar.getTime()));
            }
        }, currentYear, currentMonth, 01);
        dialog.show();
    }

    private void showHour() {
        Calendar currentTime = Calendar.getInstance();
        int currentHour = currentTime.get(Calendar.HOUR_OF_DAY);
        int currentMinute = currentTime.get(Calendar.MINUTE);

        TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hour, int minute) {
                String timeStr = String.format(Locale.getDefault(), "%02d:%02d", hour, minute);
                timeText.setText(timeStr);
            }
        }, currentHour, currentMinute, false);
        dialog.show();
    }

    private void setUpComponents() {
        title = findViewById(R.id.nomeText);
        description = findViewById(R.id.descText);
        check = findViewById(R.id.checkBox);

        populateView();
    }

    protected void populateView() {
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

    protected void commitView() {
        item.setTitle(title.getText().toString());
        item.setDone(check.isChecked());
        item.setDescription(description.getText().toString());

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());

        try {
            Date date = dateFormat.parse(dateText.getText().toString());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            item.setDate(calendar);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            Date time = timeFormat.parse(timeText.getText().toString());
            item.setTime(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
