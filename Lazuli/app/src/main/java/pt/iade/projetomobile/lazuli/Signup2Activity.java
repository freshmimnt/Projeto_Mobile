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

import pt.iade.projetomobile.lazuli.models.Curso;
import pt.iade.projetomobile.lazuli.models.User;
import pt.iade.projetomobile.lazuli.retrofit.CursoApi;
import pt.iade.projetomobile.lazuli.retrofit.RetrofitService;
import pt.iade.projetomobile.lazuli.retrofit.UtilizadorApi;

public class Signup2Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText semestreText, turmaText;
    private int cursoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);

        initializeComponents();
    }

    private void initializeComponents(){

        Spinner spinner = findViewById(R.id.curso);
        semestreText = findViewById(R.id.semestre);
        turmaText = findViewById(R.id.turma);

        List<Curso> cursos = new ArrayList<>();
        Curso curso1 = new Curso("Engenharia Informática");
        cursos.add(curso1);
        Curso curso2 = new Curso("Informatica de Gestão");
        cursos.add(curso2);
        Curso curso3 = new Curso("Animação e Criação Visual");
        cursos.add(curso3);
        Curso curso4 = new Curso("Marketing e Publicidade");
        cursos.add(curso4);
        Curso curso5 = new Curso("Ciências da Comunicação");
        cursos.add(curso5);
        Curso curso6 = new Curso("Design");
        cursos.add(curso6);
        Curso curso7 = new Curso("Dupla EI e IG");
        cursos.add(curso7);
        Curso curso8 = new Curso("Design Global");
        cursos.add(curso8);
        Curso curso9 = new Curso("Tecnologias Criativas");
        cursos.add(curso9);
        Curso curso10 = new Curso("Desenvolvimento de Jogos");
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


                User user = new User();
                user.setSemestre(semestre);
                user.setTurma(turma);


            }
        });

        ArrayAdapter<Curso> adapter = new ArrayAdapter<Curso>(this, R.layout.spinner_item, cursos);
        adapter.setDropDownViewResource(R.layout.dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}


