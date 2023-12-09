package pt.iade.projetomobile.lazuli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import pt.iade.projetomobile.lazuli.models.UCItem;

public class UcActivity extends AppCompatActivity {
    ArrayList<UCItem> itemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uc);

        FloatingActionButton fab = findViewById(R.id.floatButton);

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