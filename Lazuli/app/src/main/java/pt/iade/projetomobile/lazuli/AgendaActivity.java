package pt.iade.projetomobile.lazuli;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import pt.iade.projetomobile.lazuli.adapters.AgendaItemRowAdapter;
import pt.iade.projetomobile.lazuli.models.AgendaItem;

public class AgendaActivity extends AppCompatActivity {
    protected RecyclerView TodoList;
    protected AgendaItemRowAdapter itemRowAdapter;
    protected ArrayList<AgendaItem> itemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        itemRowAdapter = new AgendaItemRowAdapter(this, itemsList);

        TodoList = (RecyclerView) findViewById(R.id.toDoList);
        TodoList.setLayoutManager(new LinearLayoutManager(this));
        TodoList.setAdapter(itemRowAdapter);

        itemsList = AgendaItem.List();

        Animation rotateOpen = AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim);
        Animation rotateClose = AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim);
        Animation fromBottom = AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim);
        Animation toBottom = AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim);
        final boolean[] clicked = {false};

        FloatingActionButton fab = findViewById(R.id.floatButton);
        Button teste = findViewById(R.id.testeButton);
        Button tarefa = findViewById(R.id.tarefaButton);
        Button lemb = findViewById(R.id.lembreteButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onfloatButtonclicked();
            }
            private void onfloatButtonclicked(){
                setClicked(clicked[0]);
                setAnimattion(clicked[0]);
                clicked[0] = !clicked[0];

            }
            private void setClicked(boolean clicked){
                if(!clicked){
                    teste.setVisibility(View.VISIBLE);
                    tarefa.setVisibility(View.VISIBLE);
                    lemb.setVisibility(View.VISIBLE);
                }
                else{
                    teste.setVisibility(View.INVISIBLE);
                    tarefa.setVisibility(View.INVISIBLE);
                    lemb.setVisibility(View.INVISIBLE);

                }

            }
            private void setAnimattion(boolean clicked){
                if(!clicked){
                    teste.startAnimation(fromBottom);
                    tarefa.startAnimation(fromBottom);
                    lemb.startAnimation(fromBottom);
                    fab.startAnimation(rotateOpen);
                }
                else{
                    teste.startAnimation(toBottom);
                    tarefa.startAnimation(toBottom);
                    lemb.startAnimation(toBottom);
                    fab.startAnimation(rotateClose);
                }
            }
        });

        tarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgendaActivity.this, TarefaActivity.class);
                intent.putExtra("item",new AgendaItem());
                startActivity(intent);
            }
        });

        teste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgendaActivity.this, TesteActivity.class);
                startActivity(intent);
            }
        });

        lemb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgendaActivity.this, LembreteActivity.class);
                startActivity(intent);
            }
        });

    }
}


