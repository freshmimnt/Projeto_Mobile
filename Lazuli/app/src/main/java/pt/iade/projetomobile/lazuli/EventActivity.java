package pt.iade.projetomobile.lazuli;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class EventActivity extends AppCompatActivity {
    protected TextView titleLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        setupComponents();
    }

    private void setupComponents() {
        titleLabel = (TextView) findViewById(R.id.title_label);
        titleLabel.setText("Test");
    }
}