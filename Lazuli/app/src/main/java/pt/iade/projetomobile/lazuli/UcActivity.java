package pt.iade.projetomobile.lazuli;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.RecoverySystem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import pt.iade.projetomobile.lazuli.adapters.UCAdapter;
import pt.iade.projetomobile.lazuli.models.UCItem;

public class UcActivity extends AppCompatActivity {
    protected RecyclerView ucListView;
    protected UCAdapter ucAdapter;

    protected ArrayList<UCItem> ucsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uc);

        ucsList = UCItem.List();

        ucAdapter = new UCAdapter(this, ucsList);

        FloatingActionButton fab = findViewById(R.id.floatButton);

        ucListView = findViewById(R.id.ucView);
        ucListView.setLayoutManager(new LinearLayoutManager(this));
        ucListView.setAdapter(ucAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UcActivity.this, AddUcActivity.class);

                intent.putExtra("item",new UCItem());

                startActivity(intent);
            }
        });
    }

}