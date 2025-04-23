package com.example.math;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonCount = findViewById(R.id.button_count);
        buttonCount.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CountActivity.class);
            startActivity(intent);
        });

        Button buttonCompare = findViewById(R.id.button_compare);
        buttonCompare.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CompareActivity.class);
            startActivity(intent);
        });

        Button buttonTasks = findViewById(R.id.button_tasks);
        buttonTasks.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TasksActivity.class);
            startActivity(intent);
        });
    }
}