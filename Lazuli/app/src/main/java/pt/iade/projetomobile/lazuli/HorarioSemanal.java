package pt.iade.projetomobile.lazuli;

import static pt.iade.projetomobile.lazuli.utils.HorarioUtils.daysInMonthArray;
import static pt.iade.projetomobile.lazuli.utils.HorarioUtils.daysInWeekArray;
import static pt.iade.projetomobile.lazuli.utils.HorarioUtils.monthOfYear;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.time.LocalDate;
import java.util.ArrayList;

import pt.iade.projetomobile.lazuli.adapters.HorarioAdapter;
import pt.iade.projetomobile.lazuli.utils.HorarioUtils;

public class HorarioSemanal extends AppCompatActivity implements HorarioAdapter.OnItemListener{

    private TextView week;
    private RecyclerView horarioRecyclerView;

    private Button next;

    private Button previous;

    private FloatingActionButton add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_semanal);

        intWidgets();
        setWeekView();

        next = findViewById(R.id.nextWeek);

        previous = findViewById(R.id.previousWeek);

        add = findViewById(R.id.fab);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HorarioUtils.selectDate = HorarioUtils.selectDate.plusWeeks(1);
                setWeekView();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HorarioUtils.selectDate = HorarioUtils.selectDate.minusWeeks(1);
                setWeekView();
            }
        });


    }

    private void setWeekView() {
        week.setText(monthOfYear(HorarioUtils.selectDate));
        ArrayList<LocalDate> daysInWeek = daysInWeekArray(HorarioUtils.selectDate);

        HorarioAdapter horarioAdapter = new HorarioAdapter(daysInWeek, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        horarioRecyclerView.setLayoutManager(layoutManager);
        horarioRecyclerView.setAdapter(horarioAdapter);
    }




    private void intWidgets() {
        horarioRecyclerView = findViewById(R.id.horarioRecyclerView);
        week = findViewById(R.id.Week);
    }

    @Override
    public void onItemClick(int position, LocalDate date) {
        HorarioUtils.selectDate = date;
        setWeekView();
    }
}