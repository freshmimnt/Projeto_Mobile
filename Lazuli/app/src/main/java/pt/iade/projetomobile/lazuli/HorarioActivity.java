package pt.iade.projetomobile.lazuli;

import static pt.iade.projetomobile.lazuli.utils.HorarioUtils.daysInMonthArray;
import static pt.iade.projetomobile.lazuli.utils.HorarioUtils.monthOfYear;

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

import java.util.ArrayList;
import java.util.Locale;

import pt.iade.projetomobile.lazuli.adapters.HorarioAdapter;
import pt.iade.projetomobile.lazuli.utils.HorarioUtils;

public class HorarioActivity extends AppCompatActivity implements HorarioAdapter.OnItemListener{
    private FloatingActionButton fab;
    private TextView month;
    private RecyclerView horarioRecyclerView;
    private Button next;
    private Button previous;

    private Button weekly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario);
        intWidgets();
        HorarioUtils.selectDate = LocalDate.now();
        setMonView();

        next = findViewById(R.id.nextMonth);
        previous = findViewById(R.id.previousMonth);
        weekly = findViewById(R.id.weekly);
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

        weekly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HorarioActivity.this, HorarioSemanal.class);
                startActivity(intent);
            }
        });
    }

    private void setMonView() {
        month.setText(monthOfYear(HorarioUtils.selectDate));
        ArrayList<LocalDate> daysInMonth = daysInMonthArray(HorarioUtils.selectDate);

        HorarioAdapter horarioAdapter = new HorarioAdapter(daysInMonth, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        horarioRecyclerView.setLayoutManager(layoutManager);
        horarioRecyclerView.setAdapter(horarioAdapter);
    }

    private void intWidgets() {
        horarioRecyclerView = findViewById(R.id.horarioRecyclerView);
        month = findViewById(R.id.Week);
    }
    public void previousMonthAction(){
        HorarioUtils.selectDate = HorarioUtils.selectDate.minusMonths(1);
        setMonView();
    }
    public void nextMonthAction(){

        HorarioUtils.selectDate = HorarioUtils.selectDate.plusMonths(1);
        setMonView();

    }

    @Override
    public void onItemClick(int position, LocalDate date) {
        if(date != null){
            HorarioUtils.selectDate = date;
            setMonView();
        }
    }
}