package pt.iade.projetomobile.lazuli;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.PrimitiveIterator;

import pt.iade.projetomobile.lazuli.adapters.UCAdapter;
import pt.iade.projetomobile.lazuli.models.UCItem;

public class UcActivity extends AppCompatActivity {

    private static final int EDITOR_ACTIVITY_RETURN_ID = 1;

    protected RecyclerView ucListView;
    protected UCAdapter ucAdapter;

    protected ArrayList<UCItem> ucsList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uc);

        ucsList = UCItem.List();

        ucAdapter = new UCAdapter(this, ucsList);
        ucAdapter.setOnClickListener(new UCAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(UcActivity.this, AddUcActivity.class);

                intent.putExtra("item", ucsList.get(position));

                startActivity(intent);
            }
        });

        FloatingActionButton fab = findViewById(R.id.floatButton);

        ucListView = findViewById(R.id.ucView);
        ucListView.setLayoutManager(new LinearLayoutManager(this));
        ucListView.setAdapter(ucAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UcActivity.this, AddUcActivity.class);

                intent.putExtra("item",new UCItem());

                startActivityForResult(intent, EDITOR_ACTIVITY_RETURN_ID);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    if(requestCode == EDITOR_ACTIVITY_RETURN_ID)
        if(resultCode == AppCompatActivity.RESULT_OK){
            UCItem updateItem = (UCItem) data.getSerializableExtra("item");

            ucsList.add(updateItem);
            ucAdapter.notifyItemInserted(ucsList.size()-1);

        }

    }

}