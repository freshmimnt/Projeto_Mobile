package pt.iade.projetomobile.lazuli;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import pt.iade.projetomobile.lazuli.models.Curso;
import pt.iade.projetomobile.lazuli.models.User;
import pt.iade.projetomobile.lazuli.retrofit.CursoApi;
import pt.iade.projetomobile.lazuli.retrofit.RetrofitService;
import pt.iade.projetomobile.lazuli.retrofit.UtilizadorApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Signup2Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    protected User user;
    private EditText semestreText, turmaText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);

        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("user");

        initializeComponents();
    }

    private void initializeComponents(){

        Spinner spinner = findViewById(R.id.curso);
        semestreText = findViewById(R.id.semestre);
        turmaText = findViewById(R.id.turma);

        List<Curso> cursos = new ArrayList<>();
        Curso curso1 = new Curso(1,"Engenharia Informática");
        cursos.add(curso1);
        Curso curso2 = new Curso(2, "Informatica de Gestão");
        cursos.add(curso2);
        Curso curso3 = new Curso(3,"Animação e Criação Visual");
        cursos.add(curso3);
        Curso curso4 = new Curso(4,"Marketing e Publicidade");
        cursos.add(curso4);
        Curso curso5 = new Curso(5,"Ciências da Comunicação");
        cursos.add(curso5);
        Curso curso6 = new Curso(6,"Design");
        cursos.add(curso6);
        Curso curso7 = new Curso(7,"Dupla EI e IG");
        cursos.add(curso7);
        Curso curso8 = new Curso(8,"Design Global");
        cursos.add(curso8);
        Curso curso9 = new Curso(9,"Tecnologias Criativas");
        cursos.add(curso9);
        Curso curso10 = new Curso(10,"Desenvolvimento de Jogos");
        cursos.add(curso10);

        RetrofitService retrofitService = new RetrofitService();
        UtilizadorApi utilizadorApi = retrofitService.getRetrofit().create(UtilizadorApi.class);
        CursoApi cursoApi = retrofitService.getRetrofit().create(CursoApi.class);

        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String semestre = semestreText.getText().toString();
                String turma = turmaText.getText().toString();


                user.setSemestre(semestre);
                user.setTurma(turma);
                utilizadorApi.save(user).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {


                        Toast.makeText(Signup2Activity.this, "Data saved successfully", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(Signup2Activity.this, IntroActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(Signup2Activity.this, "Failed to save data", Toast.LENGTH_SHORT).show();
                        Logger.getLogger(SignupActivity.class.getName()).log(Level.SEVERE, "An error occurred");

                    }
                });


            }
        });

        ArrayAdapter<Curso> adapter = new ArrayAdapter<Curso>(this, R.layout.spinner_item, cursos);
        adapter.setDropDownViewResource(R.layout.dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Curso curso = (Curso) parent.getItemAtPosition(position);
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), curso.getId() + " " + curso.getName(), Toast.LENGTH_SHORT);

        user.setCurso(curso);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}


