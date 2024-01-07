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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import pt.iade.projetomobile.lazuli.adapters.HorarioAdapter;
import pt.iade.projetomobile.lazuli.adapters.NovoHorarioAdapter;
import pt.iade.projetomobile.lazuli.models.Horario;
import pt.iade.projetomobile.lazuli.utils.HorarioUtils;

public class HorarioActivity extends AppCompatActivity implements HorarioAdapter.OnItemListener{
    private FloatingActionButton fab;
    private TextView month;
    private RecyclerView horarioRecyclerView;
    private Button next;
    private Button previous;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario);
        intWidgets();
        HorarioUtils.selectDate = LocalDate.now();
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
        month.setText(monthOfYear(HorarioUtils.selectDate));
        ArrayList<LocalDate> daysInMonth = daysInMonthArray(HorarioUtils.selectDate);

        HorarioAdapter horarioAdapter = new HorarioAdapter(daysInMonth, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        horarioRecyclerView.setLayoutManager(layoutManager);
        horarioRecyclerView.setAdapter(horarioAdapter);

        setNovoHorarioAdapter();
    }

    private void intWidgets() {
        horarioRecyclerView = findViewById(R.id.horarioRecyclerView);
        month = findViewById(R.id.Week);
        listView = findViewById(R.id.listView);
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

    @Override
    protected void onResume(){
        super.onResume();
        setNovoHorarioAdapter();
    }

    private void setNovoHorarioAdapter() {

        ArrayList<Horario> horarios = Horario.horariosPorDia(HorarioUtils.selectDate);
        NovoHorarioAdapter novoHorarioAdapter = new NovoHorarioAdapter(getApplicationContext(), horarios);
        listView.setAdapter(novoHorarioAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Horario horario = (Horario) parent.getItemAtPosition(position);
            }
        });
    }
}