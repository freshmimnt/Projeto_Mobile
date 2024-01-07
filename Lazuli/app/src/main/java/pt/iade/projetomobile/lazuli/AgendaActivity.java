package pt.iade.projetomobile.lazuli;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.ArrayList;

import pt.iade.projetomobile.lazuli.adapters.AgendaAdapter;
import pt.iade.projetomobile.lazuli.models.Agenda;
import pt.iade.projetomobile.lazuli.models.LembreteItem;
import pt.iade.projetomobile.lazuli.models.TarefaItem;
import pt.iade.projetomobile.lazuli.models.TesteItem;
import pt.iade.projetomobile.lazuli.models.User;
import pt.iade.projetomobile.lazuli.retrofit.AgendaApi;
import pt.iade.projetomobile.lazuli.retrofit.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AgendaActivity extends AppCompatActivity {

    protected static final int EDITOR_ACTIVITY_RETURN_ID = 1;
    protected RecyclerView TodoList;
    protected AgendaAdapter agendaAdapter;
    protected ArrayList<Object> combinedList = new ArrayList<>();
    protected User user;
    private EditText name;
    private ImageButton save;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == EDITOR_ACTIVITY_RETURN_ID) {
            if (resultCode == AppCompatActivity.RESULT_OK) {
                int position = data.getIntExtra("position", -1);

                Serializable itemSerializable = data.getSerializableExtra("item");
                if (itemSerializable instanceof TarefaItem) {
                    TarefaItem updateItem = (TarefaItem) itemSerializable;

                    if (position == -1) {
                        combinedList.add(updateItem);
                        agendaAdapter.notifyItemInserted(combinedList.size() - 1);
                    } else {
                        combinedList.set(position, updateItem);
                        agendaAdapter.notifyItemChanged(position);
                        boolean removeNote = data.getBooleanExtra("remove", false);
                        if (removeNote) {
                            agendaAdapter.removeItem(position);
                        }
                    }
                } else if (itemSerializable instanceof TesteItem) {
                    TesteItem updateItem = (TesteItem) itemSerializable;

                    if(position == -1){
                        combinedList.add(updateItem);
                        agendaAdapter.notifyItemInserted(combinedList.size()-1);

                    }else{
                        combinedList.set(position, updateItem);
                        agendaAdapter.notifyItemChanged(position);
                        boolean removeNote = data.getBooleanExtra("remove", false);
                        if (removeNote) {
                            agendaAdapter.removeItem(position);
                        }
                    }

                }else if(itemSerializable instanceof LembreteItem){
                    LembreteItem updateItem = (LembreteItem) itemSerializable;

                    if(position == -1){
                        combinedList.add(updateItem);
                        agendaAdapter.notifyItemInserted(combinedList.size()-1);
                    }else{
                        combinedList.set(position, updateItem);
                        agendaAdapter.notifyItemChanged(position);
                        boolean removeNote = data.getBooleanExtra("remove", false);
                        if (removeNote) {
                            agendaAdapter.removeItem(position);
                        }
                    }
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        combinedList.addAll(TarefaItem.List());
        combinedList.addAll(TesteItem.List());
        combinedList.addAll(LembreteItem.List());
        agendaAdapter = new AgendaAdapter(this, combinedList);

        agendaAdapter.setOnClickListener(new AgendaAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // Handle the click for both TarefaItem and TesteItem
                Object clickedItem = combinedList.get(position);
                if (clickedItem instanceof TarefaItem) {
                    Intent intent = new Intent(AgendaActivity.this, TarefaActivity.class);
                    intent.putExtra("position", position);
                    intent.putExtra("item", (TarefaItem) clickedItem);
                    startActivityForResult(intent, EDITOR_ACTIVITY_RETURN_ID);
                } else if (clickedItem instanceof TesteItem) {
                    Intent intent = new Intent(AgendaActivity.this, TesteActivity.class);
                    intent.putExtra("position", position);
                    intent.putExtra("item", (TesteItem) clickedItem);
                    startActivityForResult(intent, EDITOR_ACTIVITY_RETURN_ID);
                }else if (clickedItem instanceof LembreteItem){
                    Intent intent = new Intent(AgendaActivity.this, LembreteActivity.class);
                    intent.putExtra("position", position);
                    intent.putExtra("item", (LembreteItem) clickedItem);
                    startActivityForResult(intent, EDITOR_ACTIVITY_RETURN_ID);
                }
            }
        });

        TodoList = (RecyclerView) findViewById(R.id.toDoList);
        TodoList.setLayoutManager(new LinearLayoutManager(this));
        TodoList.setAdapter(agendaAdapter);

        Animation rotateOpen = AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim);
        Animation rotateClose = AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim);
        Animation fromBottom = AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim);
        Animation toBottom = AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim);
        final boolean[] clicked = {false};

        FloatingActionButton fab = findViewById(R.id.floatButton);
        Button teste = findViewById(R.id.testeButton);
        Button tarefa = findViewById(R.id.tarefaButton);
        Button lemb = findViewById(R.id.lembreteButton);
        name = (EditText)findViewById(R.id.agendaName);

        RetrofitService retrofitService = new RetrofitService();
        AgendaApi agendaApi = retrofitService.getRetrofit().create(AgendaApi.class);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                user = (User) intent.getSerializableExtra("user");
                String nome = name.getText().toString();
                onfloatButtonclicked();

                Agenda agenda = new Agenda();
                agenda.setName(nome);
                agenda.setUser(user);

                agendaApi.save(agenda).enqueue(new Callback<Agenda>() {
                    @Override
                    public void onResponse(Call<Agenda> call, Response<Agenda> response) {
                        Toast.makeText(AgendaActivity.this, "Nome da Agenda Alterado", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Agenda> call, Throwable t) {

                    }
                });

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
                intent.putExtra("position", -1);
                intent.putExtra("item",new TarefaItem());

                startActivityForResult(intent, EDITOR_ACTIVITY_RETURN_ID);
            }
        });

        teste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgendaActivity.this, TesteActivity.class);
                intent.putExtra("position", -1);
                intent.putExtra("item",new TesteItem());

                startActivityForResult(intent, EDITOR_ACTIVITY_RETURN_ID);
            }
        });

        lemb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgendaActivity.this, LembreteActivity.class);
                intent.putExtra("position", -1);
                intent.putExtra("item", new LembreteItem());
                startActivityForResult(intent, EDITOR_ACTIVITY_RETURN_ID);
            }
        });
    }
}


