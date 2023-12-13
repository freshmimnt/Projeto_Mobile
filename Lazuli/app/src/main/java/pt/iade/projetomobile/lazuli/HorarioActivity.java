package pt.iade.projetomobile.lazuli;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import pt.iade.projetomobile.lazuli.adapters.CalendarioAdapter;

public class HorarioActivity extends AppCompatActivity implements CalendarioAdapter.OnItemListener{
    private FloatingActionButton fab;
    private TextView month;
    private RecyclerView horarioRecyclerView;
    private LocalDate selectDate;
    private Button next;
    private Button previous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario);
        intWidgets();
        selectDate = LocalDate.now();
        setMonView();

        next = findViewById(R.id.nextMonth);
        previous = findViewById(R.id.previousMonth);
        fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(HorarioActivity.this, AddHorarioActivity.class);
                    startActivity(intent);
                }
            });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextMonthAction();
            }
        });


        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousMonthAction();
            }
        });
    }

    private void setMonView() {
        month.setText(monthOfYear(selectDate));
        ArrayList<String> daysInMonth = daysInMonthArray(selectDate);

        CalendarioAdapter calendarioAdapter = new CalendarioAdapter(daysInMonth, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        horarioRecyclerView.setLayoutManager(layoutManager);
        horarioRecyclerView.setAdapter(calendarioAdapter);
    }

    private ArrayList<String> daysInMonthArray(LocalDate date) {
        ArrayList<String> daysInMonthArray = new ArrayList<>();
        YearMonth yearMonth = YearMonth.from(date);

        int daysInMonth = yearMonth.lengthOfMonth();

        LocalDate firstOfMonth = selectDate.withDayOfMonth(1);
        int dayOfWeek = firstOfMonth.getDayOfWeek().getValue();

        for(int i = 1; i <= 42; i++)
        {
            if(i <= dayOfWeek || i > daysInMonth + dayOfWeek)
            {
                daysInMonthArray.add("");
            }
            else
            {
                daysInMonthArray.add(String.valueOf(i - dayOfWeek));
            }
        }
        return  daysInMonthArray;
    }

    private String monthOfYear(LocalDate date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        return date.format(formatter);
    }

    private void intWidgets() {
        horarioRecyclerView = findViewById(R.id.horarioRecyclerView);
        month = findViewById(R.id.month);
    }
    public void previousMonthAction(){
        selectDate = selectDate.minusMonths(1);
        setMonView();
    }
    public void nextMonthAction(){

        selectDate = selectDate.plusMonths(1);
        setMonView();

    }

    @Override
    public void onItemClick(int position, String dayText) {

        if(!dayText.equals(""))
        {
            String message = "Data escolhida " + dayText + " " + monthOfYear(selectDate);
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }

    }
}