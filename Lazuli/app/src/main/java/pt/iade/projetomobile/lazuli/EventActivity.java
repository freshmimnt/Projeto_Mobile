package pt.iade.projetomobile.lazuli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import pt.iade.projetomobile.lazuli.models.Evento;
import pt.iade.projetomobile.lazuli.views.EventoView;

public class EventActivity extends AppCompatActivity {

    Button add;

    LinearLayout eventosLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        add = findViewById(R.id.criarEvent);
        eventosLayout = (LinearLayout)findViewById(R.id.eventosLayout);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventActivity.this, AddEventActivity.class);
                startActivity(intent);
            }
        });


        showEvent(new Evento("Test evento", 100));
    }

    public void showEvent(Evento evento) {
        EventoView view = new EventoView(this, evento);
        eventosLayout.addView(view);
    }
}